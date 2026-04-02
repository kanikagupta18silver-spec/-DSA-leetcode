class Solution {
    public int[] sortByBits(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // step 1: har number ke 1-bits count karo
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            int count = 0;
            while(num > 0){
                if(num % 2 == 1) count++;
                num = num / 2;
            }
            map.put(arr[i], count);
        }

        // step 2: sort using brute force
        int i = 0;
        while(i < arr.length){
            int j = i + 1;
            while(j < arr.length){
                int c1 = map.get(arr[i]);
                int c2 = map.get(arr[j]);

                if(c1 > c2 || (c1 == c2 && arr[i] > arr[j])){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
            i++;
        }
        return arr;
    }
}