package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {


    Image saveImageInGuidance(MultipartFile multipartFile,String placeName,int number);
    List<Image> getImages();
}
