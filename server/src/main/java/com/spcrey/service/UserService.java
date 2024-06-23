package com.spcrey.service;

import com.spcrey.pojo.User;

public interface UserService {

    User findByUsername(String username);

    void register(String username, String password);

    void update(User user);
}
