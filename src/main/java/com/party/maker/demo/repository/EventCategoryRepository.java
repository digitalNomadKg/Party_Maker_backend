package com.party.maker.demo.repository;

import com.party.maker.demo.domain.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory, Long> {
}
