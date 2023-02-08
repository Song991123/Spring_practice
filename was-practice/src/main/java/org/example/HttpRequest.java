package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;
    
    public HttpRequest(BufferedReader br) throws IOException {
        // BufferedReader로 외부에서 부터 받아 첫 번째 라인을 넘겨줌
        this.requestLine = new RequestLine(br.readLine());
    }
}
