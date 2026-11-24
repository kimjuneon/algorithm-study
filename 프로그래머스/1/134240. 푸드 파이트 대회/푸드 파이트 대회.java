import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        int[] personFood = new int[food.length];
        for(int i = 1; i < food.length; i++){
            personFood[i] = food[i]/2;
        }
        
        for(int i = 1; i < personFood.length; i++){
            for(int k = 0; k < personFood[i]; k++){
                sb.append(i);
            }
        }
        sb.append(0);
        for(int i = personFood.length-1; i > 0; i--){
            for(int k = 0; k < personFood[i]; k++){
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}