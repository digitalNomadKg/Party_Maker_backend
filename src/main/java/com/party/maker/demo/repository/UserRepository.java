package com.party.maker.demo.repository;

import com.party.maker.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
/*    @Query("select user from User where userName =: s")
    User findByUserName(String s);*/
}
