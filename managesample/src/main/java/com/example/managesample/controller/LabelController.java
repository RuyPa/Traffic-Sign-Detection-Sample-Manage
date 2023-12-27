package com.example.managesample.controller;

import com.example.managesample.model.Label;
import com.example.managesample.model.Sample;
import com.example.managesample.repository.LabelRepository;
import com.example.managesample.repository.SampleRepository;
import com.example.managesample.service.LabelService;
import com.example.managesample.util.MultipartFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class LabelController {

    private final SampleRepository sampleRepository;
    private  final LabelService labelService;

    public LabelController(SampleRepository sampleRepository,
                           LabelService labelService){
        this.labelService= labelService;
        this.sampleRepository= sampleRepository;
    }

    @PostMapping("/label/manage/add-label/add/{id}")
    public String addLabel(@ModelAttribute("label") Label label,
                            @PathVariable("id") Integer sampleId) throws IOException {
        Label newLabel= new Label(label);
        newLabel.setSampleId(sampleId);
        Sample sample = sampleRepository.getById(sampleId);
        sample.getLabels().add(newLabel);
        sampleRepository.save(sample);
        labelService.generateLabelFile(sample);
        return "redirect:/sample/manage/update-sample/{id}";
    }

    @Transactional
    @PostMapping("/label/update-label/save/{id}")
    public String updateLabel(@ModelAttribute("label")Label label,
                               @PathVariable("id") Integer id) throws IOException {
        labelService.updateLabel(label, id);
        Integer sampleId= label.getSampleId();
        labelService.generateLabelFile(sampleRepository.getById(label.getSampleId()));
        return "redirect:/sample/manage/update-sample/" + sampleId;
    }

    @PostMapping("/label/delete-label/delete/{id}")
    public String deleteSample(@PathVariable("id") Integer id) throws IOException {
        Integer sampleId = labelService.getLabelById(id).getSampleId();
        labelService.deleteSample(id);
        labelService.generateLabelFile(sampleRepository.getById(sampleId));
        return "redirect:/sample/manage/update-sample/" + sampleId;
    }
}
