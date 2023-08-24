package com.blog.api.services;

import java.util.List;

//import com.blog.api.entities.User;
import com.blog.api.payload.UserDto;

public interface UserService {
	
	 UserDto createUser(UserDto user);
	 UserDto updateUser(UserDto user,Long userId);
	 UserDto getUserById(Long userId);
	 List<UserDto> getAllUser();
	 void deleteUser(Long userId);

}
