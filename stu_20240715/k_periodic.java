package stu_20240715;

import java.util.*;


public class k_periodic {
    public static void main(String[] args) {
        String word="leetcoleet";
        int k=2;
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<word.length();i+=k){
            String s= word.substring(i,k+i);
            map.put(s,map.getOrDefault(s,0)+1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        int count=0;
        for (int i =1;i<list.size();i++){
            count+=map.get(list.get(i));
        }
        System.out.println(count);



    }
}
