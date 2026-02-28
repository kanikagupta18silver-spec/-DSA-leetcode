class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int leftSum = 0 , rightSum = 0 , maxSum = 0 , n = cardPoints.length ;

        for(int i = 0 ; i < k ; i++)
        {
            leftSum += cardPoints[i] ;
        }
        maxSum = leftSum ;
        for(int i = 0 ; i < k ; i++)
        {
            leftSum -= cardPoints[k-i-1] ;
            rightSum += cardPoints[n-i-1] ;
            maxSum = Math.max(maxSum, leftSum + rightSum); ;
        }
       
        return maxSum ;
    }
}