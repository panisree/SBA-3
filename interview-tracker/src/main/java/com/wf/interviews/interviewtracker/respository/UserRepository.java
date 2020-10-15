package com.wf.interviews.interviewtracker.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wf.interviews.interviewtracker.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
