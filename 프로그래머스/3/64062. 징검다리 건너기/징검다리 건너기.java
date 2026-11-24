class Solution {
    public int solution(int[] stones, int k) {
        long low = 1, high = 200_000_000;
        long mid = (low + high) / 2;
        
        while(low < high) {
            if(pass(stones, k, mid))
                low = mid;
            else
                high = mid-1;
            mid = (low + high+1) / 2;
            
            System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);
        }
        
        return (int)mid;
    }
    
    private boolean pass(int[] stones, int k, long n) {
        int count = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i]-n < 0)
                count++;
            else
                count = 0;
            if(count >= k)
                return false;
        }
        return true;
    }
}