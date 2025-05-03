package stu_20250422;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode_3016 {
    public static void main(String[] args) {
        System.out.println(sol_3016("aabbccddeeffgghhiiiiii"));
    }

    private static int sol_3016(String word) {
        int[] alphabet = new int[26];
        Set<Integer> alphabetExist = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            alphabet[word.charAt(i) - 'a']++;
            alphabetExist.add(word.charAt(i) - 'a');
        }

        List<Integer> sortedAlphabetLoc = alphabetExist.stream()
                .sorted((a, b) -> Integer.compare(alphabet[b], alphabet[a]))
                .toList();
        int count = 0;
        for (int i = 0; i < sortedAlphabetLoc.size(); i++) {
            count += alphabet[sortedAlphabetLoc.get(i)] * (i / 8 + 1);
        }


        return count;

    }
}
