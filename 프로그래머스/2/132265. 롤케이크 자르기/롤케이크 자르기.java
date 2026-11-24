import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        boolean[] arr = new boolean[10001];
        int[] num = new int[topping.length];
        num[0] = 1;
        arr[topping[0]] = true;
        
        for(int i = 1; i < topping.length; i++){
            if(!arr[topping[i]]) {
                num[i] = num[i-1] + 1;
                arr[topping[i]] = true;
            }else 
                num[i] = num[i-1];
        }
        
        boolean[] arr2 = new boolean[10001];
        int[] num2 = new int[topping.length];
        num2[topping.length-1] = 1;
        arr2[topping[topping.length-1]] = true;
        
        for(int i = topping.length-2; i >= 0; i--){
            if(!arr2[topping[i]]) {
                num2[i] = num2[i+1] + 1;
                arr2[topping[i]] = true;
            }else
                num2[i] = num2[i+1];
        }
        
        for(int i = 1; i < topping.length; i++){
            if(num[i-1] == num2[i])
                answer++;
        }
        
        return answer;
    }
}