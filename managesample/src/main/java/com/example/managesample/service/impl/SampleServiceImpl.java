package com.example.managesample.service.impl;

import com.example.managesample.model.Sample;
import com.example.managesample.repository.SampleRepository;
import com.example.managesample.service.LabelService;
import com.example.managesample.service.SampleService;
import com.example.managesample.util.MultipartFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {
    private final SampleRepository sampleRepository;
    private final LabelService labelService;

    public SampleServiceImpl(SampleRepository sampleRepository,
                             LabelService labelService){
        this.sampleRepository= sampleRepository;
        this.labelService = labelService;
    }



    @Override
//    public Sample addSample(Sample sample, MultipartFile multipartFile) throws IOException {
//        String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        sample.setName(fileName);
//        MultipartFileUtil.createLabelFile(sample.getName());
//        sample= sampleRepository.save(sample);
//        String upload = "D:\\test flask cors\\retrain\\images\\train";
//        MultipartFileUtil.createFile(upload, fileName, multipartFile);
//        sample.setPath(upload + "\\" + fileName);
//        sample= sampleRepository.save(sample);
//        return sampleRepository.save(sample);
//    }
    public Sample addSample(Sample sample, MultipartFile multipartFile) throws IOException {
//        String pathh= sample.getPath().replace(",", "");
//        sample.setPath(pathh);
        sample.setPath("D:\\test flask cors\\data\\images\\train");
        String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
        sample.setName(fileName);
        System.out.println(sample.getPath());
        MultipartFileUtil.createLabelFile(sample);
        sample= sampleRepository.save(sample);
        String upload = sample.getPath();
        MultipartFileUtil.createFile(upload, fileName, multipartFile);
        sample.setPath(upload + "\\" + fileName);
        sample= sampleRepository.save(sample);
        return sampleRepository.save(sample);
    }

    @Override
    public Sample getSampleById(Integer id) {
        return sampleRepository.getById(id);
    }

//    need to update label file name
    @Override
    public boolean updateSample(Sample sample, Integer id) throws IOException {
        MultipartFileUtil.deleteLabelFile(sampleRepository.getById(id));
        labelService.generateLabelFile(sample);
        String newName= sample.getName();
        MultipartFileUtil.updateFile(sampleRepository.getById(id), newName);
//        String newPath= "D:\\test flask cors\\data\\images\\train\\" + sample.getName();
        String samplePath = sample.getPath();
        String newPath = samplePath.substring(0, samplePath.lastIndexOf("\\")) + "\\" + sample.getName();
        sample.setPath(newPath);
        sampleRepository.save(sample);
        return false;
    }

    @Override
    public boolean deleteSample(Integer id) throws IOException {
        Sample sample= sampleRepository.getReferenceById(id);
//        MultipartFileUtil.deleteLabelFile(sample.getName());
        MultipartFileUtil.deleteLabelFile(sample);
        MultipartFileUtil.deleteFile(sample);
        sampleRepository.delete(sample);
        return false;
    }

    @Override
    public List<Sample> searchSamples(String keyCode, String keyName) {
        return sampleRepository.findByCodeContainsOrNameContains(keyCode, keyName);
    }
}
