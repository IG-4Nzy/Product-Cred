package com.productCrud.productCrud.user;

import com.productCrud.productCrud.user.dto.UserDto;
import org.bson.types.ObjectId;

public class UserMapper {
    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId().toString());
        dto.setName(user.getName());
        dto.setNumber(user.getNumber());
        return dto;
    }

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId() != null ? new ObjectId(dto.getId()) : new ObjectId());
        user.setName(dto.getName());
        user.setNumber(dto.getNumber());
        return user;
    }
}
