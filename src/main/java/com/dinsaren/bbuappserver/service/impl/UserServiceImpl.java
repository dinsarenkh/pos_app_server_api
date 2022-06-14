package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.res.UserRes;
import com.dinsaren.bbuappserver.repository.UserRepository;
import com.dinsaren.bbuappserver.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

	@Override
	public UserRes findUserId(Integer userId) {
		UserRes res = new UserRes();
		var user = userRepository.findByIdAndStatus(userId, Constants.ACTIVE_STATUS);
		if(user.isPresent()){
			res.setDataRes(user.get());
		}
		return res;
	}
}
