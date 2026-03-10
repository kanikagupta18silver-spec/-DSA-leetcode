class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length ; 
        int count = 0 ;
        int i = 0 , j = 0 , curr_Sum = 0 , Zero_Count = 0 ;
        while(j < n)
        {
            curr_Sum = curr_Sum + nums[j] ;
          
            while(i < j && (curr_Sum > goal || nums[i] == 0))
            {
                if(nums[i] == 1)
                {
                    Zero_Count = 0  ;
                }
                else
                {
                    Zero_Count++ ;
                }
                curr_Sum -= nums[i] ;
                i++ ;
            }

            if(curr_Sum == goal)
            {
                count = count + 1 + Zero_Count ;
            }
            j++ ;
        }
        return count ;
    }
}