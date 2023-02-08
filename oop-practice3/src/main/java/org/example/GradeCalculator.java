package org.example;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }
    /** 평균학점 계산기 */
    /* 4. 이들 클래스 끼리 적절한 책임을 할당하며 협력을 설계*/
    // 이수할 과목을 전달해 평균학점 계산을 요청 ----> 학점 계산기 ----> (학점 수 × 교과목 평점)의 합계 요청 ----> 과목(코스) 일급 컬렉션
    //                                                    ----> 수강 신청 총 학점 수 요청         ----> 과목(코스) 일급 컬렉션
    //                                                                                                     ==> 이후 나눠서 학점 결과 출력
    public double calculateGrade() {
        //(학점 수 × 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multipliedCreditAndCourseGrade();

        // 수강신청 총 학점 수
        int totalCompletedCredit                   = courses.calculateTotalCompletedGredit();

        // 평균학점 계산
        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
