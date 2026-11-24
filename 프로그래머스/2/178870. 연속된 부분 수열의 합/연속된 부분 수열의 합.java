class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = sequence.length-1;
        while (sequence[start] > k) 
            start--;
        int end = start;
        int count = sequence[start];
        
        while(true) {
            if(count == k){
                break;
            }
            if(count > k) 
                count -= sequence[start--];
            else if(count < k) 
                count += sequence[--end];
        }
        
        while(end > 0 && count + sequence[end-1] - sequence[start] == count) {
            end--;
            start--;
        }
        answer = new int[]{end, start};
        
        return answer;
    }
}