public class fib {
    public static void main(String args[])
    {
        int n=5;
        int f[]=new int[n+1];
        System.out.println(fun(f, n));
    }

    public static int fun(int f[],int n)
    {
        if(n==0||n==1)
        {
            return n;
        }
        if (f[n]!=0) {
            return f[n];
        }
        f[n]= fun(f,n-1) + fun(f,n-2);
        return f[n];
    }

}
