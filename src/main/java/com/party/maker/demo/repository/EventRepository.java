package com.party.maker.demo.repository;

import com.party.maker.demo.domain.EventDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventDetails, Long> {
}
