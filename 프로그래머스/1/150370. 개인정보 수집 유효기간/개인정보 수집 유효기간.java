import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        int endDate = toDate(today);
        String[] tmp;
        
        for(int i = 0; i < privacies.length; i++){
            tmp = privacies[i].split(" ");
            String dateTmp = tmp[0];
            String term = tmp[1];
            
            int addDate = 0;
            for(String str : terms){
                tmp = str.split(" ");
                if(tmp[0].equals(term)){
                    addDate = Integer.parseInt(tmp[1]) * 28;
                    break;
                }
            }
            int date = toDate(dateTmp) + addDate - 1;
            
            if(date < endDate){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private int toDate(String str){
        String[] tmp = str.split("\\.");
        int date = Integer.parseInt(tmp[2]);
        int month = Integer.parseInt(tmp[1]);
        int year = Integer.parseInt(tmp[0]);
        return date + month*28 + year*12*28;
    }
}