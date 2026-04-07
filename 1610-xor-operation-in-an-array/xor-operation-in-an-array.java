class Solution {
    public int xorOperation(int n, int start) {
        int s = start >> 1;
        int e = n & start & 1;
        return (xor(s - 1) ^ xor(s + n - 1)) << 1 | e;
    }

    private int xor(int x) {
        switch (x & 3) {
            case 0: return x;
            case 1: return 1;
            case 2: return x + 1;
            default: return 0;
        }
    }
}