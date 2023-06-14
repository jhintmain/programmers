package LV_1.day_5;

/**
 * Date : 2023-05-31
 * Lessons : 코딩 기초 트레이닝 > 이어붙인수
 * Comment : -
 */
public class ConcatenatedNumber {
    public static int solution(int[] num_list) {
        StringBuilder oddStr = new StringBuilder();
        StringBuilder evenStr = new StringBuilder();

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                oddStr.append(num_list[i]);
            } else {
                evenStr.append(num_list[i]);
            }
        }

        return Integer.parseInt(oddStr.toString()) + Integer.parseInt(evenStr.toString());
    }
}
