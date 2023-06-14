package LV_1.day_5;

import java.util.stream.IntStream;

/**
 * Date : 2023-05-31
 * Lessons : 코딩 기초 트레이닝 > 등차수열의 특정한 항만 더하기
 * Comment : included 배열길이만큼 IntStream 배열 만들어 저굥
 */
public class ArithmeticSequence {
    public static int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += (a + (i * d));
            }
        }
        return answer;
    }

    // 다른사람 풀이
    public static int solution1(int a, int d, boolean[] included) {
        return IntStream
                .range(0, included.length)
                .map(idx -> (included[idx]) ? (a + (idx * d)) : 0)
                .sum();
    }
}
