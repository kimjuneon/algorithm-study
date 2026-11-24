import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        String tmp = "";
        for(int i = 0 ; i < callings.length; i++){
            int num = map.get(callings[i]);
            map.remove(players[num]);
            map.remove(players[num-1]);
            tmp = players[num];
            players[num] = players[num-1];
            players[num-1] = tmp;
            map.put(players[num-1], num-1);
            map.put(players[num], num);
        }
        
        return players;
    }
}