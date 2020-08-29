package com.zun.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public List<User> retrieveAllUsers(){
        return userDao.findAll();
    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDao.findById(id);

        if(user == null) throw new UserNotFoundException("id-" + id);

        return user;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDao.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        User deletedUser = userDao.deleteById(id);

        if(deletedUser == null) throw new UserNotFoundException("id-" + id);
    }

}
