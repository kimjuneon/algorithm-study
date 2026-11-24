import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int q = 0; q < commands.length; q++) {
            int i = commands[q][0], j = commands[q][1], k = commands[q][2];
        
            int[] arr = new int[j-i+1];
            for(int p = 0; p < arr.length; p++) {
                arr[p] = array[i+p-1];
            }

            Arrays.sort(arr);   
            
            answer[q] = arr[k-1];
        }
        
        return answer;
    }
}