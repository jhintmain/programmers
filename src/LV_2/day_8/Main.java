package LV_2.day_8;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int[] numbers = {1, 2, 3, 4, 5};
        int num1 = 1;
        int num2 = 3;
        System.out.println(Arrays.toString(solution1(numbers, num1, num2)));

        System.out.println("========= Q2 ===========");
        int age = 23;
        System.out.println(solution2(age));

        System.out.println("========= Q3 ===========");
        int n = 1000000;
        System.out.println(solution3(n));

        System.out.println("========= Q4 ===========");
        int hp = 999;
        System.out.println(solution4(hp));

        System.out.println("========= Q4 ===========");
        int balls = 5;
        int share = 3;
//        System.out.println(solution5(balls, share));

        System.out.println("========= Q6 ===========");
        String rsp = "205";
        System.out.println(solution6(rsp));

        System.out.println("========= Q7 ===========");
        System.out.println(solution7(".... . .-.. .-.. ---"));
    }

    public static String solution7(String letter) {
        String morse = ".-:a,-...:b,-.-.:c,-..:d,.:e,..-.:f,--.:g,....:h,..:i,.---:j,-.-:k,.-..:l,--:m,-.:n,---:o,.--.:p,--.-:q,.-.:r,...:s,-:t,..-:u,...-:v,.--:w,-..-:x,-.--:y,--..:z";
        Map<String, String> maps = Arrays.stream(morse.split(","))
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(
                        a -> a[0],  //key
                        a -> a[1]   //value
                ));

        return Arrays.stream(letter.split(" "))
                .map(maps::get)
                .collect(Collectors.joining());
    }

    // 가위바위보
    public static String solution6(String rsp) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(2, 0);
        map.put(0, 5);
        map.put(5, 2);

        return rsp.chars()
                .map(i -> map.get(Character.getNumericValue(i)))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    // 구슬을 나누는 경우의 수
//    public static int solution5(int balls, int share) {
//        if (balls == share) {
//            return 1;
//        }
//        BigInteger ballPack = new BigInteger("1");
//        BigInteger subPack = new BigInteger("0");
//        BigInteger sharePack = new BigInteger("0");
//
//        for (int i = 1; i <= balls; i++) {
//            ballPack.multiply(BigInteger.valueOf(i));
//            if (i == balls - share) {
//                subPack = ballPack;
//            }
//            if (i == share) {
//                sharePack = ballPack;
//            }
//        }
//
//        return BigInteger.intValue(ballPack.divide(subPack.multiply(sharePack)));
//    }

    private long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


    // 개미군단
    public static int solution4(int hp) {
        int[] ants = {5, 3, 1};
        int answer = 0;

        for (int ant : ants) {
            int mok = hp / ant;
            answer += mok;
            hp -= ant * mok;
        }
        return answer;
    }


    // 순서쌍의 개수
    public static int solution3(int n) {
        // return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (set.contains(i)) {
                    break;
                } else {
                    set.add(i);
                }
            }
        }
        return set.size();
    }


    // 외계행성의 나이
    public static String solution2(int age) {
        // a: 97 0 :48 = 49
        String answer = String.valueOf(age)
                .chars()
                .mapToObj(i -> String.valueOf((char) (i + 49)))
                .collect(Collectors.joining());
        return answer;
    }

    // 배열자르기
    public static int[] solution1(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
