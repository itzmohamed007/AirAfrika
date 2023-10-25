package com.youcode.airafrika;

import com.youcode.airafrika.services.AdminService;

import java.util.Scanner;

public class Testing {
    // Created for testing
    // Testing admin login method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your email");
        String email = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();
        AdminService adminService = new AdminService();
        if(adminService.login(email, password)) {
            System.out.println("Admin Account found successfully");
        } else {
            System.out.println("Admin account not found");
        }
    }
}
