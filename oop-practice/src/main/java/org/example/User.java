package org.example;

public class User {
    private String password;
    /** 패스워드를 초기화 해주는 메소드 */
    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is 방식 ==========================
        // 테스트코드 작성 시 랜덤으로 생성되어서 컨트롤할 수가 없는 부분
        // 때문에 인터페이스를 구현한 후 외부에서 주입받아 컨트롤하는 방식으로 해본다.
        // 테스트 용이므로 임의의 조건을 미리 설정해놓고, 항상 통과되도록 처리를 하는 것.
        // 이처럼 내부에서 생성하는 경우, 강한 결합을 지녀 해당 부분에 대해 많은 영향을 받을 수밖에 없음.
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be 방식(인터페이스 활용) ==========================
        // 위의 강한 결합을 끊기 위해 인터페이스를 활용한 것임
        // 더 낮은 결합 및, import로 인한 의존도를 낮춤
        String password = passwordGenerator.generalPassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         * */
        if(password.length() >= 8 && password.length() <= 12)
        {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
