package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.res.UserRes;

public interface UserService {
	UserRes findUserId(Integer userId);
}
