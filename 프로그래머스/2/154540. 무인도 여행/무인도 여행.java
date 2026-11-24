import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        LinkedList<Integer> answerList = new LinkedList<>();
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if(!visited[i][j] && maps[i].charAt(j) != 'X') {
                    int count = 0;
                    queue.add(i);
                    queue.add(j);
                    while (queue.size() > 0) {
                        int x = queue.poll(), y = queue.poll();
                        if(x < 0 || x >= maps.length || y < 0 || y >= maps[0].length())
                            continue;
                        if(visited[x][y])
                            continue;
                        else
                            visited[x][y] = true;
                        if(maps[x].charAt(y) == 'X')
                            continue;
                        
                        count += maps[x].charAt(y) - '0';
                        queue.add(x+1);
                        queue.add(y);
                        queue.add(x-1);
                        queue.add(y);
                        queue.add(x);
                        queue.add(y+1);
                        queue.add(x);
                        queue.add(y-1);
                    }
                    answerList.add(count);
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        if(answer.length == 0)
            return new int[]{-1};
        for(int i = 0; i < answer.length; i++)
            answer[i] = answerList.poll();
        Arrays.sort(answer);
        return answer;
    }
}