package com.blog.api.controller;

import java.util.List;

import com.blog.api.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.api.payload.UserDto;
import com.blog.api.services.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping()
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto createUser = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	
	}
	
	
	@GetMapping("/list")
	public List<UserDto> getAllUsers(){
		
		List<UserDto> allUser = this.userService.getAllUser();
		
		return allUser;
		
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Long userId){

		UserDto userDto1 = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<>(userDto1,HttpStatus.OK);


	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long userId){

		this.userService.deleteUser(userId);

		return new ResponseEntity<>(new ApiResponse("User Deleted Sucessfully",true),HttpStatus.OK);



	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId")Long UserId){
		UserDto userById = this.userService.getUserById(UserId);
		return new ResponseEntity<>(userById,HttpStatus.OK);

	}


}
