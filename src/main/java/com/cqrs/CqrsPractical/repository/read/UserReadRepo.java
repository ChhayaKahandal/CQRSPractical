package com.cqrs.CqrsPractical.repository.read;

import com.cqrs.CqrsPractical.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserReadRepo extends JpaRepository<User, Long>
{
    List<User> findByDeletedFalse();
    Optional<User> findByIdAndDeletedFalse(Long id);
}

