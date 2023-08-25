package com.blog.api;

import com.blog.api.repositries.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogAppApi1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserRepo userRepo;

	@Test
	public void respoTest(){
		System.out.println(this.userRepo.getClass().getName());
//		System.out.println(this.userRepo.getClass().getPackageName());

	}

}
