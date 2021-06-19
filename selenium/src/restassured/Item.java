package restassured;

import com.fasterxml.jackson.annotation.*;

public class Item {
    private String name;
    private Request request;
    private Object[] response;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("request")
    public Request getRequest() { return request; }
    @JsonProperty("request")
    public void setRequest(Request value) { this.request = value; }

    @JsonProperty("response")
    public Object[] getResponse() { return response; }
    @JsonProperty("response")
    public void setResponse(Object[] value) { this.response = value; }
}
