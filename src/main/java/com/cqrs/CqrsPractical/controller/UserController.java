package com.cqrs.CqrsPractical.controller;

import com.cqrs.CqrsPractical.dto.UserRequest;
import com.cqrs.CqrsPractical.entity.User;
import com.cqrs.CqrsPractical.service.UserServiceRead;
import com.cqrs.CqrsPractical.service.UserServiceWrite;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceWrite writeService;
    private final UserServiceRead queryService;

    public UserController(UserServiceWrite writeService,
                          UserServiceRead queryService) {
        this.writeService = writeService;
        this.queryService = queryService;
    }

    // ✅ WRITE APIs

    @PostMapping
    public User create(@Valid @RequestBody UserRequest req) {
        return writeService.createUser(req);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @Valid @RequestBody UserRequest req) {
        return writeService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        writeService.delete(id);
    }

    // ✅ READ APIs (FROM READ DB)

    @GetMapping
    public List<User> getAll() {
        return queryService.getAll(); // ✅ FIX
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return queryService.getById(id);
    }
}