package org.example;

import java.util.Objects;

public class RequestLine {
    /**
     * GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
     * =========================================================
     * GET : HTTP Method
     * /calculate?operand1=11&operator=*&operand2=55 : Path
     * HTTP/1.1 : Protocol
     * */
    private final String method; //GET
    private final String urlPath; // /calculate
    private String queryString; // operand1=11&operator=*&operand2=55

    /** RequestLine 생성자로, method, urlPath, queryString을 담는다.*/
    public RequestLine(String method, String urlPath, String queryString){
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    /** RequestLine 생성자로 받아온 RequestLine 구문을 처리해 method, urlPath, queryString으로 분리시킨다.*/
    public RequestLine(String requestLine){
        // HTTP Method 저장
        String tokens[] = requestLine.split(" ");
        this.method = tokens[0];

        // Path 저장
        String urlurlTokens[] = tokens[1].split("\\?");
        this.urlPath = urlurlTokens[0];

        // queryString 저장
        if(urlurlTokens.length == 2){
            this.queryString = urlurlTokens[1];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
