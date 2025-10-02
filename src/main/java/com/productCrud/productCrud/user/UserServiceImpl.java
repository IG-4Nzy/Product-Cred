package com.productCrud.productCrud.user;

import com.productCrud.productCrud.user.dto.UserDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        repository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(String id, UserDto userDto) {
        ObjectId objId = new ObjectId(id);

        return repository.findById(objId)
                .map(user -> {
                    user.setName(userDto.getName());
                    user.setNumber(userDto.getNumber());
                    repository.save(user);
                    return UserMapper.toDto(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }


    @Override
    public boolean deleteUser(String id) {
        ObjectId objId = new ObjectId(id);

        if(repository.findById(objId).isPresent()){
            repository.deleteById(objId);
            return true;
        }else return false;
    }

    @Override
    public List<UserDto> getUserList(String id, String name) {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(User::getName))
                .filter(u -> id == null || u.getId().equals(new ObjectId(id)))
                .filter(u -> name == null || u.getName().toLowerCase().contains(name.toLowerCase()))
                .map(UserMapper::toDto)
                .toList();
    }
}
