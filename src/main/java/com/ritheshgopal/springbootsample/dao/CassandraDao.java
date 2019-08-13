package com.ritheshgopal.springbootsample.dao;

import com.ritheshgopal.springbootsample.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

@Component
public class CassandraDao {
    @Autowired
    private CassandraTemplate cassandraTemplate;


    public Person save(Person person){
        Person res = null;
        try {
            res = cassandraTemplate.insert(person);
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return res;
    }
}
