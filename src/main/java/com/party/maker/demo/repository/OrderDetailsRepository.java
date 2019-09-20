package com.party.maker.demo.repository;

import com.party.maker.demo.domain.OrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {

}
