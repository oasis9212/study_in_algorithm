package 스스로한다;

public class 쿼드트리 {
    static int onecount=0;
    static int zerocount=0;
    public static void main(String[] args) {
        int[][] arr= {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        sol(arr);

    }

    private static int[] sol(int[][] arr) {
        int ans[]=new int[2];



        QuadTree(arr,arr.length ,0,0, arr.length-1, arr.length-1);
        ans[0]=zerocount;
        ans[1]=onecount;

        System.out.println(zerocount+" :" + onecount );

        return ans;
    }

    private static void QuadTree(int[][] arr, int length ,int ystart,int xstart, int yend, int xend) {
        int val=arr[ystart][xstart];
        for(int i=ystart;i<=yend;i++){
            for(int k=xstart;k<=xend;k++){
                if(arr[i][k]!=val){
                    int len=length/2;
                    QuadTree(arr,len,ystart,xstart,yend-len,xend-len);
                    QuadTree(arr,len,ystart,xstart+len,yend-len,xend);
                    QuadTree(arr,len,ystart+len,xstart,yend,xend-len);
                    QuadTree(arr,len,ystart+len,xstart+len,yend,xend);
                    return;
                }
            }
        }
        if(val==0){
            zerocount++;
        }else{
            onecount++;
        }
    }
}
