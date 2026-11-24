import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        int[] answer = new int[sources.length];
        Arrays.fill(answer, -1);
        
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int a = road[0], b = road[1];
            list[a].add(b);
            list[b].add(a);
        }
        
        int[] answers = new int[100001];
        Arrays.fill(answers, -1);
        
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        
        queue.add(destination);
        visited[destination] = true;
        while(queue.size() > 0){
            int size = queue.size();
            for(int j = 0; j < size; j++){
                int tmp = queue.poll();
                answers[tmp] = count;
                for(int k = 0; k < list[tmp].size(); k++){
                    if(!visited[list[tmp].get(k)]){
                        queue.add(list[tmp].get(k));
                        visited[list[tmp].get(k)] = true;
                    }
                }
            }
            count++;
        }
        
        for(int i = 0; i < answer.length; i++){
            if(answers[sources[i]] != -1)
                answer[i] = answers[sources[i]];
        }
        
        
        
        return answer;
    }
}