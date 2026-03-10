class Solution {
    public int numberOfSubstrings(String s) {
        
        int i = 0 , j = 0 , n = s.length() ;
        int[] check = new int[3] ;
        int count = 0 ;
        while(j < n)
        {
            if(s.charAt(j) == 'a') check[0]++ ;
            if(s.charAt(j) == 'b') check[1]++ ;
            if(s.charAt(j) == 'c') check[2]++ ;
            
            while(check[0] > 0 && check[1] > 0 && check[2] > 0)
            {
                count += n - j ;
                check[s.charAt(i)-'a']-- ;
                i++ ;
            }

            j++ ;
        }
        return count ;
    }
}