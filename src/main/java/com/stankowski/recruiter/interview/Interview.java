package com.stankowski.recruiter.interview;

import com.stankowski.recruiter.candidate.Candidate;
import com.stankowski.recruiter.feedback.Feedback;
import com.stankowski.recruiter.interviewer.Interviewer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Interview {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String position;

    @OneToOne()
    private Candidate candidate;

    @OneToMany(mappedBy = "interview")
    private List<Feedback> feedbacks;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "INTERVIEW_INTERVIEWER",
            joinColumns = @JoinColumn(name = "INTERVIEW_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "INTERVIEWER_ID", referencedColumnName = "ID"))
    private Set<Interviewer> interviewers;
}

