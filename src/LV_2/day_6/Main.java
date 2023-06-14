package LV_2.day_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int[] numlist = {600, 400, 300, 200, 700, 800, 100, 900};
        int n = 500;
        System.out.println(Arrays.toString(solution1(numlist, n)));

        System.out.println("========= Q2 ===========");
        String s = "abcabcadc";
        System.out.println(solution2(s));

        System.out.println("========= Q3 ===========");
        int[] emergency = {30, 10, 23, 6, 100};
        System.out.println(Arrays.toString(solution3(emergency)));

        System.out.println("========= Q4 ===========");
        n = 15;
        System.out.println(solution4(n));
    }

    // 저주의 숫자 3
    public static int solution4(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            do {
                answer += 1;
            } while (answer % 3 == 0 || String.valueOf(answer).contains("3"));

        }
        return answer;
    }

    // 진료순서 정하기
    public static int[] solution3(int[] emergency) {
        int[] answer = new int[emergency.length];

        Map<Integer, Integer> tree_map = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < emergency.length; i++) {
            tree_map.put(emergency[i], i);
        }

        int i = 1;
        for (int idx : tree_map.values()) {
            answer[idx] = i++;
        }

        return answer;
    }

    // 한번만 등장한 문자
    public static String solution2(String s) {
        TreeSet<String> tree_set = new TreeSet<>();
        Set<String> already_set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (already_set.contains(String.valueOf(c))) {
                tree_set.remove(String.valueOf(c));
            } else {
                already_set.add(String.valueOf(c));
                tree_set.add(String.valueOf(c));
            }
        }
        return String.join("", tree_set);
    }

    // 특이한 정렬 - 못품
    public static int[] solution1(int[] numlist, int n) {
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(i -> i)
                .toArray();

/*        List<Integer> list = Arrays.stream(numlist)
                .boxed()
                .sorted((s1, s2) -> Integer.compare(Math.abs(s2 - n), Math.abs(s1 - n)))
                .collect(Collectors.toList());
        System.out.println(list);
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();*/
    }
}
