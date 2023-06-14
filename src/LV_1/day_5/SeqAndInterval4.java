package LV_1.day_5;

/**
 * Date : 2023-05-30
 * Lessons : 코딩 기초 트레이닝 >
 * Comment : -
 */
public class SeqAndInterval4 {
    public static int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();

        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (j == 0 || j % queries[i][2] == 0) {
                    answer[j] += 1;
                }
            }
        }

        return answer;
    }
}
