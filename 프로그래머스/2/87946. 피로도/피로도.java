class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        int max = 0;
        for(int i = 0; i < dungeons.length; i++){
            int tmp = dfs(0, i, visited.clone(), k, dungeons);
            System.out.println("시작 부분 : " + i + ", 총 탐험 수 : " + tmp);
            if(max < tmp)
                max = tmp;
        }
        
        return max;
    }
    
    private int dfs(int count, int current, boolean[] visited, int k, int[][] dungeons){
        if(visited[current])
            return count;
        else
            visited[current] = true;
        
        if(dungeons[current][0] <= k)
            k -= dungeons[current][1];
        else
            return count;
        
        int max = 0;
        for(int i = 0; i < dungeons.length; i++){
            if(i == current)
                continue;
            int tmp = dfs(count+1, i, visited.clone(), k, dungeons);
            if(max < tmp)
                max = tmp;
        }
        
        return max;
    }
}