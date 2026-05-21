package com.cqrs.CqrsPractical.service;

import com.cqrs.CqrsPractical.entity.User;
import com.cqrs.CqrsPractical.repository.read.UserReadRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceRead
{



        private final UserReadRepo userReadRepo;

        public UserServiceRead(UserReadRepo userReadRepo) {
            this.userReadRepo = userReadRepo;
        }

        public List<User> getAll() {
            return userReadRepo.findByDeletedFalse();
        }

        public User getById(Long id) {
            return userReadRepo.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> new RuntimeException("User not found in READ DB"));
        }
    }

