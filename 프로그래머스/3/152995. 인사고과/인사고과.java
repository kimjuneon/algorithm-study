import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int a1 = scores[0][0];
        int b1 = scores[0][1];
        int sum = a1 + b1;
        
        int[][] tmp = new int[scores.length-1][scores[0].length-1];
        tmp = Arrays.copyOfRange(scores, 1, scores.length);
        
        Arrays.sort(tmp, (a,b) -> (b[0]+b[1])-(a[0]+a[1]));
        
        for(int i = 0; i < tmp.length; i++){
            if(tmp[i][0] > a1 && tmp[i][1] > b1){
                return -1;
            }
            if((tmp[i][0]+tmp[i][1]) > sum){
                boolean success = true;
                for(int k = 0; k < i; k++){
                    if(tmp[k][0] > tmp[i][0] && tmp[k][1] > tmp[i][1]){
                        success = false;
                        break;
                    }
                }
                if(success)
                    answer++;
            }
            else
                return answer;
        }
        
        return answer;
    }
}