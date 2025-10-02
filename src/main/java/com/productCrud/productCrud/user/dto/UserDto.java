package com.productCrud.productCrud.user.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class UserDto {
    @Id
    private String id;
    private String name;
    private Long number;
}
