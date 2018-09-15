package workamerica.contexts.reporting.models.candidates.origin;

/**
 * Created by Faizan on 8/9/2016.
 */
public class SourceLogs {

    private String type;
    private String name;
    private int sourceID;

    public SourceLogs () {}

    public SourceLogs(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSourceID() {
        return sourceID;
    }

    public void setSourceID(int sourceID) {
        this.sourceID = sourceID;
    }
}
