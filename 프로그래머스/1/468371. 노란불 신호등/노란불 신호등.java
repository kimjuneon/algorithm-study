class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        int max = 1;
        for(int i = 0; i < signals.length; i++){
            int tmp = signals[i][0] + signals[i][1] + signals[i][2];
            max *= tmp;
            if(max < 0)
                max = Integer.MAX_VALUE;
        }
        
        System.out.println(max);
        
        while(true) {
            boolean black = true;
            for(int i = 0; i < signals.length; i++){
                for(int j = 0; j < 3; j++) {
                    int cycle = signals[i][0] + signals[i][1] + signals[i][2];
                    int current = answer % cycle;
                    if(!(current > signals[i][0] && current <= signals[i][0] + signals[i][1]))
                        black = false;
                }
            }
            if(black)
                break;
            if(answer >= max)
                return -1;
            answer++;
        }
        
        return answer;
    }
}