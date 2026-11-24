import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int collect = 0;
        int max = 0;
        int minWin = 0;
       
        for(int k = 0; k < lottos.length; k++){
            boolean ok = false;
            for(int i = 0; i < win_nums.length; i++){
                if(win_nums[i] == lottos[k]){
                    ok = true;
                    break;
                }
            }
            if(lottos[k] != 0 && ok){
                collect++;
            }
            if(lottos[k] == 0)
                max++;
        }
        
        if(collect == 0)
            minWin = 6;
        else{
            minWin = 7 - collect;
        }
        
        int maxWin = (minWin-max) == 0?  1 : minWin-max;
        int[] answer = new int[]{maxWin, minWin};
        
        return answer;
    }
}