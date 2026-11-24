import java.util.*;

class Solution {
    static final int MAX = 102; // (1~50)*2 => 2~100, 여유

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[MAX][MAX]; // 0: 빈칸, 1: 테두리(이동가능), 2: 내부(막힘)

        // 1) 사각형 칠하기 (2배 스케일)
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            // 전체 영역을 우선 테두리 후보로 표시
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (board[x][y] != 2) board[x][y] = 1;
                }
            }

            // 내부는 막기(겹쳐도 내부가 우선)
            for (int x = x1 + 1; x <= x2 - 1; x++) {
                for (int y = y1 + 1; y <= y2 - 1; y++) {
                    board[x][y] = 2;
                }
            }
        }

        // 2) BFS (테두리만 이동)
        int sx = characterX * 2, sy = characterY * 2;
        int tx = itemX * 2, ty = itemY * 2;

        int[][] dist = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) Arrays.fill(dist[i], -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[sx][sy] = 0;
        q.add(new int[]{sx, sy});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == tx && y == ty) break;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
                if (board[nx][ny] != 1) continue;     // 테두리만
                if (dist[nx][ny] != -1) continue;     // 방문

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        // 2배 좌표에서의 거리이므로 2로 나눔
        return dist[tx][ty] / 2;
    }
}
