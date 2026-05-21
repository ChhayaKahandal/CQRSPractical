package com.cqrs.CqrsPractical.service;

import com.cqrs.CqrsPractical.dto.UserRequest;
import com.cqrs.CqrsPractical.entity.User;
import com.cqrs.CqrsPractical.exception.ResourceNotFoundException;
import com.cqrs.CqrsPractical.repository.read.UserReadRepo;
import com.cqrs.CqrsPractical.repository.write.UserWriteRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceWrite {





        private final UserWriteRepo userRepo;
        private final UserSyncService syncService;

        public UserServiceWrite(UserWriteRepo userRepo,
                                UserSyncService syncService) {
            this.userRepo = userRepo;
            this.syncService = syncService;
        }

        // ✅ CREATE
        public User createUser(UserRequest req) {

            User user = new User();
            user.setName(req.getName());
            user.setEmail(req.getEmail());
            user.setAge(req.getAge());
            user.setCity(req.getCity());
            user.setPhone(req.getPhone());

            User saved = userRepo.save(user);

            // ✅ sync to READ DB
            syncService.sync(saved);

            return saved;
        }

        // ✅ READ (from READ DB via controller/service)
        public List<User> getAll() {
            throw new RuntimeException("Use Read Service");
        }

        // ✅ UPDATE
        public User update(Long id, UserRequest req) {

            User user = userRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            user.setName(req.getName());
            user.setEmail(req.getEmail());
            user.setAge(req.getAge());
            user.setCity(req.getCity());
            user.setPhone(req.getPhone());

            User updated = userRepo.save(user);

            syncService.sync(updated);

            return updated;
        }

        // ✅ DELETE
        public void delete(Long id) {

            User user = userRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            user.setDeleted(true);

            userRepo.save(user);

            syncService.sync(user);
        }
    }