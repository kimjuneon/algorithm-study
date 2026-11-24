import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length, m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] c = new int[land[0].length];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 아직 처리되지 않은 석유 발견 & 탐색 시작
                if(!visited[i][j] && land[i][j] == 1) {
                    int size = 0;
                    Set<Integer> columns = new HashSet<Integer>();
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[] {i, j});
                    
                    while(!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        int x = tmp[0];
                        int y = tmp[1];
                        
                        if(x < 0 || y < 0 || x >= n || y >= m || land[x][y] != 1)
                            continue;
                        if(visited[x][y])
                            continue;
                        
                        visited[x][y] = true;
                        columns.add(y);
                        size++;
                        
                        queue.add(new int[] {x-1, y});
                        queue.add(new int[] {x, y-1});
                        queue.add(new int[] {x+1, y});
                        queue.add(new int[] {x, y+1});
                    }
                    for (int column : columns) {
                        c[column] += size;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            if(answer < c[i])
                answer = c[i];
        }
        
        return answer;
    }
}