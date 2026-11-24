class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int[] scores = new int[friends.length];
        
        for(int i = 0; i < friends.length; i++){
            for (int j = i+1; j < friends.length; j++){
                int tmp = check(i,j,friends,gifts);
                if(tmp != -1)
                    scores[tmp]++;
            }
        }
        
        for(int i = 1; i < friends.length; i++){
            if(scores[answer] < scores[i])
                answer = i;
        }
        
        return scores[answer];
    }
    
    private int check(int n1, int n2, String[] friends, String[] gifts){
        int score1 = 0, score2 = 0;
        int sec1 = 0, sec2 = 0;
        
        for(int i = 0; i < gifts.length; i++){
            String[] tmp = gifts[i].split(" ");
            if(tmp[0].equals(friends[n1]) && tmp[1].equals(friends[n2]))
                score1++;
            else if(tmp[1].equals(friends[n1]) && tmp[0].equals(friends[n2]))
                score2++;
            
            if(tmp[0].equals(friends[n1]))
                sec1++;
            else if(tmp[0].equals(friends[n2]))
                sec2++;
            
            if(tmp[1].equals(friends[n1]))
                sec1--;
            else if(tmp[1].equals(friends[n2]))
                sec2--;
        }
        
        if(score1 > score2)
            return n1;
        else if(score2 > score1)
            return n2;
        if(sec1 > sec2)
            return n1;
        else if(sec1 < sec2)
            return n2;
        else
            return -1;
        
    }
}