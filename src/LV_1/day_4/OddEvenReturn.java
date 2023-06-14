package LV_1.day_4;

import java.util.stream.IntStream;

/**
 * Date : 2023-05-29
 * Lessons : 코딩 기초 트레이닝 > 홀짝에 따라 다른값 반환하기
 * Comment : 1~n까지 :  IntStream.rangeClosed(1,n)
 */
public class OddEvenReturn {
    public static int solution(int n) {
        int answer = 0;
        if (n % 2 == 1) {
            for (int i = 1; i <= n; i += 2) {
                answer += i;
            }
        } else {
            for (int i = 2; i <= n; i += 2) {
                answer += Math.pow(i,2);
            }
        }

        return answer;
    }

    /**
     * 다른 사람의 풀이 참고
     * 1. IntStream.rangeCloed를 통한 방법
     */
    public int solution1(int n) {
        if(n%2 == 0) {
            return IntStream.rangeClosed(1,n).filter(i->i%2==0).map(i->(int) Math.pow(i,2)).sum();
        }
        return IntStream.rangeClosed(1,n).filter(i->i%2==1).sum();
    }


}
