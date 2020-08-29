package com.zun.webservices.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDao {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User toSave){
        if(toSave.getId() == null){
            toSave.setId(++usersCount);
        }
        users.add(toSave);
        return toSave;
    }

    public User findById(int id){
        return users.stream().filter(i -> id == i.getId()).findFirst().orElse(null);
    }

    public User deleteById(int id){
        User toReturn = findById(id);
        if(toReturn != null){
            users.remove(toReturn);
        }
        return toReturn;
    }

}
