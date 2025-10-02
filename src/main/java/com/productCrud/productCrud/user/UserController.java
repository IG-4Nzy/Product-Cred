package com.productCrud.productCrud.user;

import com.productCrud.productCrud.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("create-user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto response = userService.createUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id,
                                              @RequestBody UserDto userDto){
        UserDto response = userService.updateUser(id,userDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        boolean deleted = userService.deleteUser(id);
        String response = deleted ? "user deleted":"user not found";
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("get-user-list")
    public ResponseEntity<List<UserDto>> getUserList(@RequestParam(required = false) String id,
                                                     @RequestParam(required = false) String name){
        List<UserDto> response = userService.getUserList(id,name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
