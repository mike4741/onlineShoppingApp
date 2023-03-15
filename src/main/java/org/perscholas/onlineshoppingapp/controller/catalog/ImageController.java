package org.perscholas.onlineshoppingapp.controller.catalog;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.models.catalog.Image;
import org.perscholas.onlineshoppingapp.service.catalog.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/images")
@Slf4j
public class ImageController {

    ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file = imageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
//    @GetMapping("/images")
//    public String showImages(Model model) {
//        List<Image> images = getImageList(); // get the list of images from a service or repository
//        model.addAttribute("images", images);
//        return "images";
//    }

}









//
//
//    private ImageService imageService;
//    @GetMapping("/{filename:.+}")
//    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
//        Resource file = imageService.load(filename);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "in-line; filename=\"" + file.getFilename() + "\"").body(file);
//    }
//
//
//    @GetMapping("/newImage2")
//    public String getImage(Model model) {
//        List<Image> file = imageService.getAllImage();
//
//
//             for (Image image : file) {
//                 log.info(String.valueOf(image));
//                 model.addAttribute(image);
//             }
//
//            return " ";
//        }
//
//    @GetMapping("/newImage")
//    public String getImage() {
//
//
//        return "image";
//    }
//    @GetMapping("/image/{imageName}")
//    @ResponseBody
//    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
//        Resource file = storageService.loadAsResource(imageName);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//                .body(file);
//    }
//
//
//
//}
