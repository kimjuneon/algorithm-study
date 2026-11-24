import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int same = 1;
        int different = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == x) {
                same++;
            } else {
                different++;  
            }
            
            // if(same == different) {
            //     System.out.print(" ");
            // }
            // System.out.print(s.charAt(i));
            
            if(same == different) {
                answer++;
                if(i+1 >= s.length())
                    break;
                x = s.charAt(i+1);
                same = 1;
                different = 0;
                i++;
            }
        }
        if(same != different)
            answer++;
        
        return answer;
    }
}