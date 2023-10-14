package com.youcode.airafrika;

import com.youcode.airafrika.models.User;
import com.youcode.airafrika.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        System.out.println("i'll try to fetch all users using UserService class with the new hibernate configuration");
        UserService userService = new UserService();
        List<User> users = new ArrayList<>();
        users = userService.getAllUsers();

        for(User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
        }
    }
}
