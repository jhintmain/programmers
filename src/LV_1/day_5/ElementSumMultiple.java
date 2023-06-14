package LV_1.day_5;

import java.util.stream.IntStream;

/**
 * Date : 2023-05-31
 * Lessons : 코딩 기초 트레이닝 > 원소들의 곱과합
 * Comment : -
 */
public class ElementSumMultiple {
    public static int solution(int[] num_list) {
        int sum1 = IntStream.of(num_list).reduce((a,b)->a*b).getAsInt();
        int sum2 = (int)Math.pow(IntStream.of(num_list).sum(),2);
        return sum1 < sum2 ? 1 : 0;
    }
}
