/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.it.mavenproject1.service;

import java.util.ArrayList;
import java.util.List;
import lv.it.mavenproject1.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   String name ="Undine";
    public List<User> userList;

    public List<User> getUserByName(String name) {
        List<User> usersByName = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().matches(name) || user.getSurname().matches(name)) {
                usersByName.add(user);
            }
        }
        return usersByName;
    }
    
     private List<User> hardcodedUserInitialization() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            User user = new User(Long.valueOf(i),getAuthorName(i), 
                    "Zarins", Integer.toString(i), getAge(i));
            users.add(user);
        }
        return users;
    }

    public String getAuthorName(int i) {
        if (i % 2 == 0) {
            return "Zane";
        }
        return "Peteris";
    }
    
    public int getAge(int i){
        return i+25;
    }
}
