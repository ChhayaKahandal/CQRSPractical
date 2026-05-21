package com.cqrs.CqrsPractical.config;

import com.cqrs.CqrsPractical.enums.DBType;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Slf4j
//public class DBContextHolder
//{
//
//
//    //ThreadLocal means:“Each thread (request) gets its own separate copy of a variable.”
//    //Threadloacl create a separate DBType storage for every request (thread),
//    // so users don’t overwrite each other’s DB selection.”
//    //User A → WRITE DB and User B → READ DB
//    private static final ThreadLocal<DBType> context = new ThreadLocal<>();
//
//    // It is used to SELECT DB (WRITE or READ)
//    public static void set(DBType dbType)
//    {
//        log.info("Switching DB to: {}", dbType);
//        context.set(dbType);//It stores DB type in current thread
//    }
//
//     //It Returns current DB type
//    //used in Routing class
//    public static DBType get()
//    {
//        return context.get();
//    }
//
//
//    //It removes DB selection after request ends.
//    public static void clear()
//    {
//        log.info("Clearing DB context");
//        context.remove();
//    }
//}
