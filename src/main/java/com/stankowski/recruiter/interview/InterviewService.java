package com.stankowski.recruiter.interview;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;

    Interview create(Interview interview) {
        return interviewRepository.save(interview);
    }

    Interview getOne(Long id) {
        return interviewRepository.getOne(id);
    }
}
