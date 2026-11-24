class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int length = p.length();
        int total = t.length() - length + 1;
        
        for(int i = 0; i < total; i++){
            String sub = t.substring(i,i+length);
            if(sub.compareTo(p) <= 0)
                answer++;
        }
        
        return answer;
    }
}