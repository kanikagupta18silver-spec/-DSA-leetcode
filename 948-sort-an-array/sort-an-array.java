class Solution {
    public void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] arr = new int[high - low + 1];
        int index = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                arr[index++] = nums[left++];
            } else {
                arr[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            arr[index++] = nums[left++];
        }

        while (right <= high) {
            arr[index++] = nums[right++];
        }

        for (int i = 0; i < arr.length; i++) {
            nums[low + i] = arr[i];
        }
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public int[] sortArray(int[] nums) {
        // MergeSort
        int low = 0, high = nums.length - 1;
        mergeSort(nums, low, high);
        return nums;
    }
}