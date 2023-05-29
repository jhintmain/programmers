package day_3;

/**
 * Date : 2023-05-29
 * Lessons : 코딩 기초 트레이닝 > 두 수의 연산값 비교하기
 * Comment : -
 */
public class ComparingOperation {
    public static int solution(int a, int b) {
        return Math.max(Integer.parseInt(Integer.toString(a) + b), 2*a*b);
    }
}
