import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // 각 대기실
        for(int i = 0; i < 5; i++) {
            boolean isFalse = false;
            // System.out.println(i+1 + " 대기실");
            // 대기실 열
            for(int j = 0; j < 5; j++) {
                // 대기실 행
                for(int k = 0; k < 5; k++) {
                    // 사람이 있으면 BFS 수행
                    if(places[i][j].charAt(k) == 'P') {
                        boolean[][] visited = new boolean[5][5];
                        for(int p = 0; p < visited[0].length; p++)
                            Arrays.fill(visited[p], false);
                        
                        LinkedList<int[]> list = new LinkedList<>();
                        list.add(new int[] {j, k});
                        
                        // System.out.println("행, 열 : " + j + ", " + k);
                        
                        int count = 0;
                        while(list.size() > 0 && count <= 2) {
                            int size = list.size();
                            for (int p = 0; p < size; p++) {
                                int[] tmp = list.poll();
                                int x = tmp[0];
                                int y = tmp[1];
                                
                                if(visited[x][y])
                                    continue;
                                else
                                    visited[x][y] = true;
                                
                                if(places[i][x].charAt(y) == 'P' && count <= 2 && count != 0) {
                                    isFalse = true;
                                    // System.out.println("죽은 위치 : " + x + ", " + y + ", count : " + count);
                                    break;
                                }
                                    
                                if(x > 0 && places[i][x-1].charAt(y) != 'X') {
                                    list.add(new int[] {x-1, y});
                                }
                                if(x < 4 && places[i][x+1].charAt(y) != 'X') {
                                    list.add(new int[] {x+1, y});
                                }
                                if(y > 0 && places[i][x].charAt(y-1) != 'X') {
                                    list.add(new int[] {x, y-1});
                                }
                                if(y < 4 && places[i][x].charAt(y+1) != 'X') {
                                    list.add(new int[] {x, y+1});
                                }
                            }
                            count++;
                            if(isFalse) {
                                answer[i] = 0;
                                break;
                            }
                        }
                        if(isFalse)
                            break;
                    }
                }
                if(isFalse)
                    break;
                else
                    answer[i] = 1;
            }
        }
        
        
        return answer;
    }
}