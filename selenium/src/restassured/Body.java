package restassured;

import com.fasterxml.jackson.annotation.*;

public class Body {
    private String mode;
    private String raw;

    @JsonProperty("mode")
    public String getMode() { return mode; }
    @JsonProperty("mode")
    public void setMode(String value) { this.mode = value; }

    @JsonProperty("raw")
    public String getRaw() { return raw; }
    @JsonProperty("raw")
    public void setRaw(String value) { this.raw = value; }
}
