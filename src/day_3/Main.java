package day_3;

public class Main {
    public static void main(String[] args) {
        // Quiz 1
        String quiz_1 = StringShuffling.solution("aaaaa","bbbbb");
        System.out.println(quiz_1);

        // Quiz 2
        String[] quizV2Arr ={"a","b","c"};
        String quiz_2 = ArrayToString.solution(quizV2Arr);
        System.out.println(quiz_2);

        // Quiz 3
        String quiz_3 = MultiplyString.solution("love",10);
        System.out.println(quiz_3);

        // Quiz 4
        int quiz_4 = MergeBigger.solution(9,91);
        System.out.println(quiz_4);

        // Quiz 5
        int quiz_5 = ComparingOperation.solution(91,2);
        System.out.println(quiz_5);

    }
}
