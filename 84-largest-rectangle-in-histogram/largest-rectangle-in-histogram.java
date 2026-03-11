class Solution {
    static class Pair
    {
        int key ;
        int val ;
        Pair(int key , int val)
        {
            this.key = key ;
            this.val = val ;
        }
    }
    public static int[] NSL_Solve(int[] arr)
    {
        Stack<Pair> stack = new Stack<>() ;
        int n = arr.length ;
        int[] ans = new int[n] ;
        for(int i = 0 ; i < n ; i++)
        {
            if(stack.isEmpty())
            {
                ans[i] = -1 ;
            }
            else if(!stack.isEmpty() && stack.peek().val < arr[i])
            {
                ans[i] = stack.peek().key ;
            }
            else if(!stack.isEmpty() && stack.peek().val >= arr[i])
            {
                while(!stack.isEmpty() && stack.peek().val >= arr[i])
                {
                    stack.pop() ;
                }
                if(stack.isEmpty())
                {
                    ans[i] = -1 ;
                }
                else
                {
                    ans[i] = stack.peek().key ;
                }
            }
            stack.push(new Pair(i,arr[i])) ;
        }
        return ans ;
    }

    public static int[] NSR_Solve(int[] arr)
    {
        Stack<Pair> stack = new Stack<>() ;
        int n = arr.length ;
        int[] ans = new int[n] ;
        for(int i = n-1 ; i >= 0 ; i--)
        {
            if(stack.isEmpty())
            {
                ans[i] = n ;
            }
            else if(!stack.isEmpty() && stack.peek().val < arr[i])
            {
                ans[i] = stack.peek().key ;
            }
            else if(!stack.isEmpty() && stack.peek().val >= arr[i])
            {
                while(!stack.isEmpty() && stack.peek().val >= arr[i])
                {
                    stack.pop() ;
                }
                if(stack.isEmpty())
                {
                    ans[i] = n ;
                }
                else
                {
                    ans[i] = stack.peek().key ;
                }
            }
            stack.push(new Pair(i,arr[i])) ;
        }
        return ans ;
    }
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length ;
        int[] NSL = new int[n] ;
        int[] NSR = new int[n] ;
        NSL = NSL_Solve(heights) ;
        NSR = NSR_Solve(heights) ;
        int Area = 0 ;
        for(int i = 0 ; i < n ; i++)
        {
            Area = Math.max(Area , (NSR[i]-NSL[i]-1)*heights[i]) ;
        }
        return Area ;
    }
}