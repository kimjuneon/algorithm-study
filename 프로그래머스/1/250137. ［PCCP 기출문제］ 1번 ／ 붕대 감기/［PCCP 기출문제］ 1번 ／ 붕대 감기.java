class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int time = bandage[0];
        int healSec = bandage[1];
        int healAdd = bandage[2];
        int total_game_time = attacks[attacks.length-1][0]+1;
        int current = 0;
        int attackTime = 0;
        
        //최대 체력 반영하기, 죽으면 -1 반환, 공격 받으면 회복 안하기
        
        for(int i = 0; i < total_game_time; i++){ // 총 게임 시간
            
            if(i == attacks[attackTime][0]){// 몬스터한테 공격 받기
                answer -= attacks[attackTime][1];
                attackTime++;
                current = 0;
                if(answer <= 0)
                    return -1;
                continue;
            }
            
            answer += healSec;
            current++;
            if(current == time){
                answer += healAdd;
                current = 0;
            }
            if(answer > health)
                answer = health;
            
        }
        
        return answer;
    }
}