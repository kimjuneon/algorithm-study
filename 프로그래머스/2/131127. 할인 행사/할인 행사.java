import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
         for(int i = 0; i < discount.length-9; i++){ // discount 배열 순회
             boolean ok = true;
             int[] currentNum = number.clone();
             for(int j = 0; j < 10; j++){ // 지금부터 10개까지 비교
                 int num = -1;
                 for(int k = 0; k < want.length; k++){ // want에 있는 물건인지
                     if(discount[i+j].equals(want[k])){
                         num = k;
                         break;
                     }
                 }
                 if(num == -1){ // want에 있는 물건이 아님
                     ok = false;
                     break;
                 }
                 if(currentNum[num] > 0)
                     currentNum[num]--;
                 else{ // 내가 원하는 물건 양보다 많음
                     ok = false;
                     break;
                 }
             }
             if(ok){
                 answer++;
             }
         }
        
        return answer;
    }
}