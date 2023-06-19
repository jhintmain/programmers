package LV_2.day_9;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int[] dot = {1, 2, 3, 4, 5};
        System.out.println(solution1(dot));

        System.out.println("========= Q2 ===========");
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 2;
        for (int[] num : solution2(num_list, n)) {
            System.out.println(Arrays.toString(num));
        }
        System.out.println("========= Q3 ===========");
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int k = 5;
        System.out.println(solution3(numbers, k));

        System.out.println("========= Q4 ===========");
        int[] numberss = {4, 455, 6, 4, -1, 45, 6};
        String direction = "left";
        System.out.println(Arrays.toString(solution4(numberss, direction)));

        System.out.println("========= Q4 ===========");
        String A = "hello";
        String B = "elloh";
        System.out.println(solution5(A, B));
    }


    // 문자열 밀기
    public static int solution5(String A, String B) {
//        String tempB = B.repeat(3);
//        return tempB.indexOf(A);
        boolean findFlag = false;
        int answer = 0;

        // Queue 큐에다가 배열한번에넣기
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, A.split(""));

        if (A.equals(B)) {
            findFlag = true;
        } else {
            for (int i = 1; i < A.length()+1; i++) {
                for (int j = 0; j < A.length() - i; j++) {
                    queue.add(queue.poll());
                }
                if (B.equals(String.join("", queue))) {
                    answer = i;
                    findFlag = true;
                    break;
                }
                queue.clear();
                Collections.addAll(queue, A.split(""));
            }
        }
        return findFlag ? answer : -1;
    }

    // 배열 회전시키기
    public static int[] solution4(int[] numbers, String direction) {
        Queue<Integer> queue = new LinkedList<>();
        for (int n : numbers) {
            queue.add(n);
        }
        switch (direction) {
            case "left" -> queue.add(queue.poll());
            case "right" -> {
                for (int i = 0; i < numbers.length - 1; i++) {
                    queue.add(queue.poll());
                }
            }
        }
        return queue.stream().mapToInt(i -> i).toArray();
    }

    // 공던지기
    public static int solution3(int[] numbers, int k) {
        int answer = 0;
        int i = 0;
        for (int count = 0; count < k; count++) {
            answer = numbers[(i) % numbers.length];
            i += 2;
        }
        return answer;
    }

    // 2차원으로 만들기
    public static int[][] solution2(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];

        for (int i = 0; i < num_list.length; i += n) {
            for (int j = 0; j < n; j++) {
                answer[i / n][j] = num_list[i + j];
            }
        }

        return answer;
    }

    //점의 위치 구하기
    public static int solution1(int[] dot) {
        return dot[0] > 0 ? (dot[1] > 0 ? 1 : 4) : dot[1] > 0 ? 2 : 3;
    }
}
