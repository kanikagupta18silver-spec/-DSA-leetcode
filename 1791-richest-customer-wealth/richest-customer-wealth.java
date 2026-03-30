class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        // for(int i=0;i<accounts.length;i++)
        for(int[] customer : accounts){
            int sum=0;
            // for(int j=0;j<accounts[i].length;j++)
            for(int money:customer){
                // sum=sum+accounts[i][j];
                sum+=money;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}