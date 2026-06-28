class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int TotalGas = 0 ;
        int TotalCost = 0 ;
        int n = gas.length ;
        for(int i = 0 ; i < n ; i++)
        {
            TotalCost += cost[i] ;
            TotalGas += gas[i] ;
        }
        if(TotalCost > TotalGas) return -1 ;
    
        int total = 0 ;
        int ans = 0 ;

        for(int i = 0 ; i < n ; i++)
        {
            total += gas[i] - cost[i] ;
            if(total < 0)
            {
                total = 0 ;
                ans = i+1 ;
            }
        }
        return ans ;


    }
}
