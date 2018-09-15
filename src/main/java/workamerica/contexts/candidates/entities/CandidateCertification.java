package workamerica.contexts.candidates.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Faizan on 8/2/2016.
 */
@Entity
@Table(name = "CandidateCertifications", schema = "Candidate")
public class CandidateCertification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CandidateCertificationID")
    @JsonIgnore
    private Long candidateCertificationID;
    @Column(name = "CertificationID")
    private Long certificationID;
    @JsonIgnore
    @Column(name = "CandidateID")
    private Long candidateID;
    @Column(name = "Name")
    private String name;
    @Column(name = "CompletionDate")
    private String completionDate;
    @ManyToOne
    @JoinColumn(name = "CandidateID", referencedColumnName = "CandidateID", insertable = false, updatable = false)
    @JsonIgnore
    private Candidate candidate;

    public CandidateCertification() {

    }

    public Long getCertificationID() {
        return certificationID == null ? 0 : certificationID;
    }

    public void setCertificationID(Long certificationID) {
        this.certificationID = certificationID;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompletionDate() {
        return completionDate == null ? "" : completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public Long getCandidateCertificationID() {
        return candidateCertificationID;
    }

    public void setCandidateCertificationID(Long candidateCertificationID) {
        this.candidateCertificationID = candidateCertificationID;
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