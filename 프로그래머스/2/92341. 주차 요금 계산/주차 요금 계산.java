import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        String[] sortedNum = new String[records.length];
        for(int i = 0; i < records.length; i++) {
            sortedNum[i] = records[i].split(" ")[1];
        }
        Arrays.sort(sortedNum);
        
        int idx = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while(idx < records.length) {
            int totalMinutes = 0;
            int startCount = 0;
            int endCount = 0;
            for(int i = 0; i < records.length; i++) {
                if(records[i].split(" ")[1].equals(sortedNum[idx])) {
                    if(records[i].split(" ")[2].equals("IN")) {
                        startCount++;
                        totalMinutes -= nomarlize(records[i].split(" ")[0]);
                    }
                    if(records[i].split(" ")[2].equals("OUT")) {
                        endCount++;
                        totalMinutes += nomarlize(records[i].split(" ")[0]);
                    }
                }
            }
            System.out.println(startCount + " " + endCount);
            if(endCount < startCount) {
                totalMinutes += nomarlize("23:59");
                System.out.println("실행됨");
            }
            
            idx += (startCount + endCount);
            
            int fee = calculate(totalMinutes, fees);
            list.add(fee);
            
            System.out.println("총 시간 : " + totalMinutes + ", 요금 : " + fee);
        }
        
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private int calculate(int m, int[] fees) {
        if(fees[0] >= m)
            return fees[1];
        else {
            m -= fees[0];
            if(m % fees[2] != 0) {
                return fees[1] + (m / fees[2] + 1) * fees[3];
            }else {
                return fees[1] + (m / fees[2]) * fees[3];
            }
        }
    }
    
    private int nomarlize(String s) {
        String[] arr = s.split(":");
        
        return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
    }
}