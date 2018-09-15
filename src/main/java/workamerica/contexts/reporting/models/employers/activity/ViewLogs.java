package workamerica.contexts.reporting.models.employers.activity;

/**
 * Created by Faizan on 8/15/2016.
 */
public class ViewLogs {

    private Long candidateID;
    private String time;

    public ViewLogs () {}

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
