import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.util.Scanner;

public class Alarm  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
        String s = scanner.nextLine();

        if (Integer.parseInt(s.substring(0,2))>23 ||Integer.parseInt(s.substring(3,4))>59)
            throw new WrongNumberArgsException("It's wrong time");
            System.out.println(convert(s));
        }
        catch (WrongNumberArgsException e){e.printStackTrace();
        }
    }

    public static String convert(String time) {

        int hour,minute;
        String amPM ="";

        String[] timeAloud = time.split(":");

        hour = Integer.parseInt(timeAloud[0]);
        minute=Integer.parseInt(timeAloud[1]);

        if (hour>12) amPM= " PM";
        else amPM = " AM";


        hour = hour>12?hour-12:hour;

       return voice(hour,minute,amPM);
        }

        public static String voice (int h,int m,String amPM){
        String F ="It's ";
        switch (h){
            case(0) : F+= "oh and ";break;
            case(1) : F+= "one ";break;
            case(2) : F+= "two ";break;
            case(3) : F+= "three ";break;
            case(4) : F+= "four ";break;
            case(5) : F+= "five ";break;
            case(6) : F+= "six ";break;
            case(7) : F+= "seven ";break;
            case(8) : F+= "eight ";break;
            case(9) : F+= "nine ";break;
            case(10) : F+= "ten ";break;
            case(11) :F+= "eleven ";break;
            default: F+="twelve ";
        }
            switch (m/10){
                case(0) : F+= "";break;
                case(1) : switch (m){
                    case (10) : F+= "ten";break;
                    case (11) : F+= "eleven";break;
                    case (12) : F+= "twelve";break;
                    case (13) : F+= "thirteen";break;
                    case (14) : F+= "fourteen";break;
                    case (15) : F+= "fifteen";break;
                    case (16) : F+= "sixteen";break;
                    case (17) : F+= "seventeen";break;
                    case (18) : F+= "eighteen";break;
                    case (19) : F+= "nineteen";break;

                }break;
                case(2) : F+= "twenty";break;
                case(3) : F+= "thirty";break;
                case(4) : F+= "forty";break;
                case(5) : F+= "fifty";break;

            }
            if (m/10!=1) {
                switch (m % 10 ) {
                    case (1):
                        F += "one";break;
                    case (2):
                        F += "two";break;
                    case (3):
                        F += "three";break;
                    case (4):
                        F += "four";break;
                    case (5):
                        F += "five";break;
                    case (6):
                        F += "six";break;
                    case (7):
                        F += "seven";break;
                    case (8):
                        F += "eight";break;
                    case (9):
                        F += "nine";break;
                }
            }
        return  F+amPM;
        }
}
