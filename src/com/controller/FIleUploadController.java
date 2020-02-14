package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.model.MyFile;
import com.services.CommonService;

@Controller
@RequestMapping("file")
public class FIleUploadController {
	@Resource
	CommonService commonService;
	
	@RequestMapping("upload")
	public void file_upload(@RequestParam("file")MultipartFile files ,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		
		System.out.println("单文件上传： ");
		
		System.out.println("originalName: "+files.getOriginalFilename());
		System.out.println("2 contentType: "+files.getContentType());
		System.out.println("3 name: "+files.getName());
		System.out.println("4 size: "+files.getSize());
		

		
		if(files.getOriginalFilename() !="") {
			String ss= files.getOriginalFilename().substring(files.getOriginalFilename().indexOf("."));
			
			String path = "E:\\XiaoMi_project\\xm_static\\file";
			String lu= path+"/"+UUID.randomUUID().toString()+ss ;
			
			/*System.out.println("path1: "+path);
			System.out.println("path2 : "+lu);*/
			
			files.transferTo(new File(lu));
			
			response.getWriter().write("true");
		}else {
			response.getWriter().write("false");
		}
		
		
	}
	
	
	@RequestMapping("uploads")
	public void file_upload(@RequestParam("file")MultipartFile[] files ,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		System.out.println("多文件上传： "+files.length);
		
		String path = request.getServletContext().getRealPath("file");
		
		if(files[0].getOriginalFilename() !="") {
			for(MultipartFile file : files) {

				System.out.println("originalName: "+file.getOriginalFilename());
				System.out.println("2 contentType: "+file.getContentType());
				System.out.println("3 name: "+file.getName());
				System.out.println("4 size: "+file.getSize());
				
				
				String ss= file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));			
				
				String lu= path+"/"+UUID.randomUUID().toString()+ss ;
		
				file.transferTo(new File(lu));
				
				
				
			}
			response.getWriter().write("true");
		}else {
			response.getWriter().write("false");
		}
	
		
	}
	

	@RequestMapping("insertFile")
	public void fileInfo(@RequestParam(value = "username")String  username,
						@RequestParam(value = "description")String description,
						@RequestParam(value = "text" ,required=false)MultipartFile text,
						@RequestParam(value = "picture" , required=false)MultipartFile picture,
			HttpServletResponse response) throws IllegalStateException, IOException {
		System.out.println("文件上传");
		String path = "E:\\XiaoMi_project\\xm_static\\file";
		
		MyFile file = new MyFile();
		file.setUsername(username);
		file.setDescription(description);
		
		if(text.getOriginalFilename() !=""){
			//存到文件服务器
			text.transferTo(  new File( path+"/" + text.getOriginalFilename()));
			//
			
			InputStream fis1 = text.getInputStream();
			
			byte[] buf1 = new byte[fis1.available()];
			fis1.read(buf1);
		
			file.setText(buf1);
		}
		if(picture.getOriginalFilename() != "") {
			//存到文件服务器
//			picture.transferTo(  new File( path+"/" + picture.getOriginalFilename()));
			//
			InputStream fis2 = picture.getInputStream();
		
			
			byte[] buf2 = new byte[fis2.available()];
			fis2.read(buf2);
			
			file.setPicture(buf2);
		}
		
		System.out.println("文件信息："+file);
		
		
		if(commonService.addFile(file)) {
			System.out.println("文件上传成功");
			response.getWriter().write("true");
		}else {
			System.out.println("文件上传失败");
			response.getWriter().write("false");
		}
	}

	
	
	
	

	@RequestMapping("insertfile1")
	public void fileInfo1(@RequestParam(value = "username")String  username,
						@RequestParam(value = "description")String description,
						@RequestParam(value = "text" ,required=false)MultipartFile text,
						@RequestParam(value = "picture" , required=false)MultipartFile picture,
			HttpServletResponse response) throws IllegalStateException, IOException {
		System.out.println(username);
		System.out.println(description);
		System.out.println("文件上传");
		String path = "E:";
		
		
		if(text.getOriginalFilename() !=""){
			//存到文件服务器
			text.transferTo(  new File( path+"/" + text.getOriginalFilename()));
			
			System.out.println("file1:"+text.getOriginalFilename());
			

		}else {
			response.getWriter().write("text false");
		}
		if(picture.getOriginalFilename() != "") {
			//存到文件服务器
			picture.transferTo(  new File( path+"/" + picture.getOriginalFilename()));
			
			System.out.println("fis2:"+picture.getOriginalFilename());
			
			
		}else {
			response.getWriter().write("picture true");
		}
		
	
	}
	@RequestMapping("insertfile2")
	public void fileInfo2(@RequestParam(value = "username")String  username,
						@RequestParam(value = "description")String description,
					
			HttpServletResponse response) throws IllegalStateException, IOException {
		System.out.println("form-data");
		System.out.println(username);
		System.out.println(description);
		
		response.getWriter().write("true");
	
	}
	
	@RequestMapping("insertfile3")
	public void fileInfo3(@RequestParam(value = "username")String  username,
						@RequestParam(value = "description")String description,
					
			HttpServletResponse response) throws IllegalStateException, IOException {
		System.out.println("get data");
		System.out.println(username);
		System.out.println(description);
		
		response.getWriter().write("true");
	
	}
}
