import java.util.Scanner;
class InvalidTimeException extends Exception{
    public InvalidTimeException(String message){
        super(message);
    }
}
public class Main {
    static int secondsConversion(int time){
        return time*60;
    }
    static int calculateSeconds(String h1, String h2) {
        int time, time2;
        int hour, minute, second;
        String[] s1 = h1.split(":", 3);
        hour = Integer.parseInt(s1[0]);
        minute = Integer.parseInt(s1[1]);
        second = Integer.parseInt(s1[2]);

        int hour2, minute2, second2;
        String[] s2 = h2.split(":", 3);
        hour2 = Integer.parseInt(s2[0]);
        minute2 = Integer.parseInt(s2[1]);
        second2 = Integer.parseInt(s2[2]);

        time = secondsConversion(hour * 60) + secondsConversion(minute) + second;
        time2 = secondsConversion(hour2 * 60) + secondsConversion(minute2) + second2;

        return time2 - time;
    }


    public static void main(String[] args){

        Scanner entry = new Scanner(System.in);
            String s1, s2;
            try {
                System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
                s1 = entry.nextLine();
                String[] a1 = s1.split(":", 3);
                if (Integer.parseInt(a1[0]) > 24){
                    throw new InvalidTimeException("Hours must be below 24");
                } else if(Integer.parseInt(a1[0]) < 0){
                    throw new InvalidTimeException("Hours cannot be below 0");
                }
                if (Integer.parseInt(a1[1]) >= 60){
                    throw new InvalidTimeException("Minutes must be below 60");
                } else if(Integer.parseInt(a1[1]) < 0){
                    throw new InvalidTimeException("Minutes cannot be below 0");
                }
                if (Integer.parseInt(a1[2]) >= 60){
                    throw new InvalidTimeException("Seconds must be below 60");
                } else if(Integer.parseInt(a1[2]) < 0){
                    throw new InvalidTimeException("Seconds cannot be below 0");
                }

                System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
                s2 = entry.nextLine();
                String[] a2 = s1.split(":", 3);
                if (Integer.parseInt(a2[0]) > 24){
                    throw new InvalidTimeException("Hours must be below 24");
                } else if(Integer.parseInt(a2[0]) < 0){
                    throw new InvalidTimeException("Hours cannot be below 0");
                }
                if (Integer.parseInt(a2[1]) >= 60){
                    throw new InvalidTimeException("Minutes must be below 60");
                } else if(Integer.parseInt(a2[1]) < 0){
                    throw new InvalidTimeException("Minutes cannot be below 0");
                }
                if (Integer.parseInt(a2[2]) >= 60){
                    throw new InvalidTimeException("Seconds must be below 60");
                } else if(Integer.parseInt(a2[2]) < 0){
                    throw new InvalidTimeException("Seconds cannot be below 0");
                }
                System.out.println("Difference in seconds: " + calculateSeconds(s1, s2));
            }catch (InvalidTimeException ite) {
                System.out.println(ite.getMessage());
            }catch (IndexOutOfBoundsException iobe) {
                System.out.println("Enter a valid time");
            }catch(NumberFormatException nfe){
                System.out.println("Entered field cannot be empty");
            } catch(Exception e) {
                System.out.println("This is whats wrong" + e);
            }


    }
}