package com.project.project_management.service.impl;

import com.project.project_management.converter.PropertyConverter;
import com.project.project_management.dto.PropertyDTO;
import com.project.project_management.entity.PropertyEntity;
import com.project.project_management.repository.PropertyRepository;
import com.project.project_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        pe=propertyRepository.save(pe);
        propertyDTO = propertyConverter.covertEntityToDTO(pe);
        return propertyDTO;

    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> list = (List<PropertyEntity>)propertyRepository.findAll();
        List <PropertyDTO>  arrayList = new ArrayList<>();
        for(PropertyEntity pe:list){
            PropertyDTO dto = propertyConverter.covertEntityToDTO(pe);
            arrayList.add(dto);
        }
        return arrayList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> opnEnt= propertyRepository.findById(propertyId);

        if(opnEnt.isPresent()){
            PropertyEntity pe = opnEnt.get();
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setDescription(propertyDTO.getDescription());
            pe.setTitle(propertyDTO.getTitle());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            propertyRepository.save(pe);

        }
        return propertyDTO;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);

    }


}
