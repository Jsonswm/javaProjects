package com.ming.logistics.controller;


import com.ming.logistics.service.ProfessionalService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professional")
@CrossOrigin
public class ProfessionalController {
    @Autowired
    private ProfessionalService professionalService;


    @GetMapping
    public Result getAll(){
        return Result.success(professionalService.list());
    }
}
