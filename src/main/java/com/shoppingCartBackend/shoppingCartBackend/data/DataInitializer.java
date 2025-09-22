package com.shoppingCartBackend.shoppingCartBackend.data;

import com.shoppingCartBackend.shoppingCartBackend.model.User;
import com.shoppingCartBackend.shoppingCartBackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener <ApplicationReadyEvent>{
    private final UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        createDefaultUsersIfNotExist();
    }

    private void createDefaultUsersIfNotExist() {
        for(int i=1; i<=5; i++) {
            String defaultEmail = "user"+i+"@gmail.com";
            if(userRepository.existsByEmail(defaultEmail)) {
                continue;
            }
            User user = new User();
            user.setFirstName("User"+i);
            user.setLastName("Userlastname"+i);
            user.setEmail(defaultEmail);
            user.setPassword("1234"+i+i+"332");
            userRepository.save(user);
            System.out.println("Default user" +i+"created successfully");
        }
    }

}
