package com.stankowski.recruiter.interviewer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InterviewerService {

    private final InterviewerRepository interviewerRepository;

    Interviewer create(Interviewer interviewer) {
        return interviewerRepository.save(interviewer);
    }
}
