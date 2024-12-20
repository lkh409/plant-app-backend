package com.example.plantappbackend.controller;

import com.example.plantappbackend.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/plants")
public class CameraController {

    private final CameraService cameraService;

    @Autowired
    public CameraController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    /*
    * 요청 처리 공통 메서드
    * @param image 이미지 파일
    * @param includeStatus 상태 포함 여부
    * @return 식물 인식 결과*/

    // OpenAI API 식물 이름 인식
    @PostMapping("/recognize")
    public ResponseEntity<Map<String, String>> detectPlantName(@RequestParam("image") MultipartFile image) {
        Map<String, String> result = cameraService.detectPlantName(image);
        return ResponseEntity.ok(result);
    }

    // OpenAI API 식물 이름 인식 (상태)
    @PostMapping("/status")
    public ResponseEntity<Map<String, String>> detectPlantNameAndStatus(@RequestParam("image") MultipartFile image) {
        Map<String, String> result = cameraService.detectPlantNameAndStatus(image);
        return ResponseEntity.ok(result);
    }
}