package testing.apilogdata.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



//    @Column(name = "user_agent")
//    private String userAgent;

    @Column(name = "user")
    private String user;

    @Column(name = "role")
    private String role;
    @Column(name = "request_url")
    private String requestUrl;

    @Column(name = "http_method")
    private String httpMethod;
    @Column(name = "access_count")
    private int accessCount;

    @Column(name = "log_time", columnDefinition = "TEXT")
    private String logTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
