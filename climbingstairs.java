public class climbingstairs {
    public static void main(String[] args) {
        int n=5;
        int arr[]= new int[n+1];
        int arr1[]= new int[n+1];
        arr1[0]=1;
        arr1[1]=1;
        for(int i=2;i<arr.length;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];EE
        }
        System.out.println(rec(n,arr1));
    }
    public static int rec(int n,int arr[])//
    {
        if (arr[n]!=0) {
            return arr[n];
        }
        if (n<0) {
            return 0;
        }
        arr[n]=rec(n-2,arr)+rec(n-1, arr);
        return arr[n];
    }
}
