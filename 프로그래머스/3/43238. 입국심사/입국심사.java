import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long low = 1, high = (long)1000000000*100000000;
        long mid = (low+high)/2;
        while(low < high) {
            if(pass(n, times, mid)) 
                high = mid;
            else
                low = mid+1;
            mid = (low+high)/2;
            System.out.println("low = " + low + ", high = " + high + ", mid = " + mid);
        }
        
        return mid;
    }
    
    private boolean pass(int n, int[] times, long time) {
        long remain = n;
        for (int i = 0; i < times.length; i++)  {
            remain -= time / times[i];
            if(remain <= 0)
                return true;
        }
        return false;
    }
}