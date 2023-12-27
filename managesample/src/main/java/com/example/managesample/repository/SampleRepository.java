package com.example.managesample.repository;

import com.example.managesample.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Integer> {
    List<Sample> findByCodeContainsOrNameContains(String keyCode, String keyName);
}
