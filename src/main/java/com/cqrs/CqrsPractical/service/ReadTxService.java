package com.cqrs.CqrsPractical.service;

import com.cqrs.CqrsPractical.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadTxService {

    @PersistenceContext(unitName = "read")
    private EntityManager entityManager;

    @Transactional("readTransactionManager")
    public void sync(User writeUser) {

        System.out.println("➡️ Syncing to READ DB: " + writeUser.getId());

        User existing = entityManager.find(User.class, writeUser.getId());

        if (existing == null) {

            User newUser = new User();

            copy(writeUser, newUser);

            // 🔥 FIX HERE
            entityManager.merge(newUser);

        } else {

            copy(writeUser, existing);
        }

        entityManager.flush();

        System.out.println("✅ SYNC DONE");
    }
    private void copy(User src, User dest) {

        // ❌ NEVER TOUCH ID HERE

        dest.setName(src.getName());
        dest.setEmail(src.getEmail());
        dest.setAge(src.getAge());
        dest.setCity(src.getCity());
        dest.setPhone(src.getPhone());
        dest.setDeleted(src.isDeleted());
        dest.setCreatedAt(src.getCreatedAt());
        dest.setUpdatedAt(src.getUpdatedAt());
    }
}