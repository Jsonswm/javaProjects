package com.ming.logistics.controller;

import com.ming.logistics.service.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/111")
public class PdfController {

//    @Autowired
//    private PdfGenerator pdfGenerator;
//
//    @PostMapping("/generatePdf")
//    public ResponseEntity<Void> generatePdf(@RequestBody String data, @RequestParam String fileName){
//        try{
//            pdfGenerator.generatePdf(data,fileName);
//           return ResponseEntity.ok().build();
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
}
