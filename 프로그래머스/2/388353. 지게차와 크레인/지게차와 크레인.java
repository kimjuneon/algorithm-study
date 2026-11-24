import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        char[][] container = new char[storage.length+2][storage[0].length()+2];
        for(int i = 0; i < container.length; i++) {
            for (int j = 0; j < container[0].length; j++) {
                if(i == 0 || j == 0 || i == container.length-1 || j == container[0].length-1) {
                    container[i][j] = '*';
                } else
                    container[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        for (int i = 0; i < requests.length; i++) {
            char c = requests[i].charAt(0);
            if(requests[i].length() == 1) {
                boolean[][] visited = new boolean[container.length][container[0].length];
                for (int j = 0; j < container.length; j++)
                    Arrays.fill(visited[j], false);
                dfs(container, c, 0, 0, visited);
            } else if (requests[i].length() == 2) {
                for (int j = 0; j < container.length; j++) {
                    for (int k = 0; k < container[0].length; k++) {
                        if(container[j][k] == c)
                            container[j][k] = '*';
                    }
                }
            }
            // for (int j = 0; j < container.length; j++) {
            //     for (int k = 0; k < container[0].length; k++) {
            //         System.out.print(container[j][k]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        
        for (int j = 0; j < container.length; j++) {
            for (int k = 0; k < container[0].length; k++) {
                if(container[j][k] != '*')
                    answer++;
            }
        }
        
        return answer;
    }
    
    // 이 dfs는 무조건 0,0부터 탐색시작
    private void dfs(char[][] container, char target, int x, int y, boolean[][] visited) {
        if(x < 0 || x > container.length-1 || y < 0 || y > container[0].length-1)
            return;
        
        if(container[x][y] != '*' && target != container[x][y])
            return;
        
        if(visited[x][y])
            return;
        else
            visited[x][y] = true;
        
        if(target == container[x][y]) {
            container[x][y] = '*';
            return;
        }
        
        dfs(container, target, x-1, y, visited);
        dfs(container, target, x+1, y, visited);
        dfs(container, target, x, y-1, visited);
        dfs(container, target, x, y+1, visited);
        
        return;
    }
}