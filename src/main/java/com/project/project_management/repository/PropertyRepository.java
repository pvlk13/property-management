package com.project.project_management.repository;

import com.project.project_management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long>
         {
}
