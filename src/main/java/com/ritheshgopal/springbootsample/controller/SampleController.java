package com.ritheshgopal.springbootsample.controller;

import com.ritheshgopal.springbootsample.dao.CassandraDao;
import com.ritheshgopal.springbootsample.entity.Person;
import com.ritheshgopal.springbootsample.entity.Sample;
import com.ritheshgopal.springbootsample.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class SampleController {
    @Autowired
    SampleRepository sampleRepository;

    @Autowired
    CassandraDao cassandraDao;

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public List<Sample> greeting(@RequestParam(value="name", defaultValue="World") String name) {

        Sample sample = new Sample();
        sample.setAddress("BLR");
        sampleRepository.save(sample);


        return sampleRepository.findByAddress("BLR");
    }
    @RequestMapping(value="/cassandra", method = RequestMethod.POST)
    public Person cassandra() {

        Person person = new Person(UUID.randomUUID().toString(), "Jon Doe", 40);
        return cassandraDao.save(person);
    }
}
