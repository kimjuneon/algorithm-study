import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        char[] c = new char[new_id.length()];
        for(int i = 0; i < new_id.length(); i++) {
            c[i] = new_id.charAt(i);
        }
        
        for(int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                c[i] = (char)(c[i] + ('a' - 'A'));
            } 
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c.length; i++) {
            char c1 = c[i];
            if(!(c1 >= 'a' && c1 <= 'z') && c1 != '-' && c1 != '_' && c1 != '.'
                && !(c1 >= '0' && c1 <= '9')) {
                continue;
            }
            if(sb.length() > 0 && c1 == '.' && sb.charAt(sb.length()-1) == '.')
                continue;
            if((sb.length() == 0 || i == c.length-1) && c1 == '.')
                continue;
            sb.append(c1);
        }
        
        Deque<Character> deque = new ArrayDeque<>();
        System.out.println(sb);
        if(sb.length() == 0) {
            deque.add('a');
            System.out.println("실행됨");
        }
        else {
            for(int i = 0; i < sb.toString().length(); i++) {
                if(i > 14) //?
                    break;
                deque.add(sb.charAt(i));
            }
            if(deque.peekLast() == '.')
                deque.pollLast();
        }
        while(deque.size() > 0 && deque.size() <= 2) {
            deque.addLast(deque.peekLast());
        }
        StringBuilder new_sb = new StringBuilder();
        for(char c3 : deque)
            new_sb.append(c3);
        
        return new_sb.toString();
    }
}