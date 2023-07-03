package Java_Programmers.Level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class 주차요금계산 {

    //차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로
    public static int[] solution(int[] fees, String[] records) {

        List<String> plate = new ArrayList<>(); //오름차순 위한 차량번호 저장
        Map<String, Date> inTime = new HashMap<>(); //차량번호 + 입차시간
        Map<String, Long> calTime = new HashMap<>(); //차량번호 + 주차시간

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        for(String s : records){
            Date time = null;
            try {
                time = simpleDateFormat.parse(s.split(" ")[0]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String number = s.split(" ")[1];
            String inout = s.split(" ")[2];

            if(!plate.contains(number))
                plate.add(number);

            if(inout.equals("IN")) {
                inTime.put(number, time);
            } else {

                long diff = (time.getTime() - inTime.get(number).getTime())/(1000*60); //분으로 변환

                if(calTime.containsKey(number))
                    calTime.put(number, calTime.get(number) + diff);
                else
                    calTime.put(number, diff);

                inTime.remove(number);
            }

        }

        if(!inTime.isEmpty()) {
            Set<String> strings = inTime.keySet();
            Date time = null;
            try {
                time = simpleDateFormat.parse("23:59");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            for(String number : strings){
                long diff = (time.getTime() - inTime.get(number).getTime())/(1000*60); //분으로 변환

                if(calTime.containsKey(number))
                    calTime.put(number, calTime.get(number) + diff);
                else
                    calTime.put(number, diff);
            }
        }

        System.out.println(calTime);

        int [] answer = new int [plate.size()];
        Collections.sort(plate);

        for(int i=0; i< plate.size(); i++) {
            long minutes = calTime.get(plate.get(i));
            if(minutes<=fees[0])
                answer[i] = fees[1];
            else {
                int partTime = (int) Math.ceil((double) (minutes - fees[0]) / fees[2]);
                System.out.println("partTime = " + partTime);
                answer[i] = fees[1] + partTime*fees[3];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int [] fees1 = {180, 5000, 10, 600};
        String [] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees1, records1)));
        //14600, 34400, 5000

        int [] fees2 = {120, 0, 60, 591};
        String [] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        System.out.println(Arrays.toString(solution(fees2, records2)));
        //0, 591

        int [] fees3 = {1, 461, 1, 10};
        String [] records3 = {"00:00 1234 IN"};
        System.out.println(Arrays.toString(solution(fees3, records3)));
        //14841



    }
}
