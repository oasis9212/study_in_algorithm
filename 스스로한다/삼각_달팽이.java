package 스스로한다;

public class 삼각_달팽이 {

    public static void main(String[] args) {
        int n=4;
       int[] ans= sol(n);
    //1 3 6 10
    }

    private static int[] sol(int n) {
        int len=0;
        int[][] tangle=new int[n][];
        for(int i=0;i<n;i++){
            tangle[i]= new int[i+1];
            len+=i+1;
        }

        int change=0;

        int count=1;

        int startSe=0;
        int startGa=0;
        while (len>=count){
            if(startSe<n  && tangle[startSe].length > startGa && tangle[startSe][startGa]==0){
                tangle[startSe][startGa]=count;
                count++;
            }else{
                switch (change%3){
                    case 0:
                        startSe--;
                        break;
                    case 1:
                        startGa--;
                        break;
                    default:
                        startSe++;
                        startGa++;
                        break;
                }
                change++;
            }
            switch (change%3){
                case 0:
                    startSe++;
                    break;
                case 1:
                    startGa++;
                    break;
                default:
                    startSe--;
                    startGa--;
                    break;
            }
        }
        int[] ary=new int[len];
        int loc=0;
        for(int i=0;i<tangle.length;i++){
            for(int k=0;k<tangle[i].length;k++){
                ary[loc]=tangle[i][k];
                loc++;

            }
        }




        return ary;




    }
}
