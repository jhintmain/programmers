package LV_2.day_2;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int num1 = 2;
        int num2 = 3;
        int q1 = solution1(num1, num2);
        System.out.println(q1);

        System.out.println("========= Q2 ===========");
        int[] array = {1, 2, 7, 10, 11};
        int q2 = solution2(array);
        System.out.println(q2);

        System.out.println("========= Q3 ===========");
        int[] array3 = {1, 2, 3, 3, 3, 4};
        int q3 = solution3(array3);
        System.out.println(q3);

        System.out.println("========= Q4 ===========");
        int n = 10;
        int[] q4 = solution4(n);
        for (int num : q4) {
            System.out.println(num);
        }

        System.out.println("========= Q5 ===========");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double q5 = solution5(numbers);
        System.out.println(q5);
    }

    // 배열의 평균값
    public static double solution5(int[] numbers) {
//        return IntStream.of(numbers).sum()/(double)numbers.length;
        return IntStream.of(numbers).average().orElse(0);
    }


    // 짝수는 싫어요
    public static int[] solution4(int n) {
        return IntStream.range(1,n+1).filter(i->i%2==1).toArray();
    }

    // 최빈값 구하기
    public static int solution3(int[] array) {
        int answer = 0;
        int old_val = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Integer, Integer> entry : list) {
            if (count == 0) {
                old_val = entry.getValue();
                answer = entry.getKey();
                count++;
            } else {
                answer = old_val == entry.getValue() ? -1 : answer;
                break;
            }
//            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }
        return answer;

        /*int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else  if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;*/
    }

    // 중앙값 구하기
    public static int solution2(int[] array) {
        int[] answer = IntStream.of(array).sorted().toArray();
        return answer[answer.length / 2];

//        Arrays.sort(array);
    }

    // 나머지 구하기
    public static int solution1(int num1, int num2) {
        return num1 % num2;
    }
}
