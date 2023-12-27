package com.example.managesample.controller;

import com.example.managesample.model.Label;
import com.example.managesample.repository.SampleRepository;
import com.example.managesample.service.LabelService;
import com.example.managesample.service.SampleService;
import com.example.managesample.util.MultipartFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.example.managesample.model.Sample;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {
    private final SampleService sampleService;
    private final SampleRepository sampleRepository;
    private final LabelService labelService;

    public SampleController(SampleService sampleService,
                            SampleRepository sampleRepository,
                            LabelService labelService){
        this.sampleService= sampleService;
        this.sampleRepository = sampleRepository;
        this.labelService = labelService;
    }

    @PostMapping("/sample/manage/add-sample/add")
    public String addSample(@ModelAttribute("sample") Sample sample,
                            @RequestParam("image") MultipartFile multipartFile,
                            @RequestParam(name = "centerX") String centerX,
                            @RequestParam(name = "centerY") String centerY,
                            @RequestParam(name = "width") String width,
                            @RequestParam(name = "height") String height) throws IOException {
        sample = sampleService.addSample(sample, multipartFile);

        Label newLabel= new Label();
        newLabel.setxCenter(Double.parseDouble(centerX));
        newLabel.setyCenter(Double.parseDouble(centerY));
        newLabel.setHeight(Double.parseDouble(height));
        newLabel.setWidth(Double.parseDouble(width));
        newLabel.setSampleId(sample.getId());
        Sample sample1 = sampleRepository.getById(sample.getId());
        List<Label> labels = new ArrayList<>();
        sample.setLabels(labels);
        sample.getLabels().add(newLabel);
        sampleRepository.save(sample);
        labelService.generateLabelFile(sample);

        return "redirect:/sample/manage";
    }

    @Transactional
    @PostMapping("/sample/update-sample/save/{id}")
    public String updateSample(@ModelAttribute("sample")Sample sample,
                               @PathVariable("id") Integer id) throws IOException {
        sampleService.updateSample(sample, id);
        return "ManageSampleView";
    }

    @GetMapping("/sample/manage/get-sample/get")
    public String getSample(@RequestParam(name = "key") String key,
                            Model model){
        List<Sample> samples= sampleService.searchSamples(key, key);
        model.addAttribute("samples", samples);
        return "GetSampleView";
    }

    @PostMapping("/sample/delete-sample/delete/{id}")
    public String deleteSample(@PathVariable("id") Integer id) throws IOException {
        sampleService.deleteSample(id);
        return "redirect:/sample/manage";
    }
}


