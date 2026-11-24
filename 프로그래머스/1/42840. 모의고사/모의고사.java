import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer1 = new ArrayList<>();    
        int[] p1 = new int[answers.length];
        int[] p2 = new int[answers.length];
        int[] p3 = new int[answers.length];
        int a1 = 0, a2 = 0, a3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            p1[i] = (i)%5+1;
            
            if(i%2 == 0) {
                p2[i] = 2;
            } else {
                if(i%8 == 1)
                    p2[i] = 1;
                if(i%8 == 3)
                    p2[i] = 3;
                if(i%8 == 5)
                    p2[i] = 4;
                if(i%8 == 7)
                    p2[i] = 5;
            }
            
            if((i%10)/2 == 0)
                p3[i] = 3;
            if((i%10)/2 == 1)
                p3[i] = 1;
            if((i%10)/2 == 2)
                p3[i] = 2;
            if((i%10)/2 == 3)
                p3[i] = 4;
            if((i%10)/2 == 4)
                p3[i] = 5;
            
            if(p1[i] == answers[i])
                a1++;
            if(p2[i] == answers[i])
                a2++;
            if(p3[i] == answers[i])
                a3++;
        }
        
        int max = 0;
        if(a1 > a2)
            max = a1;
        else
            max = a2;
        if(max < a3)
            max = a3;
        
        if(a1 == max)
            answer1.add(1);
        if(a2 == max)
            answer1.add(2);
        if(a3 == max)
            answer1.add(3);
        
        int[] answer = new int[answer1.size()];

        for (int i = 0; i < answer1.size(); i++) {
            answer[i] = answer1.get(i);
        }

        return answer;
    }
}