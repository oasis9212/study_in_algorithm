package stu_20250914;

public class leetcode_318 {
    public static void main(String[] args) {

        System.out.println(sol_318(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }

    private static int sol_318(String[] words) {
        int n= words.length;
        int[] masks =new int[n];


        for (int i=0;i<n;i++){
            for (char c : words[i].toCharArray()) {
                masks[i] |= (1<< c -'a');
            }
        }

        int largest =0 ;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if((masks[i] & masks[j]) == 0){
                    largest = Math.max(largest,words[i].length() * words[j].length());
                }

            }
        }

        return largest;
    }
}
