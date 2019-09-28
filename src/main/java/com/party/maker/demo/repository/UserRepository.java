package com.party.maker.demo.repository;

import com.party.maker.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username=:username")
    User findByUserName(@Param("username") String username);

   /* @Query(nativeQuery = true, value = "select user from User  u where u.email=:s")
    User findByEmail(@Param("email") String s);*/
}
