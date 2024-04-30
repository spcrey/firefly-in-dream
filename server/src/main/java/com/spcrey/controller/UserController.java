package com.spcrey.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spcrey.form.UserLoginForm;
import com.spcrey.form.UserRegisterForm;
import com.spcrey.pojo.Result;
import com.spcrey.pojo.User;
import com.spcrey.service.UserService;
import com.spcrey.utils.JwtUtil;
import com.spcrey.utils.MD5Util;
import com.spcrey.utils.ThreadLocalUtil;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public Result<String> user() {
        return Result.success("This is user page!");
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody @Validated UserRegisterForm form) {
        String username = form.getUsername();
        String password = form.getPassword();
        String rePassword = form.getRePassword();
        if (!password.equals(rePassword)) {
            return Result.error("inconsistent passwords");
        }
        if (userService.findByUsername(username) != null) {
            return Result.error("username already taken");
        }
        userService.register(username, password);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody @Validated UserLoginForm form) {
        User registeredUser = userService.findByUsername(form.getUsername());
        if(registeredUser == null) {
            return Result.error("error username");
        } 
        if (!MD5Util.StringToMD5(form.getPassword()).equals(registeredUser.getPassword())) {
            return Result.error("error password");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", registeredUser.getId());
        claims.put("username", registeredUser.getUsername());
        String token = JwtUtil.genToken(claims);
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(token, token, 12, TimeUnit.HOURS);
        return Result.success(token);
    }

    @GetMapping("/info")
    public Result<User> info() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUsername(username);
        return Result.success(user);
    }
}
