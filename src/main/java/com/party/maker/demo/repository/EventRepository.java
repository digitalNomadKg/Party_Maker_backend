package com.party.maker.demo.repository;

import com.party.maker.demo.domain.EventDetails;
import com.party.maker.demo.dto.EventDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventDetails, Long> {
//    public List<EventDetails> findEventsByBudget
}
