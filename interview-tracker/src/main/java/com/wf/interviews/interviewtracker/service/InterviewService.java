package com.wf.interviews.interviewtracker.service;

import java.util.List;

import com.wf.interviews.interviewtracker.DTO.InterviewDTO;
import com.wf.interviews.interviewtracker.DTO.InterviewTrackDTO;
import com.wf.interviews.interviewtracker.DTO.UserDTO;

public interface InterviewService {
	
	public List<InterviewDTO> getAll();
	public InterviewDTO getById(Long interviewId);
	public InterviewDTO addInterview(InterviewDTO interview);
	public InterviewDTO deleteInterview(Long interviewId);
	public List<InterviewDTO> getByInterviewName(String name);
	public List<InterviewDTO> getByInterviewerName(String name);
	public List<UserDTO> getUsersForInterview(String interviewName);
	public InterviewDTO updateStatus(Long interviewId, String Status);
	public InterviewTrackDTO UpdateUserForInterview(Long interviewId, Long userId);

}
