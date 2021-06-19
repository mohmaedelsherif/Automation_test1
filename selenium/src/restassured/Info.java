package restassured;

import com.fasterxml.jackson.annotation.*;
import java.util.UUID;

public class Info {
    private String name;
    private UUID postmanID;
    private String description;
    private String schema;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("_postman_id")
    public UUID getPostmanID() { return postmanID; }
    @JsonProperty("_postman_id")
    public void setPostmanID(UUID value) { this.postmanID = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("schema")
    public String getSchema() { return schema; }
    @JsonProperty("schema")
    public void setSchema(String value) { this.schema = value; }
}
