package LV_1.day_3;

/**
 * Date : 2023-05-29
 * Lessons : 코딩 기초 트레이닝 > 더 크게 합치기
 * Comment : -
 */
public class MergeBigger {
    public static int solution(int a, int b) {
        return Math.max(Integer.parseInt(Integer.toString(a) + b), Integer.parseInt(Integer.toString(b) + a));
    }


}
