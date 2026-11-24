import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = 100000000;
        // 1. 각각의 거리에 대해 자기 자신의 비용은 0으로, 나머지는 무한대로 초기화
        // 2. 간선에 대해 업데이트 진행
        // 3. 각 지점에서 다른 모든 지점까지의 경유를 반영하여 최소값 업데이트 진행
        // 4. 모든 지점을 경유 지점으로 두고(시작 부분 포함) 최솟값 찾기
        int[][] dis = new int [n+1][n+1];
        int num = dis.length; // 총 지점 갯수+1
        
        for(int i = 1; i < num; i++){
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        } // 1
        
        for(int[] fare : fares){
            int c = fare[0], d = fare[1], f = fare[2];
            dis[c][d] = f;
            dis[d][c] = f;
        } // 2
        
        for(int k = 1; k < num; k++){// 경유 지점
            for(int i = 1; i < num; i++){
                for(int j = 1; j < num; j++){
                    int tmp = dis[i][k] + dis[k][j];
                    dis[i][j] = Math.min(dis[i][j], tmp);
                }
            }
        } // 3
        
        int ans = INF;
        for(int k = 1; k < num; k++){
            ans = Math.min(ans, dis[s][k] + dis[k][a] + dis[k][b]);
        }
        

        return ans;
    }
}
