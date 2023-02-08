// 일급 컬렉션 구현
// 일급 컬렉션 : 리스트 형태로 된 정보만 인스턴스로 가진 클래스
// 즉, 어떠한 정보들을 가지고 처리할 수 있는 책임들이 모두 일급 컬렉션 클래스에게 모두 이동하게 된다.

package org.example;

import java.util.List;

public class Courses {
    //이수한 과목들을 인스턴스 변수로 선언
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    /** (학점 수 × 교과목 평점)의 합계 */
    public double multipliedCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    /**수강신청 총 학점 수*/
    public int calculateTotalCompletedGredit() {
        return courses.stream()
                //Course::getCredit 이랑 course -> course.getCredit이랑 같음
                .mapToInt(Course::getCredit)
                .sum();
    }
}
