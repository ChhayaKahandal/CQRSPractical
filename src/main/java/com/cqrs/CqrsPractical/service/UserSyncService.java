package com.cqrs.CqrsPractical.service;

import com.cqrs.CqrsPractical.config.DBContextHolder;
import com.cqrs.CqrsPractical.entity.User;
import com.cqrs.CqrsPractical.enums.DBType;
import org.springframework.stereotype.Service;

@Service
public class UserSyncService {

    private final ReadTxService readTxService;

    public UserSyncService(ReadTxService readTxService) {
        this.readTxService = readTxService;
    }

    public void sync(User user) {

       // DBContextHolder.set(DBType.READ);

        try {
            readTxService.sync(user); // ✅ transactional method
        } finally {
           // DBContextHolder.clear();
        }
    }
}