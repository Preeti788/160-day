class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int n = heights.length;
        
        int low = 1, high = 10000;
        int answer = Integer.MAX_VALUE;
        
        while (low <= high){
            int mid = (low + high)/2;
            int cost1 = getTotalCost(heights, cost, mid);
             int cost2 = getTotalCost(heights, cost, mid + 1);
            
            answer = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return answer;
    }
    
    private int getTotalCost(int[] heights, int[] cost, int targetHeight) {
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += Math.abs(heights[i] - targetHeight) * cost[i];
        }
        
        
        return total;
        
        
    }
}
