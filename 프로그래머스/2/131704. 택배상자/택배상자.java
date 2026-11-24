import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;
        for(int i = 1; i <= order.length; i++) {
            if(order[idx] == i) {
                idx++;
                answer++;
            } else if (deque.size() > 0 && deque.peekFirst() == order[idx]){
                i--;
                deque.pollFirst();
                idx++;
                answer++;
            } else {
                deque.addFirst(i);
            }
        }
        
        while(idx < order.length && deque.size() > 0 && order[idx] == deque.peekFirst()) {
            idx++;
            deque.pollFirst();
            answer++;
        }
        
        return answer;
    }
}