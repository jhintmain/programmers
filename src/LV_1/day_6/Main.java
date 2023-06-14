package LV_1.day_6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int[] num_list = {2, 1, 6};
        int[] quiz_1 = solution1(num_list);

        for (int i : quiz_1) {
            System.out.print(i);
        }

        System.out.println("========= Q2 ===========");
        int n = 0;
        String control = "wsdawsdassw";
        int quiz_2 = solution2(n, control);
        System.out.println(quiz_2);

        System.out.println("========= Q3 ===========");
        int[] log = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        String quiz_3 = solution3(log);
        System.out.println(quiz_3);

        System.out.println("========= Q4 ===========");
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 3}, {1, 2}, {1, 4}};
        int[] quiz_4 = solution4(arr, queries);
        for (int i : quiz_4) {
            System.out.print(i);
        }
        System.out.println();

        System.out.println("========= Q5 ===========");
        int[] arr5 = {0, 1, 2, 4, 3};
        int[][] queries5 = {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}};
        int[] quiz_5 = solution5(arr5, queries5);
        for (int i : quiz_5) {
            System.out.print(i);
        }
    }

    // 수열과 구간 쿼리 2
    public static int[] solution5(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;

        for (int[] query : queries) {
            answer[idx++] = IntStream.of(Arrays.copyOfRange(arr, query[0], query[1] + 1))
                    .filter(x -> x > query[2])
                    .min().orElse(-1);
        }
        return answer;

        // 다른사람 풀이
        /*return IntStream.range(0, queries.length)
                .map(q -> IntStream.rangeClosed(queries[q][0], queries[q][1])
                        .map(i -> arr[i])
                        .filter(i -> i > queries[q][2])
                        .min().orElse(-1)
                ).toArray();*/
    }

//    수열과 구간 쿼리 3
    public static int[] solution4(int[] arr, int[][] queries) {
        List<Integer> arrList = IntStream.of(arr).boxed().collect(Collectors.toList());

        for (int[] query : queries) {
            int idx_i = query[0];
            int idx_j = query[1];
            int ori_i = arrList.get(idx_i);
            int ori_j = arrList.get(idx_j);

            arrList.set(idx_i, ori_j);
            arrList.set(idx_j, ori_i);
        }

        return arrList.stream().mapToInt(i -> i).toArray();

        // 다른사람 풀이
        /*for (int[] query : queries) {
            int i = query[0], j = query[1];
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }*/
    }

    // 수 조작하기 2
    public static String solution3(int[] numLog) {
        StringBuilder str = new StringBuilder();
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'w');
        map.put(-1, 's');
        map.put(10, 'd');
        map.put(-10, 'a');

        for (int i = 1; i < numLog.length; i++) {
            int diff_num = numLog[i] - numLog[i - 1];
            str.append(map.get(diff_num));
        }
        return str.toString();
    }

    // 수조작하기 1
    public static int solution2(int n, String control) {
        int answer = n;
        for (char c : control.toCharArray()) {
            if (c == 'w') {
                answer += 1;
            } else if (c == 's') {
                answer -= 1;
            } else if (c == 'd') {
                answer += 10;
            } else {
                answer -= 10;
            }
        }
        return answer;

        // 다른사람 풀이
        // return control.chars().reduce(n, (acc, c) -> acc + (c == 'w' ? 1 : c == 's' ? -1 : c == 'd' ? 10 : -10));
    }

    //마지막 두 원소
    public static int[] solution1(int[] num_list) {
        List<Integer> intList
                = Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.toList());

        int last_val = intList.get(intList.size() - 1);
        int last_before_val = intList.get(intList.size() - 2);

        if (last_val > last_before_val) {
            intList.add(last_val - last_before_val);
        } else {
            intList.add(last_val * 2);
        }

        return intList.stream().mapToInt(i -> i).toArray();
    }


}
