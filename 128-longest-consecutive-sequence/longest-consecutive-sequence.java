class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>() ;
        int ans = 0 ;

        for(int num : nums)
        {
            set.add(num) ;
        }
        for(int num : set)
        {
            int count = 0 ;
            int temp = num ;
            if(!set.contains(temp-1))
            {
                while(set.contains(temp))
                {
                    count++ ;
                    temp++ ;
                }
            }


            ans = Math.max(ans,count) ;

        }
        return ans ; 
    }
}