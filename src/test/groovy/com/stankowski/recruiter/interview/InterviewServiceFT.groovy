package com.stankowski.recruiter.interview

import com.stankowski.recruiter.candidate.Candidate
import com.stankowski.recruiter.candidate.CandidateRepository
import com.stankowski.recruiter.feedback.Feedback
import com.stankowski.recruiter.feedback.FeedbackRepository
import com.stankowski.recruiter.feedback.FeedbackService
import com.stankowski.recruiter.interviewer.Interviewer
import com.stankowski.recruiter.interviewer.InterviewerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.transaction.Transactional

@SpringBootTest
class InterviewServiceFT extends Specification {

    @Autowired
    InterviewService interviewService

    @Autowired
    FeedbackRepository feedbackRepository

    @Autowired
    InterviewerRepository interviewerRepository

    @Autowired
    CandidateRepository candidateRepository

    @Transactional
    def 'Should create as many feedbacks as there is interviewers'() {
        given:
            def interviewer1 = interviewerRepository.save(new Interviewer(name: 'Adam Nowak'))
            def interviewer2 = interviewerRepository.save(new Interviewer(name: 'Jan Kowalski'))
            def candidate = candidateRepository.save(new Candidate(name: "Alina Rączka"))
        and:
            def interview = new Interview(position: 'programmer', candidate: candidate, interviewers: [interviewer1, interviewer2])
        and:
            def feedback1 = feedbackRepository.save(new Feedback(interviewer: interviewer1, interview: interview, feedback: "My opinion is very important"))
            def feedback2 = feedbackRepository.save(new Feedback(interviewer: interviewer2, interview: interview, feedback: "In my opinion Alina Rączka will be a valuable employee."))
        and:
            interview.setFeedbacks([feedback1, feedback2])
        when:
            def createdInterview = interviewService.create(interview)
        then:
            createdInterview.feedbacks.get(0).feedback == feedback1.feedback
            createdInterview.feedbacks.get(1).feedback == feedback2.feedback
    }
}
