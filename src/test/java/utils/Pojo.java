package utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Pojo {

    @JsonProperty("baseUri")
    private String baseUri;

    @JsonProperty("endpoint")
    private String endpoint;

    @JsonProperty("method")
    private String method;

    @JsonProperty("expectedStatusCode")
    private int expectedStatusCode;

    @JsonProperty("expectedContent")
    private String expectedContent;

    @JsonProperty("requestBody")
    private String requestBody;
}
