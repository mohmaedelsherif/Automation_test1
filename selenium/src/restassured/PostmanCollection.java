package restassured;

import com.fasterxml.jackson.annotation.*;

public class PostmanCollection {
    private Object[] variables;
    private Info info;
    private Item[] item;

    @JsonProperty("variables")
    public Object[] getVariables() { return variables; }
    @JsonProperty("variables")
    public void setVariables(Object[] value) { this.variables = value; }

    @JsonProperty("info")
    public Info getInfo() { return info; }
    @JsonProperty("info")
    public void setInfo(Info value) { this.info = value; }

    @JsonProperty("item")
    public Item[] getItem() { return item; }
    @JsonProperty("item")
    public void setItem(Item[] value) { this.item = value; }
}
