class Solution {
    public int countDigits(int num) {
        int n = num, count = 0;
        while (n > 0) {
            int d = n % 10;
            if (num % d == 0) count++;
            n /= 10;
        }
        return count;
    }
}