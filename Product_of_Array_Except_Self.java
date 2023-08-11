class Product_of_Array_Except_Self{
    public int[] productExceptSelf(int[] nums) {
        int []a= new int [nums.length];
        int left=1,right=1;
        for(int i=0;i<nums.length;i++)
        {
            left=1;right=1;
           for(int j=0;j<nums.length;j++)
           {
               if(j<i)
               {
                   left=left*nums[j];
               }
               if(j>i)
               {
                   right=right*nums[j];
               }
           }
           a[i]=left*right;
        }
        return a;
        
    }
}