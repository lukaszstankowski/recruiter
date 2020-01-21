package com.stankowski.recruiter.feedback;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    Feedback findOne(Long id) {
        return feedbackRepository.getOne(id);
    }
}
