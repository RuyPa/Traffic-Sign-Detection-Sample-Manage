package com.example.managesample.service.impl;

import com.example.managesample.model.Label;
import com.example.managesample.model.Sample;
import com.example.managesample.repository.LabelRepository;
import com.example.managesample.repository.SampleRepository;
import com.example.managesample.service.LabelService;
import com.example.managesample.util.MultipartFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class LabelServiveImpl implements LabelService {
    private final LabelRepository labelRepository;
    private final SampleRepository sampleRepository;

    public LabelServiveImpl(LabelRepository labelRepository,
                            SampleRepository sampleRepository){
        this.labelRepository= labelRepository;
        this.sampleRepository= sampleRepository;
    }

    @Override
    public Label addLabel(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public Label getLabelById(Integer labelId) {
        return labelRepository.getById(labelId);
    }

    @Override
    public boolean updateLabel(Label label, Integer id) throws IOException {
        Label newLabel= labelRepository.getById(id);
        newLabel.setSampleId(label.getSampleId());
        newLabel.setHeight(label.getHeight());
        newLabel.setWidth(label.getWidth());
        newLabel.setxCenter(label.getxCenter());
        newLabel.setyCenter(label.getyCenter());
        labelRepository.save(newLabel);
        return true;
    }

    @Override
    public boolean deleteSample(Integer id) {
        labelRepository.deleteById(id);
        return true;
    }

    @Override
    public void generateLabelFile(Sample sample) throws IOException {
        MultipartFileUtil.deleteLabelFile(sample);
        List<Label> labels = labelRepository.getAllBySampleId(sample.getId());
        String information = "";
        if(!ObjectUtils.isEmpty(labels)){
            for(Label label : labels) {
                information += "0";
                information += " " + label.getxCenter();
                information += " " + label.getyCenter();
                information += " " + label.getWidth();
                information += " " + label.getHeight() + "\n";
            }
        }
//        MultipartFileUtil.generateLabelHavingInfor(sample.getName(), information);
        MultipartFileUtil.generateLabelHavingInfor(sample, information);
        System.out.println(information);
    }
}
