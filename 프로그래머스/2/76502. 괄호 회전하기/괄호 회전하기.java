import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            deque.addLast(s.charAt(i));
        }
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for(char c : deque) {
                sb.append(c);
            }
            boolean collect = isCollect(sb.toString());
            // System.out.println(sb.toString() + " : " + collect);
            if(collect) {
                answer++;
            } 
            char tmp = deque.pollFirst();
            deque.addLast(tmp);
        }
        
        return answer;
    }
    
    private boolean isCollect(String s) {
        int idx = 0;
        char[] arr = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                arr[idx++] = s.charAt(i);
            } else {
                if(idx < 1)
                    return false;
                if((s.charAt(i) == '}' && arr[idx-1] == '{') || 
                  (s.charAt(i) == ']' && arr[idx-1] == '[') ||
                  (s.charAt(i) == ')' && arr[idx-1] == '('))
                    idx--;
                else
                    return false;
            }
            // for(int j = 0; j < idx+1; j++)
            //     System.out.print(arr[j]);
            // System.out.println(", idx : " + idx);
        }
        return idx == 0;
    }
}