class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int[] arr = new int[n+1]; // 벽은 1부터
        for(int s : section){
            arr[s] = -1;
        }
        for(int i = 1; i < n+1; i++){
            if(arr[i] == -1){
                for(int j = 0; j < m; j++){
                    if(i+j > n)
                        break;
                    arr[i+j] = 0;
                }
                answer++;
            }
        }
        
        return answer;
    }
}