class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 0; i < n; i++){
            if(n % answer == 1)
                break;
            answer++;
        }
        
        return answer;
    }
}