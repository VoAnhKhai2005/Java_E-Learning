package pojo;

import java.util.Map;

public class Report {
    private String id;
    private String type; // e.g., "Revenue", "Attendance", "Membership"
    private Map<String, Object> data;

    public Report() {}

    public Report(String id, String type, Map<String, Object> data) {
        this.id = id;
        this.type = type;
        this.data = data;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Map<String, Object> getData() { return data; }
    public void setData(Map<String, Object> data) { this.data = data; }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
