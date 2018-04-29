package com.spring.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.upload.dto.FileDTO;

@Controller
public class FileUploadController {
	
	   @Autowired
	   ServletContext context;
	
	@RequestMapping("/upload")
	public String displayView() {
		return "upload";
	}
	
	@RequestMapping(value = "processFile", method = RequestMethod.POST)
	public String processFile(@ModelAttribute("file") FileDTO file, ModelMap model) {
		 MultipartFile multipartFile = file.getFile();
         String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
         //Now do something with file...
         try {
			FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
		System.out.println(" File Path ====== "+uploadPath+file.getFile().getOriginalFilename());
         
         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         String fileName = multipartFile.getOriginalFilename();
         
         Map<String,List<String>> map = new HashMap<>();
         
         List<String> passResult = new ArrayList<String>();
         List<String> FailResult = new ArrayList<String>();
         
         passResult.add("A");
         passResult.add("B");
         passResult.add("C");
         
         FailResult.add("D");
         FailResult.add("E");
         FailResult.add("F");
         
         map.put("Pass", passResult);
         map.put("Fail",FailResult);
         
         System.out.println("File Name Here = "+fileName);
         model.addAttribute("result", map);
		return "upload";
	}

}
