import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        long[] arr = new long[1001];
        for(int i : weights) {
            arr[i]++;
        }
        for (int i = 100; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(i == j && arr[i] != 0 && arr[i] != 1) {
                    answer += (arr[i]-1) * arr[j] / 2;
                    // System.out.println("i,j = " + i + ", " + j + ", answer:" + answer);
                }
                if((3*i == 2*j || 4*i == 2*j || 4*i == 3*j) && arr[i] != 0 && arr[j] != 0) {
                    answer += arr[i] * arr[j];
                    // System.out.println("i,j = " + i + ", " + j+ ", answer:" + answer);
                }
            }
        }
        
        return answer;
    }
}