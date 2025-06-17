class Solution {
    public int minimumCoins(int[] arr, int k) {
        // code here
        int n = arr.length;

        Arrays.sort(arr); 

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long minRemoved = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int minVal = arr[i];
            int upperLimit = minVal + k;

        
            int right = upperBound(arr, upperLimit);

            long leftRemove = prefix[i];  
            long rightRemove = (prefix[n] - prefix[right]) - (long)(n - right) * upperLimit;

            long totalRemove = leftRemove + rightRemove;
            minRemoved = Math.min(minRemoved, totalRemove);
        }

        return (int) minRemoved;
    }

    private int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
