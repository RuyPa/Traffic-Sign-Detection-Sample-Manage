package com.example.managesample.service;

import com.example.managesample.model.Sample;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface SampleService {
    public Sample addSample(Sample sample, MultipartFile multipartFile) throws IOException;
    public Sample getSampleById(Integer integer);
    public boolean updateSample(Sample sample, Integer id) throws IOException;
    public boolean deleteSample(Integer id) throws IOException;
    public List<Sample> searchSamples(String keyCode, String keyName);
}
