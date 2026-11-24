import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer++;
                dfs(i, computers, visited);
            }
        }
        
        
        return answer;
    }
    
    private void dfs(int start, int[][] computers, boolean[] visited){
        for(int i = 0; i < computers[start].length; i++){
            if(!visited[i] && computers[start][i] == 1){
                visited[i] = true;
                dfs(i, computers, visited);
            }
        }
    }
}