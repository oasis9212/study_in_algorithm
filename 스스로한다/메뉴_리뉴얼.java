package 스스로한다;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72411
public class 메뉴_리뉴얼 {
    public static void main(String[] args) {
        String[] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course={2,3,4};

        String[] answer= sol(orders,course);
    }

    private static String[] sol(String[] orders, int[] course) {
        Set<Character>[] ordermenu= new Set[orders.length];
        Set<Character> courseSet=new HashSet<>();

        for(int i=0;i<orders.length;i++){
            ordermenu[i] =new HashSet<Character>();
            for(int k=0;k<orders[i].length();k++){
                ordermenu[i].add(orders[i].charAt(k));
                courseSet.add(orders[i].charAt(k));
            }
        }
        List<String> list= new ArrayList<>();
        Set<Set<Character>> comb=maakeComb(courseSet, course);
        for(Set<Character> e : comb){
            int count=0;
            for(int i=0;i<ordermenu.length;i++){
                if(count>=2){
                    break;
                }

                boolean TF= true;
                for(Character  cha  : e){
                    if(!ordermenu[i].contains(cha)){
                        TF=false;
                    }
                }
                if (TF) count++;
            }
            if(count==2){
                StringBuilder sb= new StringBuilder();
                for(Character  cha  : e){
                    sb.append(cha);
                }
                list.add(sb.toString());
            }



        }



        System.out.println("asd");

        return  null;
    }

    private static Set<Set<Character>> maakeComb(Set<Character> courseSet, int[] course) {
        Set<Set<Character>> result= new HashSet<>();
       for(int i : course){
           Combinations(courseSet,new LinkedHashSet<Character>(), i, result);
       }
       return result;

    }

    private static void Combinations(Set<Character> courseSet, LinkedHashSet<Character> addOn, int len, Set<Set<Character>> result) {
        if(addOn.size()==len){
            result.add(new LinkedHashSet<>(addOn));
            return;
        }

        for(Character i: new HashSet<>(courseSet)){
            addOn.add(i);
            courseSet.remove(i);
            Combinations(courseSet,addOn,len,result);
            addOn.remove(i);
            courseSet.add(i);
        }

    }


}
