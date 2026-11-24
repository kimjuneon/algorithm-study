import java.util.*;

class Solution {
    public int solution(int[][] tmp) {
        int answer = 0;
        
        // 가장 많이 없애는 것부터 순서대로 진행? => 가장 빨리 끝나는 거에서 끝에 쏘기
        // 실수도 가능이므로 스케일을 2배로 계산
        int[][] targets = new int[tmp.length][tmp[0].length];
        int max = 0; // 전체 탐색 범위
        
        // 스케일 2배로 늘리기
        for(int i = 0; i < tmp.length; i++){
            for(int j = 0; j < tmp[0].length; j++){
                targets[i][j] = tmp[i][j]*2;
            }
            if(targets[i][1] > max)
                max = targets[i][1];
        }
        
        // 정렬
        Arrays.sort(targets, (a,b) -> {
            int tmp2 =  a[1] - b[1];
            if(tmp2 != 0)
                return tmp2;
            else
                return a[0] - b[0];
        });
        
        boolean[] destroyed = new boolean[targets.length];
        int remains = destroyed.length;
    
        int ttmp = 0;
        while(remains > 0){
            int currentTarget = 0;
            for(int i = ttmp; i < targets.length; i++){
                if(!destroyed[i]){
                    currentTarget = targets[i][1]-1;
                    ttmp = i;
                    break;
                }
            }
            for(int i = ttmp; i < targets.length; i++){
                if(!destroyed[i] && targets[i][0] < currentTarget && targets[i][1] > currentTarget){
                    destroyed[i] = true;
                    remains--;
                }
            }
            answer++;
        }    
        
        return answer;
    }
}