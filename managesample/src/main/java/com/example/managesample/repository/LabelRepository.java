package com.example.managesample.repository;

import com.example.managesample.model.Label;
import com.example.managesample.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {
    List<Label> getAllBySampleId(Integer integer);
}
