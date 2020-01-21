package com.stankowski.recruiter.feedback;

import com.stankowski.recruiter.interview.Interview;
import com.stankowski.recruiter.interviewer.Interviewer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "interviewer_id")
    private Interviewer interviewer;

    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    private String feedback;

}
