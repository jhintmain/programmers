package LV_1.day_5;

/**
 * Date : 2023-05-31
 * Lessons : 코딩 기초 트레이닝 > 주사위게임2
 * Comment : Set 기본값 채우기 : Stream.of(a, b, c).collect(Collectors.toSet());
 */
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiceGame2 {
    public static int solution(int a, int b, int c) {
        int answer = a + b + c;
        Set<Integer> set = new HashSet<>();

        set.add(a);
        set.add(b);
        set.add(c);

        int setSize = set.size();

        switch (setSize) {
            case 1:
                answer *= (int) Math.pow(a, 3) + (int) Math.pow(b, 3) + (int) Math.pow(c, 3);
            case 2:
                answer *= (int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2);
        }
        return answer;
    }

    // 다른사람 풀이
    public static int solution1(int a, int b, int c) {
        Set<Integer> numbers = Stream.of(a, b, c).collect(Collectors.toSet());
        return (a + b + c) *
                (numbers.size() < 3 ? a * a + b * b + c * c : 1) *
                (numbers.size() < 2 ? a * a * a + b * b * b + c * c * c : 1);
    }
}
