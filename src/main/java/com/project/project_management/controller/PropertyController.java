package com.project.project_management.controller;

import com.project.project_management.dto.PropertyDTO;
import com.project.project_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Autowired
    public PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO=propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity <List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> propertyList=propertyService.getAllProperties();
        ResponseEntity <List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;

    }
    @GetMapping("/properties/users/{userId}")
    public ResponseEntity <List<PropertyDTO>> getAllPropertiesForUser(@PathVariable("userId") Long userId) {
        List<PropertyDTO> propertyList=propertyService.getAllPropertiesForUser(userId);
        ResponseEntity <List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;

    }
    @PutMapping("/properties/{propertyId}")
    public ResponseEntity <PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO=propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity <PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity <Void> responseEntity = new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
