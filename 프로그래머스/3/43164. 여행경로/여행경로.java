import java.util.*;

class Solution {
    private boolean done;
    boolean[] used;
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        done = false;
        used = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        answer[0] = "ICN";
        dfs(tickets, "ICN", 0, answer);
        
        return answer;
    }
    
    private void dfs(String[][] tickets, String cur, int count, String[] answer){
        if(done)
            return;
        if(count == tickets.length){
            done = true;
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!used[i] && tickets[i][0].equals(cur)){
                used[i] = true;
                answer[count+1] = tickets[i][1];
                dfs(tickets, tickets[i][1], count+1, answer);
                if(done)
                    return;
                used[i] = false;
            }
        }
        return;
    }
}