package com.project.project_management.converter;

import com.project.project_management.dto.PropertyDTO;
import com.project.project_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setAddress(propertyDTO.getAddress());
        pe.setDescription(propertyDTO.getDescription());

        pe.setPrice(propertyDTO.getPrice());
        pe.setTitle(propertyDTO.getTitle());


        return pe;
    }
    public PropertyDTO covertEntityToDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());

        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setDescription(propertyEntity.getDescription());

        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setUserId(propertyEntity.getUserEntity().getId());

        return (propertyDTO);
    }

}
