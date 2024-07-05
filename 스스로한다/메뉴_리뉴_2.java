package 스스로한다;

import java.util.*;

public class 메뉴_리뉴_2 {
    public static void main(String[] args) {


        String[] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course={2,3,4};

        String[] answer= sol(orders,course);

    }

    private static String[] sol(String[] orders, int[] course) {
        HashMap<Character,Integer> hs= new HashMap<>();

        for(int i=0;i<orders.length;i++){
            for(int k=0;k<orders[i].length();k++){
                hs.put( orders[i].charAt(k), hs.getOrDefault( orders[i].charAt(k),0)+1);

            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(hs.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<String> ary =new ArrayList<>();


        for(int count: course){
            int menucount=0;
            StringBuilder sb= new StringBuilder();
            for(Map.Entry<Character,Integer> entry : list){



                if(sb.length()>count){
                    sb.append(entry.getKey());
                }

                if(sb.length()==count){
                    int total= gettotal(orders,sb);
                    menucount=Math.max(menucount,total);
                }


            }
        }


        return null;
    }

    private static int gettotal(String[] orders, StringBuilder sb) {
        int count=0;

        loop :  for (int i=0;i<orders.length;i++){
             for(int k=0;k<sb.length();k++){
                if(orders[i].indexOf(sb.charAt(k))==-1){
                    continue loop;
                }
            }
             count++;
        }
        return count;

    }
}
