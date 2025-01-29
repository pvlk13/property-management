package com.project.project_management.service;

import com.project.project_management.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty (PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties ();
    List<PropertyDTO> getAllPropertiesForUser (Long userId);
    PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyId);
    void deleteProperty(Long propertyId);
}
