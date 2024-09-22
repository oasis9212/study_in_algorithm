package stu_20240922;

import java.util.*;

public class Assigning_Work {
    static int count =0;
    public static void main(String[] args) {

        int[] difficulty = {68,35,52,47,86};
        int[] profit = {67,17,1,81,3};
        int[] worker = {92,10,85,84,82};
        ArrayList<Task> tasks = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            tasks.add(new Task(difficulty[i], profit[i]));
        }
        Collections.sort(tasks, Comparator.comparingInt(task -> task.profit));


        int w= tasks.get(profit.length-1).difficulty;
        for (int i = 0; i < tasks.size(); i++) {
            if(w<tasks.get(i).difficulty){

            }
        }


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < profit.length; i++) {
            map.put(difficulty[i], profit[i]);
        }
        Arrays.sort(difficulty);
        int total=0;

        for (int i = 0; i < worker.length; i++) {
            count=0;
            workReword(worker[i], map, difficulty, 0, difficulty.length - 1);
            total+=count;
        }
        System.out.println(total);

    }


    private static void workReword(int work, Map<Integer, Integer> map, int[] difficulty, int start, int end) {
        if (start > end) {
            return;
        }

        int middle = (start + end) / 2;
        int diff = difficulty[middle];

        if (diff <= work) {
            count = Math.max(count, map.get(diff));
            workReword(work, map, difficulty, middle + 1, end);
        }

         workReword(work, map, difficulty, start, middle - 1);

    }

}
class Task {
    int difficulty;
    int profit;

    public Task(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }
}
