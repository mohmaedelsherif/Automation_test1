package restassured;

import com.fasterxml.jackson.annotation.*;

public class Request {
    private String url;
    private String method;
    private PostmanHeader[] header;
    private Body body;
    private String description;

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("method")
    public String getMethod() { return method; }
    @JsonProperty("method")
    public void setMethod(String value) { this.method = value; }

    @JsonProperty("header")
    public PostmanHeader[] getHeader() { return header; }
    @JsonProperty("header")
    public void setHeader(PostmanHeader[] value) { this.header = value; }

    @JsonProperty("body")
    public Body getBody() { return body; }
    @JsonProperty("body")
    public void setBody(Body value) { this.body = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }
}
