public class Time_conv {

    public static boolean leap_year(int year){

        if(year%4!=0){
            return false;
        }
        else{
            if(year%100!=0){
                return true;
            }
            else{
                if(year%400!=0){
                    return false;
                }
                else{
                    return true;
                }
            }
        }

    }

    public static void main(String[] args) {
        int year = 2024;
        int month = 2;
        int day = 29;
        int hour = 20;
        int minutes = 34;
        int seconds = 23;

        System.out.println("year : "+year+" month : "+month+" day : "+day+" hour : "+hour+" minutes : "+minutes+" Seconds : "+seconds);

        hour+=5;
        minutes+=30;


        if(hour>=24){
            day = day+1;
            hour = hour-24;
        }
        if(minutes>=60){
            hour = hour +1;
            minutes=minutes-60;
        }

        switch(month){
            case 1,3,5,7,8,10,12 :
                if(day>31){
                    month++;
                    day-=31;
                }
                break;
            case 2 : 
                if(leap_year(year)==true){
                    if(day>29){
                        month++;
                        day-=29;
                    }
                }
                else{
                    if(day>28){
                        month++;
                        day-=28;
                    }
                }
                break;
            case 4,6,9,11  :
                if(day>30){
                    month++;
                    day-=30;
                }
        }

        if(month>12){
            year++;
            month-=12;
        }

        System.out.println("year : "+year+" month : "+month+" day : "+day+" hour : "+hour+" minutes : "+minutes+" Seconds : "+seconds);
    
    
    }
    
}
