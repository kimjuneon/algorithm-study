class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(0, 0, target, numbers);
    }
    
    private int dfs(int num, int count, int target, int[] numbers){
        if(count == numbers.length && num == target){
            return 1;
        }else if(count == numbers.length)
            return 0;
        
        return dfs(num+numbers[count], count+1, target, numbers) +
        dfs(num-numbers[count], count+1, target, numbers);
    }
}