package com.hds.boot.config;

import com.hds.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //This is a config class. replace the config file befor.
public class AppConfig {


    @Bean //replace Bean tag befor
    public User user(){
        var user = new User();
        user.setId(1L);
        user.setName("Luck");
        return user;
    }
}
