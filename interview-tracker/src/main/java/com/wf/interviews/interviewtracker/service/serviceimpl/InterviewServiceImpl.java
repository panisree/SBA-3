package com.wf.interviews.interviewtracker.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.interviews.interviewtracker.DTO.InterviewDTO;
import com.wf.interviews.interviewtracker.DTO.InterviewTrackDTO;
import com.wf.interviews.interviewtracker.DTO.UserDTO;
import com.wf.interviews.interviewtracker.entity.Interview;
import com.wf.interviews.interviewtracker.entity.User;
import com.wf.interviews.interviewtracker.exception.UserAlreadyExistsForTheInterviewException;
import com.wf.interviews.interviewtracker.respository.InterviewRepository;
import com.wf.interviews.interviewtracker.respository.UserRepository;
import com.wf.interviews.interviewtracker.service.InterviewService;
import com.wf.interviews.interviewtracker.service.UserService;

@Service
public class InterviewServiceImpl implements InterviewService{
	
	@Autowired
	InterviewRepository repository;
	
	@Autowired
	UserService userService;
	
	
	public List<InterviewDTO> getAll(){
		
		List<Interview> interviews =this.repository.findAll();
		List<InterviewDTO> interviewsDTO=new ArrayList<InterviewDTO>();
		for(Interview interview:interviews) {		
			interviewsDTO.add(new InterviewDTO(interview.getInterviewId(),interview.getInterviewerName(),interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), interview.getTime(), interview.getInterviewStatus(), interview.getRemarks()));
		}
		return interviewsDTO;
	}
	
	
	public InterviewDTO getById(Long interviewId) {
		Interview interview=this.repository.findById(interviewId).orElse(null);
		
		return new InterviewDTO(interview.getInterviewId(),interview.getInterviewerName(),interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), interview.getTime(), interview.getInterviewStatus(), interview.getRemarks());
	}
	
	public List<InterviewDTO> getByInterviewName(String name) {
		List<Interview> interviews= this.repository.findByInterviewName(name);
		
		List<InterviewDTO> interviewsDTO=new ArrayList<InterviewDTO>();
		for(Interview interview:interviews) {		
			interviewsDTO.add(new InterviewDTO(interview.getInterviewId(),interview.getInterviewerName(),interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), interview.getTime(), interview.getInterviewStatus(), interview.getRemarks()));
		}
		
		return interviewsDTO;
	}
	
	public List<InterviewDTO> getByInterviewerName(String name) {
		List<Interview> interviews= this.repository.findByInterviewerName(name);
		
		List<InterviewDTO> interviewsDTO=new ArrayList<InterviewDTO>();
		for(Interview interview:interviews) {		
			interviewsDTO.add(new InterviewDTO(interview.getInterviewId(),interview.getInterviewerName(),interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), interview.getTime(), interview.getInterviewStatus(), interview.getRemarks()));
		}
		
		return interviewsDTO;
	}
	
	public InterviewDTO addInterview(InterviewDTO interview) {
		System.out.println("**Interview"+interview.toString());
		
		Interview interviewcreated=this.repository.save(new Interview(interview.getInterviewId(),interview.getInterviewerName(),
				interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), 
				interview.getTime(), interview.getInterviewStatus(), interview.getRemarks(),null));
		
		return new InterviewDTO(interviewcreated.getInterviewId(),interviewcreated.getInterviewerName(),
				interviewcreated.getInterviewName(),interviewcreated.getUserSkills(), interviewcreated.getDate(), 
				interviewcreated.getTime(), interviewcreated.getInterviewStatus(), interviewcreated.getRemarks());
	}
	
	
	public InterviewDTO updateStatus(Long interviewId, String Status) {
		InterviewDTO interview = this.getById(interviewId);
		interview.setInterviewStatus(Status);
		Interview interviewcreated=this.repository.save(new Interview(interview.getInterviewId(),interview.getInterviewerName(),
				interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), 
				interview.getTime(), interview.getInterviewStatus(), interview.getRemarks(),null));
		
		return new InterviewDTO(interviewcreated.getInterviewId(),interviewcreated.getInterviewerName(),
				interviewcreated.getInterviewName(),interviewcreated.getUserSkills(), interviewcreated.getDate(), 
				interviewcreated.getTime(), interviewcreated.getInterviewStatus(), interviewcreated.getRemarks());
	}
	
	public List<UserDTO> getUsersForInterview(String interviewName){
		List<Interview> interviews =this.repository.findAll();
//		List<InterviewDTO> interviewsDTO=new ArrayList<InterviewDTO>();
		List<Long> users=new ArrayList<Long>();
		for(Interview interview:interviews) {
				if(interview.getInterviewName().equalsIgnoreCase(interviewName))
					if(!Objects.isNull(interview.getUserId()))
						users.add(interview.getUserId());
		}

		
		List<UserDTO> userDTO=new ArrayList<UserDTO>();
		
		for(Long user:users) {
			userDTO.add(this.userService.getById(user));
		}
		
		return userDTO;
		
	}
	
	public InterviewTrackDTO UpdateUserForInterview(Long interviewId, Long userId){
		
		UserDTO user=this.userService.getById(userId);
		
		List<Interview> interviews=this.repository.findByUser(userId);
		
		Interview interview=this.repository.findById(interviewId).orElse(null);
		String interviewName=interview.getInterviewName();
		System.out.println("abc"+interviewName);
		boolean interviewAvailable=false;
		
		for(Interview i:interviews) {
			if(i.getInterviewName().equalsIgnoreCase(interviewName))
				interviewAvailable=true;
		}
		
		System.out.println("abc"+interviewAvailable);
		Interview interviewcreated=new Interview();
		
		if(!interviewAvailable) {
			interview.setUserId(userId);
			interviewcreated=this.repository.save(new Interview(interview.getInterviewId(),interview.getInterviewerName(),
					interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), 
					interview.getTime(), interview.getInterviewStatus(), interview.getRemarks(),interview.getUserId()));
			System.out.println("abc updated user");
			return new InterviewTrackDTO(interviewcreated.getInterviewId(),interviewcreated.getInterviewerName(),
					interviewcreated.getInterviewName(),interviewcreated.getUserSkills(), interviewcreated.getDate(), 
					interviewcreated.getTime(), interviewcreated.getInterviewStatus(), interviewcreated.getRemarks(),user.getUserid(),user.getFirstName(),
					user.getLastName(),user.getEmail(),user.getMobile());
		}
		
		else
			throw  new UserAlreadyExistsForTheInterviewException("User was already assigned for the Interview-" + interviewName);
	}
	
	public List<InterviewDTO> getInterviewBYInterviewerName(String interviewerName) {
		List<Interview> interviews=this.repository.findByInterviewerName(interviewerName);
		List<InterviewDTO> interviewsDTO=new ArrayList<InterviewDTO>();
		for(Interview interview:interviews) {		
			interviewsDTO.add(new InterviewDTO(interview.getInterviewId(),interview.getInterviewerName(),interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), interview.getTime(), interview.getInterviewStatus(), interview.getRemarks()));
		}
		return interviewsDTO;
		
	}
	
	public List<InterviewDTO> getInterviewBYInterviewName(String interviewName) {
		List<Interview> interviews=this.repository.findByInterviewerName(interviewName);
		List<InterviewDTO> interviewsDTO=new ArrayList<InterviewDTO>();
		for(Interview interview:interviews) {		
			interviewsDTO.add(new InterviewDTO(interview.getInterviewId(),interview.getInterviewerName(),interview.getInterviewName(),interview.getUserSkills(), interview.getDate(), interview.getTime(), interview.getInterviewStatus(), interview.getRemarks()));
		}
		return interviewsDTO;
		
	}
	
	public InterviewDTO deleteInterview(Long interviewId) {
		InterviewDTO interviewDTO = this.getById(interviewId);
		
		if(interviewDTO != null)
			this.repository.deleteById(interviewId);
		
		return interviewDTO;
	}

}
