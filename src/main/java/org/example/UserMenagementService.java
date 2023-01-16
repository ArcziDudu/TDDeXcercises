package org.example;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserMenagementService {
    Map<String, User> mapWithUsers = new HashMap<>();
    public void create(User user) {
        if(mapWithUsers.containsKey(user.getEmail())){
            throw new RuntimeException("User with email: ["+user.getEmail()+"] is already created");
        }
        mapWithUsers.put(user.getEmail(), user);
    }

    public List<User> findAll() {
        return new ArrayList<User>(mapWithUsers.values());
    }


    public Optional<User> findByEmail(String email) {
      return Optional.ofNullable(mapWithUsers.get(email));
    }

    public List<User> findByName(String name) {
        return mapWithUsers.values()
                .stream()
                .filter(e->name.equals(e.getName())).collect(Collectors.toList());
    }

    public void update(String email, User userUpdated) {
        if(!mapWithUsers.containsKey(email)){
            throw new RuntimeException("User with email: ["+email+"] doesn't exist");
        }
        if(!email.equals(userUpdated.getEmail())){
            mapWithUsers.remove(email);
        }
        mapWithUsers.put(userUpdated.getEmail(), userUpdated);
    }

    public void delete(String email) {
        if(!mapWithUsers.containsKey(email)){
            throw new RuntimeException("User with email: ["+email+"] doesn't exist");
        }
        mapWithUsers.remove(email);
    }
}
