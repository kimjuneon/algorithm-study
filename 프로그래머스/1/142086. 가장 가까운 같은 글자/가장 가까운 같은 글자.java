class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            boolean found = false;
            for (int j = i-1; j >= 0; j--) {
                count++;
                if(c == s.charAt(j)) {
                    answer[i] = count;
                    found = true;
                    break;
                }
            }
            if(!found)
                answer[i] = -1;
        }
        
        return answer;
    }
}