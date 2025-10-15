package stu_20251012;

import java.util.*;

public class leetcode_811 {
    public static void main(String[] args) {
        System.out.println(sol_811(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}).toString());
    }

    private static List<String> sol_811(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cpdomains.length; i++) {
            String[] numAndDomain = cpdomains[i].split(" ");
            Integer num =Integer.parseInt(numAndDomain[0]);
            String[] domain = numAndDomain[1].split("\\.");
            StringBuilder str= new StringBuilder(domain[domain.length - 1]);
            map.put(str.toString(),map.getOrDefault(str.toString(),0)+num);
            for (int j = domain.length-2; j >= 0; j--) {
                str.insert(0, domain[j] + '.');
                map.put(str.toString(),map.getOrDefault(str.toString(),0)+num);
            }
        }
        List<String> res=new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }

        return res;
    }
}
