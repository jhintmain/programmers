package LV_2.day_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int num1 = 2;
        int num2 = 3;
        int q1 = solution1(num1, num2);
        System.out.println(q1);

        System.out.println("========= Q2 ===========");
        String numbers = "onetwothreefourfivesixseveneightnine";
        long q2 = solution2(numbers);
        System.out.println(q2);
    }

    public static int solution1(int num1, int num2) {
        return num1 + num2;
    }

    public static long solution2(String numbers) {
        String[] guid = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < guid.length; i++) {
            numbers = numbers.replace(guid[i],Integer.toString(i));
        }
        return Long.parseLong(numbers);
    }

}
