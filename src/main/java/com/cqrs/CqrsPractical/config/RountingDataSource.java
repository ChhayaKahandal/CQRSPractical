//package com.cqrs.CqrsPractical.config;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
///*This class is custom database router which is used to decide
// which database to use (READ or WRITE) at runtime.
// */
//public class RountingDataSource extends AbstractRoutingDataSource
//{
//
//    @Override
//    protected Object determineCurrentLookupKey()
//    {
//        //This ask the DBContextHolder: Which DB is selected (READ or WRITE)?
//        return DBContextHolder.get();
//    }
//}
