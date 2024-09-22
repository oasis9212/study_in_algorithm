package stu_20240922;

import java.util.*;

public class Convert_Array {
    public static void main(String[] args) {
        int[] nums={1,3,4,1,2,3,1};
        List<List<Integer>> result= new ArrayList<>();
        Map<Integer,Integer> countInt =new HashMap<>();

        for(int i : nums){
            countInt.put(i,countInt.getOrDefault(i,0)+1);
        }

        Iterator<Integer> iter= countInt.keySet().iterator();
        while ( iter.hasNext()){
           int key= iter.next();
           int count=countInt.get(key);

           for(int resultSize=result.size() ; resultSize< count ; resultSize++){
                result.add(new ArrayList<>());
           }

           for (int i =0 ;i<count;i++){
               result.get(i).add(key);
           }

        }

        System.out.println(result.toString());


    }
}
