package com.momoapps.userservice;

import com.momoapps.userservice.dao.UserRepository;
import com.momoapps.userservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        User ali = new User("Ali", "Mohamed", "alimohamed@gmail.com", "123456789");
        User sharuk = new User("Sharukh", "Khan", "Sharukh@gmail.com", "849544544");
        User karishma = new User("Karisma", "Kapoor", "Karisma@gmail.com", "20387461");
        User kajol = new User("Kajol", "Mukerjee", "Kajol@gmail.com", "5255468123");

        userRepository.save(ali);
        userRepository.save(sharuk);
        userRepository.save(karishma);
        userRepository.save(kajol);
    }
}
