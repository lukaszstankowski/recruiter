package com.stankowski.recruiter.candidate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    Candidate create(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
}
