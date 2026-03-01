package stu_20260219;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_841 {
    public static void main(String[] args) {
        int[][] room = {{1}, {2}, {3}, {}};
        List<List<Integer>> rooms = new ArrayList<>();
        for (int i = 0; i < room.length; i++) {
            rooms.add(new ArrayList<>());
            for (int j = 0; j < room[i].length; j++) {
                rooms.get(i).add(room[i][j]);
            }

        }
        System.out.println(sol_841(rooms));
    }

    private static boolean sol_841(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        keys.add(0);
        goToroom(rooms, keys, 0);

        return keys.size() == rooms.size();
    }

    private static void goToroom(List<List<Integer>> rooms, Set<Integer> keys, int key) {
        List<Integer> room = rooms.get(key);
        for (int i = 0; i < room.size(); i++) {
            if (keys.add(room.get(i))) {
                goToroom(rooms, keys, room.get(i));
            }
        }
    }
}
