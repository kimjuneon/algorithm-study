import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        String[] sArr = s.split("");
        for(int i = 0; i < sArr.length; i++){
            if(skip.contains(sArr[i]))
                continue;
            
            char newChar = 'a';
            
            int count = 0;
            int tmp = 1;
            while(count < index){
                if(skip.contains(String.valueOf(convert(sArr[i],tmp)))){
                    tmp++;
                    continue;
                }else{
                    newChar = convert(sArr[i],tmp);
                    count++;
                    tmp++;
                }
            }
            
            sArr[i] = String.valueOf(newChar);
        }
        
        for(String st : sArr){
            sb.append(st);
        }
        
        return sb.toString();
    }
    
    private char convert(String c, int index){
        char newChar;
        if(c.charAt(0) + index > 'z')
            newChar = (char)('a' + (c.charAt(0) - 'a' + index) % 26);
        else
            newChar = (char)(c.charAt(0) + index);
        
        return newChar;
    }
}