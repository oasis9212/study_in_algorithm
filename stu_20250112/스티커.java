package stu_20250112;


public class 스티커 {
    public static void main(String[] args) {
        //  System.out.println(stick(new int[]{ 1, 22, 1, 1, 33, 1, 1, 1}));
        System.out.println(stick(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));

    }

    private static int stick(int[] sticker) {
        if (sticker.length == 1) {
            return sticker[0];
        } else if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        // [0]배열 선택 할경우.
        int[] ChoiceZero = new int[sticker.length - 1];
        ChoiceZero[0] = sticker[0];
        ChoiceZero[1] = sticker[0];
        for (int i = 2; i < sticker.length - 1; i++) {
            ChoiceZero[i] = Math.max(sticker[i] + ChoiceZero[i - 2], ChoiceZero[i - 1]);
        }
        int[] ChoiceOne = new int[sticker.length];
        ChoiceOne[0] = 0;
        ChoiceOne[1] = sticker[1];
        for (int i = 2; i < ChoiceOne.length; i++) {
            ChoiceOne[i]=Math.max(sticker[i] + ChoiceOne[i - 2], ChoiceOne[i - 1]);
        }


        return Math.max(ChoiceZero[ChoiceZero.length-1],ChoiceOne[ChoiceOne.length-1]);
    }
}
