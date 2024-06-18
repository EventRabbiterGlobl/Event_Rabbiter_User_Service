package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminServiceImp;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.Image;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.ImageRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.ImageService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImp implements ImageService {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public Image saveImageInGuidance(MultipartFile file,String placeName,int number) {

        String folder = "Guidance Image";
        Map data = cloudinaryService.upload(file,folder);
        String imageUrl = (String) data.get("secure_url");
        String publicId = (String) data.get("public_id");
        Image imageForGuidance=Image.builder()
                .imageUrl(imageUrl)
                .imagePublicId(publicId)
                .name(placeName)
                .placeNumber(number)
                .build();
        return imageRepository.save(imageForGuidance);
    }

    @Override
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

}
