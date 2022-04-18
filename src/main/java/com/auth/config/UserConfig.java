package com.auth.config;

import com.auth.model.User;
import com.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository) {
        return args -> {
            User orisys01 = new User("orisys01","111");
            User orisys02 = new User("orisys02","222");
            User orisys03 = new User("orisys03","333");
            userRepository.saveAll(List.of(orisys01,orisys02,orisys03));
        };
    }
}
