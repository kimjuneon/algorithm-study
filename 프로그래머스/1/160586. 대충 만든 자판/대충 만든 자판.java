import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int max = -1;
        for(String key : keymap){
            if(key.length() > max)
                max = key.length();
        }
        
        for(int j = 0; j < targets.length; j++){
            String[] target = targets[j].split("");
            
            for(String currentTarget : target){
                boolean success = false;
                for(int i = 0; i < max; i++){
                    for(String key : keymap){
                        if(key.length() <= i)
                            continue;
                        if(key.charAt(i) == currentTarget.charAt(0)){
                            answer[j] += i+1;
                            success = true;
                            break;
                        }
                    }
                    if(success)
                        break;
                }
                if(!success){
                    answer[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}