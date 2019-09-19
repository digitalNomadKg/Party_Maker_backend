package com.party.maker.demo.repository;

import com.party.maker.demo.domain.ServiceDetails;
import org.springframework.data.repository.CrudRepository;

public interface ServiceDetailsRepository extends CrudRepository<ServiceDetails, Long> {
}
