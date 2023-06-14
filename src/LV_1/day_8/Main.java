package LV_1.day_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        boolean x1 = true;
        boolean x2 = false;
        boolean x3 = false;
        boolean x4 = false;

        boolean quiz_1 = solution1(x1, x2, x3, x4);

        System.out.println(quiz_1);

        System.out.println("\n========= Q2 ===========");
        String my_string = "cvsgiorszzzmrpaqpe";
        int[] index_list = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
        String quiz_2 = solution2(my_string, index_list);
        System.out.println(quiz_2);

        System.out.println("\n========= Q3 ===========");
        int a = 2;
        int b = 2;
        int c = 2;
        int d = 2;

        int quiz_3 = solution3(a, b, c, d);
        System.out.println(quiz_3);

        System.out.println("\n========= Q4 ===========");
        String number = "78720646226947352489";
        int quiz_4 = solution4(number);
        System.out.println(quiz_4);

        System.out.println("\n========= Q5 ===========");
        String my_string5 = "rermgorpsam";
        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
        String quiz_5 = solution5(my_string5, queries);
        System.out.println(quiz_5);

        System.out.println("\n========= Q6 ===========");
        int n = 10;
        int k = 3;
        int quiz_6 = solution6(n,k);
        System.out.println(quiz_6);
    }

    // 양꼬치
    public static int solution6(int n, int k) {
        return (n*12000)+(k-(n/10))*2000;
    }

    // 문자열 여러 번 뒤집기
    public static String solution5(String my_string, int[][] queries) {
        StringBuilder str = new StringBuilder(my_string);

        for (int[] query : queries) {
            StringBuilder reverseStr = new StringBuilder(str.substring(query[0], query[1] + 1));
            reverseStr.reverse();
            str.replace(query[0], query[1] + 1, reverseStr.toString());
        }

        return str.toString();
    }

    public static int solution4(String number) {
        int answer = 0;
        for (char c : number.toCharArray()) {
            answer += Character.getNumericValue(c);
        }
        return answer % 9;
        // 다른사람 풀이  : '0' 아스키코드 = 48을 빼는 방식으로 한것 같음
//        return number.chars().map(c -> (c - '0') % 9).sum() % 9;

    }

    public static boolean solution1(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (x1 || x2) && (x3 || x4);
    }

    // 글자 이어 붙여 문자열 만들기
    public static String solution2(String my_string, int[] index_list) {
        StringBuilder str = new StringBuilder();
        for (int i : index_list) {
            str.append(my_string.charAt(i));
        }
        return str.toString();
    }

    public static int solution3(int a, int b, int c, int d) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        if (map.size() == 1) {
            answer = 1111 * a;
        } else if (map.size() == 4) {
            answer = Math.min(Math.min(a, b), Math.min(c, d));
        } else {
            List<Integer> list = new ArrayList<>(map.keySet());
            if (map.size() == 2) {
                if (map.get(list.get(0)) != 2) {
                    int q = (map.get(list.get(0)) > map.get(list.get(1))) ? list.get(0) : list.get(1);
                    int p = (map.get(list.get(0)) > map.get(list.get(1))) ? list.get(1) : list.get(0);
                    answer = (int) Math.pow((10 * q + p), 2);
                } else {
                    // 2. 2-2 :  (p + q) × |p - q|
                    answer = (list.get(0) + list.get(1)) * Math.abs(list.get(0) - list.get(1));
                }
            } else {
                // 3. 2-1-1 :  q × r
                answer = map.keySet().stream()
                        .filter(i -> map.get(i).equals(1))
                        .reduce(1, (total, n) -> total * n);
            }
        }
        return answer;
    }

    // 다른사람 풀이
//    public int solution_3_diff(int a, int b, int c, int d) {
//
//        int[] dice = { a, b, c, d };
//        Arrays.sort(dice);
//
//        int ans = 0;
//
//        if (dice[0] == dice[3]) {
//            ans = 1111 * dice[3];
//        } else if (dice[0] == dice[2] || dice[1] == dice[3]) {
//            ans = (int) Math.pow(dice[1] * 10 + (dice[0] + dice[3] - dice[1]), 2);
//        } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
//            ans = (dice[0] + dice[3]) * (dice[3] - dice[0]);
//        } else if (dice[0] == dice[1]) {
//            ans = dice[2] * dice[3];
//        } else if (dice[1] == dice[2]) {
//            ans = dice[0] * dice[3];
//        } else if (dice[2] == dice[3]) {
//            ans = dice[0] * dice[1];
//        } else {
//            ans = dice[0];
//        }
//
//        return ans;
//    }


}
