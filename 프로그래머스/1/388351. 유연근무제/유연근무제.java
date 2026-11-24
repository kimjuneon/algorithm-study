class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int  i = 0; i < schedules.length; i++){
            
            boolean ok = true;
            for(int j = 0; j < timelogs[i].length; j++){
                
                int day = (startday+j-1)%7+1;
                if(day == 6 || day == 7){
                    continue;
                }
                
                int limit = schedules[i] + 10;
                if(limit % 100 >= 60){
                    limit = ((limit + 100)/100)*100 + (limit%100 - 60);
                }
                
                if(limit < timelogs[i][j])
                    ok = false;
            }
            
            if(ok)
                answer++;
        }
        
        return answer;
    }
}