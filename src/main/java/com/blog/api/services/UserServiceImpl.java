package com.blog.api.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.exception.*;
import com.blog.api.entities.User;
import com.blog.api.payload.UserDto;
import com.blog.api.repositries.UserRepo;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User dtoToUser = this.dtoToUser(userDto);
		User save = this.userRepo.save(dtoToUser);
		UserDto resultDto = this.userToDto(save);
		return resultDto;
	}

	@Override
	public UserDto updateUser(UserDto dto, Long userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		user.setName(dto.getName());
		user.setAbout(dto.getAbout());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		User user2 = this.userRepo.save(user);
		UserDto userToDto = this.userToDto(user2);
		return userToDto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		UserDto userToDto = this.userToDto(user);
		// TODO Auto-generated method stub
		return userToDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> findAll = this.userRepo.findAll();
		List<UserDto> collect = findAll.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
			this.userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto dto) {
		
		User userMap = modelMapper.map(dto, User.class);
		
		return userMap;
		
	}
	private UserDto userToDto(User user) {
		
		UserDto dto = modelMapper.map(user, UserDto.class);
		return dto;
		
	}

}
