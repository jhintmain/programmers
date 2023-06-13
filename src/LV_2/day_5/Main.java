package LV_2.day_5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int n = 7;
        int q1 = solution1(n);
        System.out.println(q1);

        System.out.println("========= Q2 ===========");
        n = 10;
        int q2 = solution2(n);
        System.out.println(q2);

        System.out.println("========= Q3 ===========");
        int slice = 7;
        n = 10;
        int q3 = solution3(slice, n);
        System.out.println(q3);

        System.out.println("========= Q4 ===========");
        int age = 40;
        int q4 = solution4(age);
        System.out.println(q4);

        System.out.println("========= Q5 ===========");
        int[] num_list = {1, 0, 1, 1, 1, 3, 5};
        int[] q5 = solution5(num_list);
        for (int num : q5) {
            System.out.print(num + " ");
        }

        System.out.println("\n========= Q6 ===========");
//        String[] spell = {"p", "o", "s"};
//        String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};
        int q6 = solution6(spell, dic);
        System.out.println(q6);

        System.out.println("========= Q7 ===========");
        String my_str = "abc1Addfggg4556b";
        n = 6;
        String[] q7 = solution7(my_str, n);
        System.out.println(Arrays.toString(q7));

    }
    // 잘라서 배열로 저장하기
    public static String[] solution7(String my_str, int n) {
        List<String> list = new ArrayList<>();

        int my_str_len =  my_str.length();
        int start_idx = 0;
        int end_idx = n;
        int max_idx = my_str_len % n ==0 ? my_str_len/n : (my_str_len/n)+1;

        for(int i=0; i< max_idx; i++){
            list.add(my_str.substring(start_idx,end_idx));

            start_idx = end_idx;
            end_idx = Math.min(end_idx + n, my_str_len);
        }

        return list.toArray(new String[0]);

   /*     return IntStream.range(0, my_str.length() / n + (my_str.length() % n > 0 ? 1 : 0))
                .mapToObj(i -> i == my_str.length() / n ? my_str.substring(i * n) : my_str.substring(i * n, (i + 1) * n))
                .toArray(String[]::new);*/
    }

    // 외계어 사전
    public static int solution6(String[] spell, String[] dic) {
        for (String word : dic) {
            boolean flag = false;
            for (String s : spell) {
                if(word.contains(s)){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                return 1;
            }
        }
        return 2;
    }

    // 피자 나눠 먹기(1)
    public static int solution1(int n) {
        int peice = 7;
        int add = (n % peice != 0) ? 1 : 0;
        return (n / peice) + add;
    }

    // 피자 나눠 먹기(2)
    public static int solution2(int n) {
        int peice = 6;
        return lcm(peice, n) / peice;
    }

    // 피자 나눠 먹기(2)
    public static int solution3(int slice, int n) {
        return n % slice == 0 ? n / slice : (n / slice) + 1;
    }

    // 나이 출력
    public static int solution4(int age) {
        int defaultYear = 2022;
        return defaultYear - age + 1;
    }

    // 배열 정렬
//    public static int[] solution5(int[] num_list) {
//        return IntStream.of(num_list)
//                .boxed()
//                .sorted(Comparator.reverseOrder())
//                .mapToInt(i->i)
//                .toArray();
//    }

    // 배열 뒤집기
    public static int[] solution5(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(list);

        return list.stream().mapToInt(i -> i).toArray();
    }

    // 유클리드 호제법 - 최대 공약수
    static int gcd(int x, int y) {
        // a에 큰값 셋팅 - 방법 1
        int a = Math.max(x, y);
        int b = Math.max(x, y);

        // a에 큰값 셋팅 - 방법 2
/*        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }*/
        while (b != 0) {
            int n = a % b;
            a = b;
            b = n;
        }
        return a;
    }

    // 최소 공배수
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
