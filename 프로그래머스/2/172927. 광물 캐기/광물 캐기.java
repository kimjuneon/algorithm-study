import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            int tmp = dfs(0, i, 0, picks.clone(), minerals);
            if(tmp < min)
                min = tmp;
        }
        
        return min;
    }
    
    private int dfs(int current, int pick, int k, int[] picks, String[] minerals){
        boolean end = true;
        for(int i = 0; i < 3; i++)
            if(picks[i] != 0)
                end = false;
        if(end || current == minerals.length)
            return k;
        
        if(picks[pick] == 0)
            return Integer.MAX_VALUE;
        
        for(int i = 0; i < 5; i++){
            if(current == minerals.length)
                break;
            
            if(minerals[current].equals("diamond")){
                if(pick == 0)
                    k += 1;
                if(pick == 1)
                    k += 5;
                if(pick == 2)
                    k += 25;
            }else if(minerals[current].equals("iron")){
                if(pick == 0)
                    k += 1;
                if(pick == 1)
                    k += 1;
                if(pick == 2)
                    k += 5;
            } else {
                k += 1;
            }
            current++;
        }
        picks[pick]--;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            int tmp = dfs(current, i, k, picks.clone(), minerals);
            if(tmp < min)
                min = tmp;
        }
        
        return min;
    }
}