import java.util.Scanner;

//custom exception
class Invalid_registration_exception extends Exception{
    Invalid_registration_exception(String message){
        super(message);
    }
}
//exam registration class

class Exam_registration{
    public static void validate_registration(String studentID,int age,double exam_mark,int subjects) throws
            Invalid_registration_exception{
        if (studentID.isEmpty()){
            throw new Invalid_registration_exception("Student Id can not be empty.");
        }
        if (age<18){
            throw new Invalid_registration_exception("Age must be at least 18.");
        }
        if (exam_mark<0 || exam_mark>100){
            throw new Invalid_registration_exception("exam marks must be between 1 and 100");
        }
        if (subjects<1 ||subjects>5){
            throw new Invalid_registration_exception("maximum allowed subjects is 5.");
        }

    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");

        try {
            System.out.print("Enter Student ID: ");
            String studentID = input.nextLine();

            System.out.print("Enter Student Name: ");
            String studentName = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();

            System.out.print("Enter Exam Mark: ");
            double exam_mark = input.nextDouble();

            System.out.print("Enter Number of Subjects: ");
            int subjects = input.nextInt();
            validate_registration(
                    studentID, age, exam_mark, subjects
            );
            System.out.println("\nRegistration Successful!");
            System.out.println("Student: " + studentName);
            System.out.println("Registered Subjects: " + subjects);

        } catch (Invalid_registration_exception e) {

            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("\nRegistration Failed!");
            System.out.println("Error: Please enter valid numbers.");

        } finally {

            System.out.println("\nRegistration attempt completed.");
            input.close();
        }
    }

}

public class University_Exam_Registration_System {
}
