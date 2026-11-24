import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        final int INF = 1000000000;

        int[][] dis = new int[N+1][N+1];
        for(int i = 1; i < dis.length; i++){
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }
        
        for(int[] r : road){
            int a = r[0], b = r[1], c = r[2];
            if(dis[a][b] < c)
                continue;
            dis[a][b] = c;
            dis[b][a] = c;
        }
        
        for(int k = 1; k < dis.length; k++){
            for(int i = 1; i < dis.length; i++){
                for(int j = 1; j < dis.length; j++){
                    int tmp = dis[i][k] + dis[k][j];
                    dis[i][j] = Math.min(dis[i][j], tmp);
                }
            }
        }
        
        for(int i = 1; i < dis.length; i++){
            System.out.println(i+"번째 : " + dis[1][i]);
            if(dis[1][i] <= K){
                System.out.println(i);
                answer++;
            }
        }

        return answer;
    }
}