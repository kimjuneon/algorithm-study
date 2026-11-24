import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idx = new HashMap<>();
        for(int i = 0; i < id_list.length; i++)
            idx.put(id_list[i], i);
        
        Arrays.sort(report);
        int[] id_num = new int[id_list.length];
        
        String tmp = "";
        for(int i = 0; i < report.length; i++){
            if(tmp.equals(report[i]))
                continue;
            else
                tmp = report[i];
            
            String[] arr = report[i].split(" ");
        
            int index = idx.get(arr[1]);
            id_num[index]++;
        }
        
        tmp = "";
        for(int i = 0; i < report.length; i++){
            String[] arr = report[i].split(" ");
            if(tmp.equals(report[i]))
                continue;
            else
                tmp = report[i];
            
            int sender = idx.get(arr[0]);
            int receiver = idx.get(arr[1]);
            
            if(id_num[receiver] >= k)
                answer[sender]++;
        }
        
        return answer;
    }
}