package com.blog.api.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


public class UserDto {
	
	private long id;
	@NotBlank
	@Size(min=4,message = "Please enter atleast size 4")
	private String name;
	@Email
	private String email;
	@NotEmpty()
	@Size(min=4,message = "Please enter atleast size 4")
	private String password;
	@NotNull
	@Size(min=10,message = "Please enter atleast size 10")
	private String about;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
