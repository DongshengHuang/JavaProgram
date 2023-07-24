package com.hds.test;

import com.hds.springboottest.SpringbootTestApplication;
import com.hds.springboottest.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

// test class of the userService

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTestApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }
}
