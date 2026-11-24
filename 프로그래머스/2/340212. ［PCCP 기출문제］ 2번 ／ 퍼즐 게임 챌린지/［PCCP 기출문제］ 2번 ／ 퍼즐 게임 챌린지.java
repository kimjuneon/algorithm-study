class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = 0, min = 1;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] > max)
                max = diffs[i];
        }
        
        int level = (min+max) / 2;
        // System.out.println("min = " + min + ", max = " + max + ", level = " + level);
        while(min <= max) {
            if(min == max)
                return min;
            boolean correct = ok(diffs, times, limit, level);
            if(correct) {
                max = level;
            } else {
                min = level+1;
            }
            level = (min+max) / 2;
            // System.out.println("통과 : " + correct + ", min = " + min + ", max = " + max + ", level = " + level);
        }
        
        return min;
    }
    
    private boolean ok(int[] diffs, int[] times, long limit, int level) {
        long count = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= level)
                count += times[i];
            else if(i > 0)
                count += (times[i-1] + times[i]) * (diffs[i]-level) + times[i];
            else
                count += times[i] * (diffs[i]-level);
            if(count > limit)
                    return false;
        }
        return true;
    }
}