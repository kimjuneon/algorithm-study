import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int remains = score.length % m;
        for (int i = 0; i < score.length/m; i++) {
            int idx = remains + i * m;
            answer += score[idx] * m;
        }
        
        return answer;
    }
}