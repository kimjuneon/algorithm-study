import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        String[] arrX = X.split("");
        String[] arrY = Y.split("");
        
        Arrays.sort(arrX);
        Arrays.sort(arrY);
        
        int idxX = arrX.length-1;
        int idxY = arrY.length-1;
        while(idxX >= 0 && idxY >= 0) {
            if(arrX[idxX].equals(arrY[idxY])) {
                answer.append(arrX[idxX]);
                idxX--;
                idxY--;
            }else if(arrX[idxX].charAt(0) > arrY[idxY].charAt(0)) {
                idxX--;
            }else if(arrX[idxX].charAt(0) < arrY[idxY].charAt(0)) {
                idxY--;
            }
        }
        
        if(answer.length() == 0) 
            return "-1";
        if(answer.charAt(0) == '0')
            return "0";
        
        return answer.toString();
    }
}