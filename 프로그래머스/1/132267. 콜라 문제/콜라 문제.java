class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            int tmp = 0;
            tmp = b*(n/a);
            n = n%a;
            n += tmp;
            answer += tmp;
        }
        
        return answer;
    }
}