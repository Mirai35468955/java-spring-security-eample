package io.example.configuration;

import io.example.domain.model.User;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration @EnableMongoAuditing
public class MongoConfig {

    @Bean
    public AuditorAware<ObjectId> auditorProvider() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = null;
            if (authentication != null) {
                user = (User) authentication.getPrincipal();
            }
            return user == null ? Optional.empty() : Optional.of(user.getId());
        };
    }

}