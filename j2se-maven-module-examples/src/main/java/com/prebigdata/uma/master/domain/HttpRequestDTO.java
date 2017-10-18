package com.prebigdata.uma.master.domain;

import java.util.Map;

public class HttpRequestDTO {
    public String urlEndpoint;
    public String protocol;
    public String requestMethod;
    public String requestBody;
    public Map<String, String> headers;

    public HttpRequestDTO() {
        this.urlEndpoint = null;
        this.protocol = null;
        this.requestMethod = null;
        this.requestBody = null;
        this.headers = null;
    }
}
