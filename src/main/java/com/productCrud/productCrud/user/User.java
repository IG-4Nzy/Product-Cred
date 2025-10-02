package com.productCrud.productCrud.user;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private ObjectId id;
    private String name;
    private Long number;
}
