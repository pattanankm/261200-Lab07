// StudentGrades.java
// Student grade calculation program

public class StudentGrades {

    // Method to calculate average of scores
    public static double calculateAverage(int[] scores) {
        // Check if array is null
        if (scores == null) {
            throw new IllegalArgumentException("Scores array cannot be null.");
        }

        // Check if array is empty
        if (scores.length == 0) {
            throw new IllegalArgumentException("Scores array cannot be empty.");
        }

        // Check each score is within valid range (0-100)
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 0) {
                throw new IllegalArgumentException("Score cannot be less than 0.");
            }
            if (scores[i] > 100) {
                throw new IllegalArgumentException("Score cannot be greater than 100.");
            }
        }

        // Calculate sum of all scores
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }

        // Calculate average
        double average = (double) sum / scores.length;

        // Check if grade is below 40 (Failed Significantly)
        if (average < 40) {
            throw new FailedSignificantlyException("Student average is " + average + ", which is a significant failure.");
        }

        return average;
    }

    // Main method
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        try { // โค้ดที่อาจเกิดข้อผิดพลาด
            // Get input from user
            System.out.print("Enter scores (comma-separated) : ");
            String input = scanner.nextLine();

            // Split string by comma
            String[] scoreStrings = input.split(",");

            // Create array to store scores
            int[] scores = new int[scoreStrings.length];

            // Convert string to int
            for (int i = 0; i < scoreStrings.length; i++) {
                scores[i] = Integer.parseInt(scoreStrings[i].trim()); // Trim whitespace and convert to int // from youtube
            }

            // Calculate average
            double average = calculateAverage(scores);

            // Display result
            System.out.println("Average score : " + average);

        } catch (NumberFormatException e) { // จัดการข้อผิดพลาด
            // Catch error when cannot convert string to number
            System.out.println("Invalid input: Please enter a valid number for scores. " + e.getMessage()); // e.getMessage() provides details about the error
        } catch (FailedSignificantlyException e) {
            // Catch error when grade is too low
            System.out.println("Significant Failure : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Catch error from validation
            System.out.println("Error : " + e.getMessage());
        } finally { // โค้ดที่ต้องทำงานเสมอ ไม่ว่าจะเกิด error หรือไม่
            // Close scanner and display conclusion message
            scanner.close();
            System.out.println("Grade calculation process concluded.");
        }
    }
}