package com.cqrs.CqrsPractical.repository.write;

import com.cqrs.CqrsPractical.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserWriteRepo extends JpaRepository<User, Long> {

    //List<User> findByDeletedFalse();

   Optional<User> findByIdAndDeletedFalse(Long id);
    // CQRS Batch Sync given time ke baad updated data dega
  //  List<User> findByUpdatedAtAfter(LocalDateTime time);

}