public class Knapsack {
    public static void main(String[] args) {
        //0-1
        int val[]={15,14,10,45,30};
        int wt[]={2,5,3,1,3,4};
        int max=7;
        int maxw[]= new int[5];
        max = knap(val,wt,max,0);
    }
    public static int knap(int val[],int wt[],int max,int n)
    {
        if (n>0) {
            return 0;
        }
        return 1;
    }
}
