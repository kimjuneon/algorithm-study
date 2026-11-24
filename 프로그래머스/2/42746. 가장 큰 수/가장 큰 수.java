import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] numString = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            numString[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(numString, (a, b) -> (b+a).compareTo(a+b));
        
        if(numString[0].equals("0"))
            return "0";
        
        for(int i = 0; i < numString.length; i++){
            answer += numString[i];
        }
        
        return answer;
    }
}