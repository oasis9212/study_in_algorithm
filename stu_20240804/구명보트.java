package stu_20240804;

import java.util.Arrays;


public class 구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        Arrays.sort(people);  // 우선 정렬 오름 차순.
        // 최악은 사람의 길이만큼 타야한다.
        // 무개 제일 많이 나가는 사람 + 제일 적게 나가는 사람 >= limit
        int little = 0;
        int big = people.length - 1;
        while (big > little) {
            if (people[big] + people[little] <= limit) {
                little++;
            }
            big--;
        }
        System.out.println(people.length - little);


    }
}
