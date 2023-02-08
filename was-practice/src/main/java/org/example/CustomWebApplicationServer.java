package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port; // port값
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class); // 로그 기록용

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    /** Web application Server를 시작한다 */
    public void start() throws IOException {
        // 서버 소켓을 통해 해당하는 포트로 서버를 만든다
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            // 그 후 클라이언트 소켓을 대기시킨다
            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] wating for client.");
            
            // 클라이언트 소켓이 연결될 시 while문이 계속해서 돈다
            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected.");

                /**Step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.*/
                // InputStream : Byte의 입력 스트림을 나타내는 모든 클래스의 수퍼 클래스
                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    // Line by Line으로 읽기 위해 BufferedReader를 사용
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

//                    // HTTP Protocol이 어떻게 생겼는지 구경하기 위한 로직 ==========
//                    String line;
//                    while((line = br.readLine()) != ""){
//                        System.out.println(line);
//                    }
                    /**
                     * ============================================
                     * [설명]
                     * Spring을 이용해서 웹 개발을 할 때 어떠한 누군가는 내부적으로 어떤 프로토콜이 들어왔을 때 파싱을 해서 무슨 요청이구나 라는 것을 판단을 한다.
                     * 그러한 판단에 맞게끔 스프링이 보내는 작업을 누군가는 수행할 것이다.
                     * 그 수행이 바로 톰캣이다.
                     * 해당 코드는 커스텀한 톰캣을 만들고 있다고 봐도 된다.
                     * ============================================
                     * */
                }
            }
        }
    }
}
