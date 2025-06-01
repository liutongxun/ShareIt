package com.shareIt.subject.application.controller;

import com.shareIt.subject.infra.basic.entity.SubjectCategory;
import com.shareIt.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/SubjectController")
public class SubjectController {

    @Autowired
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("/test")
    public String test(){
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1l);
        System.out.println(subjectCategory.getCategoryName()+" .........");
        System.out.println(subjectCategory.getCategoryType());

        return "test successfully";
    }

    @GetMapping("/test2")
    public void test2(){
        System.out.println("test successfully");
    }


}
