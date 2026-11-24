import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int r = 0, c = 0;
        queue.add(r);
        queue.add(c);
        visited[r][c] = true;
        
        int point = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size()/2;
            
            answer++;
    
            for(int i = 0; i < size; i++){
                r = queue.poll();
                c = queue.poll();
                point += 2;
                if(r == maps.length - 1 && c == maps[0].length - 1){
                    return answer;
                }
            
                if(r+1 < maps.length && !visited[r+1][c] && maps[r+1][c] == 1){
                    queue.add(r+1);
                    queue.add(c);
                    visited[r+1][c] = true;
                }
                if(r-1 >= 0 && !visited[r-1][c] && maps[r-1][c] == 1){
                    queue.add(r-1);
                    queue.add(c);
                    visited[r-1][c] = true;
                }
                if(c+1 < maps[0].length && !visited[r][c+1] && maps[r][c+1] == 1){
                    queue.add(r);
                    queue.add(c+1);
                    visited[r][c+1] = true;
                }
                if(c-1 >= 0 && !visited[r][c-1] && maps[r][c-1] == 1){
                    queue.add(r);
                    queue.add(c-1);
                    visited[r][c-1] = true;
                }
            }
        }
        
        return -1;
    }
}