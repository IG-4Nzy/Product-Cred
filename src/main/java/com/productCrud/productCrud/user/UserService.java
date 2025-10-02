package com.productCrud.productCrud.user;

import com.productCrud.productCrud.user.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public UserDto updateUser(String id,UserDto userDto);
    public boolean deleteUser (String id);
    public List<UserDto> getUserList(String id,String name);
}
