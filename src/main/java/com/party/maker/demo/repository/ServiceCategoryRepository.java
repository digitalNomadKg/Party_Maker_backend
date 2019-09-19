package com.party.maker.demo.repository;

import com.party.maker.demo.domain.ServiceCategory;
import org.springframework.data.repository.CrudRepository;

public interface ServiceCategoryRepository extends CrudRepository<ServiceCategory, Long> {
}
