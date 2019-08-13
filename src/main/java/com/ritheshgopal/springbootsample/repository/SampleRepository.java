package com.ritheshgopal.springbootsample.repository;

import com.ritheshgopal.springbootsample.entity.Sample;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends PagingAndSortingRepository<Sample, Integer> {

    List<Sample> findByAddress(String address);
}
