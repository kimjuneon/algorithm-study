import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 서버 종료 시간 list
        List<Integer> lists = new ArrayList<>();
        
        for(int i = 0; i < players.length; i++){
            int servers = 1;
            for(int list : lists){
                if(list > i){
                    servers++;
                }
            }
            if(players[i]/m >= servers){
                int num = players[i]/m - servers + 1;
                for(int j = 0; j < num; j++){
                    lists.add(i+k);
                    answer++;
                    servers++;
                }
            }
            System.out.println("현재 이용자 : " + players[i] + ", 현재 서버 수 : "+servers+", 증설 횟수 : " + answer);
        }
        
        return answer;
    }
}