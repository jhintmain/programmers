package LV_2.day_3;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;
        int q1 = solution1(priorities, location);
        System.out.println("============");
        System.out.println(q1);

        System.out.println("========= Q2 ===========");
        int[] prices = {1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 1, 2, 3};
        int[] q2 = solution2(prices);
        for (int num : q2) {
            System.out.print(num + " ");
        }

        System.out.println("\n========= Q3 ===========");
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
        int[] progresses = {1, 1, 1, 1};
        int[] speeds = {100, 50, 99, 100};
        int[] q3 = solution3(progresses, speeds);
        for (int num : q3) {
            System.out.print(num + " ");
        }
    }

    public static int[] solution3(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()){
            int day = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty() && day >= queue.peek()){
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // 주식가격
    public static int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int num = prices[i];
            answer[i] = (int) IntStream.of(Arrays.copyOfRange(prices, i + 1, prices.length))
                    .filter(j -> j >= num)
                    .count();
        }
        return answer;
    }

    // 스택/큐 > 프로세스
    public static int solution1(int[] priorities, int location) {
        int answer = 0;
        Queue<Map<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(i, priorities[i]);
            queue.add(map);
        }

        while (queue.size() != 0) {
            int max = 0;
            Iterator<Map<Integer, Integer>> itr = queue.iterator();
            while (itr.hasNext()) {
                Map<Integer, Integer> map2 = itr.next();
                for (int val : map2.values()) {
                    max = Math.max(max, val);
                }
            }
            Map<Integer, Integer> wmap = queue.poll();

            for (int key : wmap.keySet()) {
                if (wmap.get(key) < max) {
                    queue.add(wmap);
                } else {
                    answer++;
                    if (key == location) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}

