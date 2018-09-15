package workamerica.contexts.reporting.models.employers.activity;

import java.nio.channels.Pipe;

/**
 * Created by Faizan on 8/15/2016.
 */
public class PipelineLogs {

    private Long candidateID;
    private String action;
    private String change;
    private String time;

    public PipelineLogs () {}

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
