package org.example;

import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
      UserMenagementService userMenagementService = new UserMenagementService();

      User arczi3 = User.builder()
              .name("name")
              .surname("surname")
              .email("email@gmail.com")
              .build();;
      User arczi4 = User.builder()
              .name("name")
              .surname("surname")
              .email("email@gmail.com")
              .build();;
       userMenagementService.create(arczi3);
       userMenagementService.create(arczi4);

        System.out.println(userMenagementService.findAll());

    }
}