package com.wf.interviews.interviewtracker.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wf.interviews.interviewtracker.DTO.InterviewTrackDTO;
import com.wf.interviews.interviewtracker.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long>{
	
	List<Interview> findByInterviewName(String interviewName);
	List<Interview> findByInterviewerName(String interviewerName);
//	List<Interview> findByUser(Long userId);
	
//	@Query("select i from Interview i where i.interviewerName=interviewerName")
//	List<Interview> findByInterviewerName(@Param("interviewerName") String interviewerName);
	
//	@Query("select i from Interview i where i.interviewName=interviewName")
//	List<Interview> findByInterviewName(@Param("interviewName") String interviewName);
	
	@Query("select i from Interview i where i.userId=userId")
	List<Interview> findByUser(@Param("userId") Long userId);
	
//	@Query("SELECT new com.wf.interviews.interviewtracker.DTO(i.interviewId, i.interviewerName, i.interviewName, i.userSkills"
//			+ "i.date,i.time,i.interviewStatus,i.remarks) "
//			+ "FROM User u INNER JOIN Interview i on u.userId=i.userId")
//	List<InterviewTrackDTO> fetchAllInterviews();
}
