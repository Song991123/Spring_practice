package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * 요구사항
 * 평균학점 계산 방법 = ((학점 수 × 교과목 평점)의 합계 / 수강 신청 총 학점 수 )
 * 일급 컬렉션 사용
 * */
public class GradeCalculatorTest {
    /* 1. 도메인 구성 객체들이 어떤 것들이 있나 고민 */
    // 학점 계산기 도메인 : 이수한 과목(, 학점 계산기

    /* 2. 해당 객체들 간 관계들을 고민 */
    // 학점 계산기가 이수한 과목을 인스턴스 변수로 가지면서 평균 학점을 가질 수 있을 것 같다

    /* 3. 이들을 정적인 타입으로 추상화해 도메인 모델링을 함 */
    // 객체 지향 프로그래밍, 자료구조, 중국어 회화 ---> 과목(코스) 클래스

    /** ============== 핵심 포인트 ============== */
    /* 4. 이들 클래스 끼리 적절한 책임을 할당하며 협력을 설계*/
    // 이수할 과목을 전달해 평균학점 계산을 요청 ----> 학점 계산기 ----> (학점 수 × 교과목 평점)의 합계 요청 ----> 과목(코스) 일급 컬렉션
    //                                                    ----> 수강 신청 총 학점 수 요청         ----> 과목(코스) 일급 컬렉션
    //                                                                                                     ==> 이후 나눠서 학점 결과 출력

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP",3,"A+"), new Course("자료구조", 3, "A+"));

        // 학점 계산기가 생성될 때 이수한 과목 정보를 전달한다.
        GradeCalculator gradeCalculator = new GradeCalculator(courses);

        // 받은 정보들을 가지고 성적을 계산한다.
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
