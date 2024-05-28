package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService {

     public Map upload(MultipartFile file,String folder);
     public Map<String, Object> uploadVideo(MultipartFile file, String folder);
}
