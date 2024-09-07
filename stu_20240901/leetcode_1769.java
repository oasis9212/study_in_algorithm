package stu_20240901;

public class leetcode_1769 {
    public static void main(String[] args) {
        String boxes = "110";

        // 공간 복잡도 낮춘 유형?
        int[] answer1 = answer1(boxes);

        // 시간 복잡 줄인 유형
        int[] answer2= answer2(boxes);


    }

    private static int[] answer2(String b) {
        char[] boxes=b.toCharArray();
        int n = b.length();
        int[] left = new int[n];
        int[] right = new int[n];

        int c= boxes[0]-'0';
        for(int i=1;i<n;i++){
            left[i]=left[i-1]+c;
            c+=(boxes[i]-'0');
        }
        c= boxes[n-1]-'0';

        for (int i=n-2;i>=0 ;i--){
            right[i]=right[i+1]+c;
            c+=(boxes[i]-'0');
        }
        int[] ans=new int[n];
        for (int i=0;i<ans.length;i++){
            ans[i]=left[i]+right[i];
        }
        return ans;

    }

    private static int[] answer1(String boxes) {
        int[] answer = new int[boxes.length()];

        for (int idx = 0; idx < boxes.length(); idx++) {
            int minus = idx - 1;
            int plus = idx + 1;
            int count = 1;
            while (minus >= 0 || plus < boxes.length()) {
                if (minus >= 0 && boxes.charAt(minus) == '1') {
                    answer[idx] += count;
                }
                if (plus < boxes.length() && boxes.charAt(plus) == '1') {
                    answer[idx] += count;
                }
                minus--;
                plus++;
                count++;
            }

        }

        return answer;
    }
}