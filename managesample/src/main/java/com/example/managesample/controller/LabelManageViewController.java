package com.example.managesample.controller;

import com.example.managesample.model.Label;
import com.example.managesample.model.Sample;
import com.example.managesample.service.LabelService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LabelManageViewController {
    private final LabelService labelService;

    public LabelManageViewController(LabelService labelService){
        this.labelService= labelService;
    }

    @GetMapping("/label/manage/edit-label/{id}")
     public String updateLabelView(@PathVariable("id") Integer labelId, Model model){
        Label label= labelService.getLabelById(labelId);
        model.addAttribute("label", label);
        return "UpdateLabelView";
    }

    @GetMapping("/label/manage/add-label/{id}")
    public String addLabelView(@PathVariable("id")Integer sampleId, Model model){
        Label label= new Label();
        model.addAttribute("label", label);
        model.addAttribute("sampleId", sampleId);
        return "AddLabelView";
    }

    @PostMapping("/label/update-label/confirm")
    public String confirmView(@ModelAttribute("label") Label label, Model model){
        model.addAttribute("label", label);
        return "ConfirmUpdateLabelView";
    }

    @GetMapping("/label/manage/delete-label/{id}")
    public String deleteSample(Model model, @PathVariable("id") Integer id){
        Label label= labelService.getLabelById(id);
        model.addAttribute("label", label);
        return "DeleteLabelView";
    }


}
