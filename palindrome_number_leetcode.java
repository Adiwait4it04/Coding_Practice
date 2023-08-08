public class palindrome_number_leetcode {
    public boolean isPalindrome(int x) 
    {
        if(x<0){
            return false;
        }
        int n = x;
        int reverse = 0;
        while(n!=0)
        {
            reverse = reverse*10 + (n%10);
            n= n/10;
        }
        return x== reverse;

    }
    public static void main(String[] args) {
        palindrome_number_leetcode p = new palindrome_number_leetcode();
        System.out.println(p.isPalindrome(121));
    }
}
