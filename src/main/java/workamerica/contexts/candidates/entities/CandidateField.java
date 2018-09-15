package workamerica.contexts.candidates.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Faizan on 8/2/2016.
 */

@Entity
@Table(name = "CandidateFields", schema = "Candidate")
public class CandidateField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CandidateFieldID")
    @JsonIgnore
    private Long candidateFieldID;
    @JsonIgnore
    @Column(name = "CandidateID")
    private Long candidateID;
    @Column(name = "FieldID")
    private Long fieldID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Current")
    private boolean current;
    @ManyToOne
    @JoinColumn(name = "CandidateID", referencedColumnName = "CandidateID", insertable = false, updatable = false)
    @JsonIgnore
    private Candidate candidate;

    public CandidateField () {

    }

    public CandidateField (Long fieldID, String name, boolean current, Long candidateID) {
        this.fieldID = fieldID;
        this.name = name;
        this.current = current;
        this.candidateID = candidateID;
    }

    public Long getFieldID() {
        return fieldID == null ? 0 : fieldID;
    }

    public void setFieldID(Long fieldID) {
        this.fieldID = fieldID;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCurrent() {
        try {
            return current;
        } catch (Exception e) {
            return false;
        }
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Long getCandidateFieldID() {
        return candidateFieldID;
    }

    public void setCandidateFieldID(Long candidateFieldID) {
        this.candidateFieldID = candidateFieldID;
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
