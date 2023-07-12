package testing.apilogdata.Dto;

public class LogDTO {

    private String user;
    private String role;
    private String requestUrl;
    private String httpMethod;
    private int accessCount;
    private String logTime;

    public LogDTO(String user, String role, String requestUrl, String httpMethod, int accessCount, String logTime) {
        this.user = user;
        this.role = role;
        this.requestUrl = requestUrl;
        this.httpMethod = httpMethod;
        this.accessCount = accessCount;
        this.logTime = logTime;
    }

    public LogDTO() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }
}
