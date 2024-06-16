package stu_20240615;

public class birsearch {
// left 
    public static void main(String[] args) {
       int nums[] = {4,5,6,7,0,1,2};
       int target = 0;
     int d =   sol(nums,0,nums.length-1,target);
    }

    private static int sol(int[] nums, int start, int end, int target) {
        if(start>=end) {
            return (nums[start] ==  target) ? start : -1;
        }

        int temp=-1;
        int mid= (start+end) /2;
        if(nums[mid]==target) {
            temp=mid;
        }else {
            temp= sol(nums, start, mid-1, target);
            if(temp < 0) {
                temp= sol(nums, mid+1, end, target);
            }
        }


        return temp;
    }
}
