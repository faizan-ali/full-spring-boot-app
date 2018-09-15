package workamerica.contexts.candidates.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Faizan on 8/8/2016.
 */
@Entity
@Table(name = "Interests", schema = "Candidate")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InterestID")
    @JsonIgnore
    private Long interestID;
    @Column(name = "CandidateID")
    private Long candidateID;
    @Column(name = "CompanyID")
    private Long companyID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Image")
    private String picture;
    @ManyToOne
    @JoinColumn(name = "CandidateID", referencedColumnName = "CandidateID", insertable = false, updatable = false)
    @JsonIgnore
    private Candidate candidate;

    public Interest() {}

    public Interest(Long companyID, String name, String picture, Long candidateID) {
        this.companyID = companyID;
        this.name = name;
        this.picture = picture;
        this.candidateID = candidateID;
    }

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getInterestID() {
        return interestID;
    }

    public void setInterestID(Long interestID) {
        this.interestID = interestID;
    }

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
