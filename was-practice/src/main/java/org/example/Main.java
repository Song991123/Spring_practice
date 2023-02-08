package org.example;

// GET /calculate 요청이 들어올 시 계산기에 대한 결과 수행 후 결과를 return
// 1. GET /calculate?operand1=11&operator=*&operand2=55
//    ㄴ 요청    : GET
//    ㄴ path    : calculate
//    ㄴ 피연산자  : operand1, operand2
//    ㄴ 연산자    : *

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }
}