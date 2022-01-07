import java.util.Scanner; 
import java.awt.Font;

/**
 *  Purpose of program: Calculate the end time.
 *  and display the end time on a clock 
 *  given the start time and elapsed minutes from the user
 */
 
public class Proj1 { 

   public static void main(String[] args) { 
      
      Scanner keyboard = new Scanner(System.in);
      
      // prompting user to enter a start time and assigning input to variable
      System.out.println("Enter starting time in 24-hour format, " 
          + "e.g. 0:45 or 9:58 or 23:15");
      String startTime = keyboard.nextLine(); 
      
      // prompting user to enter a elapsed time and assigning input to variable
      System.out.println("Enter elapsed minutes as an integer, " 
          + "e.g. 15 or 149");
      int elapsedTime = keyboard.nextInt();
      
      // identifying and assigning hours and minutes of start time to variables
      int colonIndex = startTime.indexOf(":");
      //int lastIndex = startTime.length() - 1;
      String hours = startTime.substring(0, colonIndex);
      String minutes = startTime.substring(colonIndex + 1, startTime.length());
      
      // converting hours and minutes from start time into integers
      int hoursInt = Integer.parseInt(hours);
      int minutesInt = Integer.parseInt(minutes);
      
      // finding the hours and minutes of the elapsed time
      int elapsedHours = elapsedTime / 60;
      int elapsedMinutes = elapsedTime % 60;
   
      // calculating hours and minutes of the end time
      int tempEndHours = hoursInt + elapsedHours;
      int tempEndMinutes = minutesInt + elapsedMinutes;
      
      // ensuring end time minutes stays within legal range of time
      int endMinutesToHours = tempEndMinutes / 60;
      int endMinutes = tempEndMinutes % 60;
      
      // adding hours calculated from end minutes to hours of end time
      tempEndHours = tempEndHours + endMinutesToHours;
      
      // ensuring end time hours stays within legal range of time
      int endHours = tempEndHours % 24;  
      
      // initalizing and declaring variable for endTime
      String endTime = endHours + ":" + endMinutes;
      
      // printing the start time, elapsed minutes, and end time
      System.out.println("");
      System.out.println("Start time: " + startTime);
      System.out.println("Elapsed minutes = " + elapsedTime);
      System.out.printf("End time: %d:%02d", endHours, endMinutes);
       
      // creating canvas and circle and setting background color
      StdDraw.setScale(-256, 256);
      StdDraw.clear(StdDraw.CYAN);
      StdDraw.circle(0, 0, 225);
      
      // creating numbers on clock
      Font font = new Font("Arial", Font.BOLD, 32);
      StdDraw.setFont(font);
      StdDraw.text(0, 200, "12");
      StdDraw.text(200, 0, "3");
      StdDraw.text(0, -200, "6");
      StdDraw.text(-200, 0, "9");
      
      // calculating angle of hour hand and minute hand
      double hourAngle = 90 - (30 * endHours) - (0.5 * endMinutes);
      double minAngle = 90 - (6 * endMinutes);
      
      // converting the angles from degrees to radians
      double hourAngleRad = hourAngle * (Math.PI / 180); 
      double minAngleRad = minAngle * (Math.PI / 180);
      
      /* finding the x and y coordinates of the tip 
      of the hour hand, which will be represented by a triangle */
      double xHourTip = 105 * Math.cos(hourAngleRad);
      double yHourTip = 105 * Math.sin(hourAngleRad);
     
      /* finding the x and y coordinates of the tip
      of the minute hand, which will be represented by a triangle */
      double xMinsTip = 175 * Math.cos(minAngleRad);
      double yMinsTip = 175 * Math.sin(minAngleRad);
     
      // finding the x and y coordinates of the base of the minute hand triangle
      double xMinsBase1 = 10 * Math.cos(minAngleRad + (Math.PI / 2));
      double yMinsBase1 = 10 * Math.sin(minAngleRad + (Math.PI / 2));
      double xMinsBase2 = 10 * Math.cos(minAngleRad - (Math.PI / 2));
      double yMinsBase2 = 10 * Math.sin(minAngleRad - (Math.PI / 2)); 
   
      // finding the x and y coordinates of the base of the hour hand triangle
      double xHoursBase1 = 10 * Math.cos(hourAngleRad + (Math.PI / 2));
      double yHoursBase1 = 10 * Math.sin(hourAngleRad + (Math.PI / 2));
      double xHoursBase2 = 10 * Math.cos(hourAngleRad - (Math.PI / 2));
      double yHoursBase2 = 10 * Math.sin(hourAngleRad - (Math.PI / 2));
   
      // triangle representing the end time minute hand
      StdDraw.setPenRadius(0.012);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.triangle(xMinsBase1, yMinsBase1, xMinsBase2, 
         yMinsBase2, xMinsTip, yMinsTip);
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.filledTriangle(xMinsBase1, yMinsBase1, 
         xMinsBase2, yMinsBase2, xMinsTip, yMinsTip);
   
      // triangle representing the end time hour hand
      StdDraw.setPenRadius(0.012);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.triangle(xHoursBase1, yHoursBase1, xHoursBase2, 
         yHoursBase2, xHourTip, yHourTip);
      StdDraw.setPenColor(StdDraw.YELLOW);
      StdDraw.filledTriangle(xHoursBase1, yHoursBase1, xHoursBase2, 
         yHoursBase2, xHourTip, yHourTip);
   
      // circle at center of clock
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.filledCircle(0, 0, 12);
      
   }
   
}
