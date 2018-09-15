package workamerica.contexts.errors.entites;

import workamerica.contexts.candidates.entities.Candidate;
import workamerica.contexts.utilities.Clock;

import javax.persistence.*;

/**
 * Created by Faizan on 8/9/2016.
 */
@Entity
@Table(name = "CandidateErrors", schema = "Errors")
public class CandidateError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CandidateErrorsID")
    private int candidateErrorsID;
    @Column(name = "CandidateID")
    private Long candidateID;
    @Column(name = "Date")
    private String date;
    @Column(name = "Time")
    private String time;
    @Column(name = "Feature")
    private String feature;
    @Column(name = "Exception")
    private String exception;
    @Column(name = "Solved")
    private boolean solved;

    public CandidateError() {}

    public CandidateError (Long candidateID, String feature, String exception) {
        this.candidateID = candidateID;
        this.feature = feature;
        this.exception = exception;
        this.date = Clock.currentDate();
        this.time = Clock.currentTime();
        this.solved = false;
    }

    public int getCandidateErrorsID() {
        return candidateErrorsID;
    }

    public void setCandidateErrorsID(int candidateErrorsID) {
        this.candidateErrorsID = candidateErrorsID;
    }

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
