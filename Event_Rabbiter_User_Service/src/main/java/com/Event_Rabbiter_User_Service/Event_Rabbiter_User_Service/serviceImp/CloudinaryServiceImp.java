package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.serviceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.CloudinaryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Service
public class CloudinaryServiceImp implements CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public Map imageUpload(MultipartFile file, String folder) {
        try {
            Map options = ObjectUtils.asMap("folder", folder);

            return cloudinary.uploader().upload(file.getBytes(), options);
        } catch (IOException e) {
            throw new RuntimeException("Image uploading failed !");
        }
    }
}
