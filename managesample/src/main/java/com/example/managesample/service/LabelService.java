package com.example.managesample.service;

import com.example.managesample.model.Label;
import com.example.managesample.model.Sample;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface LabelService {
    Label addLabel(Label label);
    Label getLabelById(Integer labelId);
    boolean updateLabel(Label label, Integer id) throws IOException;
    boolean deleteSample(Integer id);
    void generateLabelFile(Sample sample) throws IOException;
}
