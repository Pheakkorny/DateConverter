/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fulldateconverter;

/**
 *
 * @author Pheakkorny
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FullDateConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Ask the user to enter a short date
            System.out.print("Enter a short date (YYYY-MM-DD) or 'exit' to end: ");
            String shortDate = scanner.nextLine();

            // Check if the user wants to exit
            if (shortDate.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Parse the short date string
                SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = shortDateFormat.parse(shortDate);

                // Extract year, month, and day from the parsed date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                // Convert month number to month name
                String monthName = convertToMonthName(month);

                // Get the day of the week
                String dayOfWeek = getDayOfWeek(calendar);

                // Display the full date representation
                System.out.println(dayOfWeek + ", " + monthName + " " + day + ", " + year);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a valid short date (YYYY-MM-DD).");
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Method to convert month number to month name
    private static String convertToMonthName(int month) {
        String[] monthNames = {
                "", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        if (month >= 1 && month <= 12) {
            return monthNames[month];
        } else {
            return "Invalid Month";
        }
    }

    // Method to get the day of the week
    private static String getDayOfWeek(Calendar calendar) {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int dayOfWeekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1; // Adjust index

        if (dayOfWeekIndex >= 0 && dayOfWeekIndex < daysOfWeek.length) {
            return daysOfWeek[dayOfWeekIndex];
        } else {
            return "Invalid Day";
        }
    }
}
