package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.exception.TokenRefreshException;
import com.dinsaren.bbuappserver.models.RefreshToken;
import com.dinsaren.bbuappserver.models.Role;
import com.dinsaren.bbuappserver.models.User;
import com.dinsaren.bbuappserver.models.UserRole;
import com.dinsaren.bbuappserver.payload.req.LogOutReq;
import com.dinsaren.bbuappserver.payload.req.LoginReq;
import com.dinsaren.bbuappserver.payload.req.RegisterReq;
import com.dinsaren.bbuappserver.payload.req.TokenRefreshReq;
import com.dinsaren.bbuappserver.payload.res.JwtRes;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.payload.res.TokenRefreshRes;
import com.dinsaren.bbuappserver.repository.RoleRepository;
import com.dinsaren.bbuappserver.repository.UserRepository;
import com.dinsaren.bbuappserver.security.jwt.JwtUtils;
import com.dinsaren.bbuappserver.security.services.RefreshTokenService;
import com.dinsaren.bbuappserver.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/oauth")
public class AuthController {
    private MessageRes resMessage;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    @PostMapping("/token")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginReq req) {
        resMessage = new MessageRes();
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(req.getPhone(), req.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
        resMessage.setGetDateMessageSuccess(new JwtRes(jwt, refreshToken.getToken(), userDetails.getId(),
                userDetails.getUsername(), userDetails.getEmail(), roles));
        return ResponseEntity.ok(resMessage);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterReq req) {

        if (userRepository.existsByUsername(req.getUsername())) {
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess("Error: Username is already taken!");
            return ResponseEntity.badRequest().body(new MessageRes());
        }

        if (userRepository.existsByEmail(req.getEmail())) {
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess("Error: Email is already in use!");
            return ResponseEntity.badRequest().body(new MessageRes());
        }

        if (userRepository.existsByPhone(req.getPhone())) {
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess("Error: Phone is already in use!");
            return ResponseEntity.badRequest().body(new MessageRes());
        }

        User user = new User(req.getUsername(), req.getEmail(),
                encoder.encode(req.getPassword()), req.getPhone());

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        user.setRoles(roles);
        user.setAddress(req.getAddress());
        user.setAddress(req.getAddress());
        user.setProfile(req.getProfile());
        user.setNationalId(req.getNationalId());
        user.setNationalImage(req.getNationalImage());
        user.setStatus(Constants.ACTIVE_STATUS);
        userRepository.save(user);
        resMessage = new MessageRes();
        resMessage.setGetDateMessageSuccess("User registered successfully!");
        return ResponseEntity.ok(new MessageRes());
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody TokenRefreshReq request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshRes(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@RequestBody LogOutReq req) {
        refreshTokenService.deleteByUserId(req.getUserId());
        resMessage = new MessageRes();
        resMessage.setGetDateMessageSuccess("Log out successful!");
        return ResponseEntity.ok(new MessageRes());
    }

}
