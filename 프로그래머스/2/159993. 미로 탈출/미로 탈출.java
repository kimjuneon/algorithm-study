import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        LinkedList<int[]> list = new LinkedList<>();
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S'){
                    int[] tmp = new int[2];
                    list.add(new int[]{i,j});
                } 
                visited[i][j] = false;
            }
        }
        
        boolean laber = false;
        boolean success = false;
        while(true) {
            int size = list.size();
            
            if(size == 0)
                return -1;
            
            for(int i = 0; i < size; i++) {
                int[] location = list.poll();
                int x = location[0];
                int y = location[1];
                if(visited[x][y])
                    continue;
                else
                    visited[x][y] = true;
                
                if(laber && maps[x].charAt(y) == 'E') {
                    success = true;
                    break;
                }
                if(!laber && maps[x].charAt(y) == 'L') {
                    laber = true;
                    for(int j = 0; j < visited.length; j++) {
                        for(int k = 0; k < visited[0].length; k++)
                            visited[j][k] = false;
                    }
                    int size1 = list.size();
                    for(int j = 0; j < size1; j++)
                        list.poll();
                    list.add(new int[] {x,y});
                    answer--;
                    break;
                }
                
                if(x > 0 && maps[x-1].charAt(y) != 'X') {
                    list.add(new int[] {x-1, y});
                }
                if(x < maps.length-1 && maps[x+1].charAt(y) != 'X') {
                    list.add(new int[] {x+1, y});
                }
                if(y > 0 && maps[x].charAt(y-1) != 'X') {
                    list.add(new int[] {x, y-1});
                }
                if(y < maps[0].length()-1 && maps[x].charAt(y+1) != 'X') {
                    list.add(new int[] {x, y+1});
                }
                    
            }
            if(success)
                return answer;
            answer++;
        }
    }
}