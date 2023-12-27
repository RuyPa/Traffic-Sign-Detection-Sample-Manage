package com.example.managesample.controller;

import com.example.managesample.model.Sample;
import com.example.managesample.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleManageViewController {
    final private SampleService sampleService;

    public SampleManageViewController(SampleService sampleService){
        this.sampleService= sampleService;
    }

    @GetMapping("/sample/manage/add-sample")
    public String addSample(Model model){
        Sample sample= new Sample();
        model.addAttribute("sample", sample);
        return "AddSampleView";
    }

    @GetMapping("/sample/manage/update-sample")
    public String updateSample(){
        return "GetSampleView";
    }

    @GetMapping("/sample/manage/get-sample")
    public String getSample(){
        return "GetSampleView";
    }

    @GetMapping("/sample/manage/delete-sample")
    public String deleteSample(){
        return "GetSampleView";
    }

    @GetMapping("/sample/manage/update-sample/{id}")
    public String updateSample(Model model, @PathVariable("id") Integer id ){
        Sample sample= sampleService.getSampleById(id);
        model.addAttribute("sample", sample);
        return "UpdateSampleView";
    }

    @PostMapping("/sample/update-sample/confirm")
    public String confirmView(@ModelAttribute("sample") Sample sample, Model model){
        model.addAttribute("sample", sample);
        return "ConfirmUpdateSampleView";
    }

    @GetMapping("/sample/manage/delete-sample/{id}")
    public String deleteSample(Model model, @PathVariable("id") Integer id){
        Sample sample= sampleService.getSampleById(id);
        model.addAttribute("sample", sample);
        return "DeleteSampleView";
    }
}
