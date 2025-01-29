package com.project.project_management.repository;

import com.project.project_management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long>
         {
             List<PropertyEntity> findAllByUserEntityId(Long userId);
}
