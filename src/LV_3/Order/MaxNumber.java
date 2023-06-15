package LV_3.Order;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxNumber {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0, 0};

        String answer =
                IntStream.of(numbers)
                        .mapToObj(String::valueOf)
                        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                        .collect(Collectors.joining());
        answer = (answer.replaceAll("0", "").equals("")) ? "0" : answer;
        System.out.println(answer);

    }
}
