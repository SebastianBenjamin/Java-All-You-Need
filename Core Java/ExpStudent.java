import java.util.*;
class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}
class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}
class Student {
    int rollNo;
    int age;
    String name;
    String course;

    public Student(int r, int a, String n, String c) {
        rollNo = r;
        course = c;
        
        try {
            if (a < 15 || a > 21) {
                throw new AgeNotWithinRangeException("Age should be between 15 and 21.");
            } else {
                age = a;
                try {
                    for (int i = 0; i < n.length(); i++) {
                        if (!Character.isLetter(n.charAt(i))) {
                            throw new NameNotValidException("Name should only contain alphabets.");
                        }
                    }
                    name = n; 
                    System.out.println("Student Information:");
                    System.out.println("Roll No: " + this.rollNo);
                    System.out.println("Age: " + this.age);
                    System.out.println("Name: " + this.name);
                    System.out.println("Course: " + this.course);
                } catch (NameNotValidException e) {
                  e.printStackTrace();
                }
            }
        } catch (AgeNotWithinRangeException e) {
            e.printStackTrace();

        }
        
       
    }
}

public class ExpStudent {
    public static void main(String[] args) {
        Scanner uI = new Scanner(System.in);
        boolean boo = true;

        while (boo) {
            try {
                System.out.println("\n+--------------------------------------+");
                  System.out.println("|         Student Information          |");
                  System.out.println("+--------------------------------------+");
                
                System.out.print("Enter Roll No: ");
                int rollNo = uI.nextInt();

                System.out.print("Enter Age : ");
                int age = uI.nextInt();
                
                uI.nextLine(); 

                System.out.print("Enter Name : ");
                String name = uI.nextLine();
                
                System.out.print("Enter Course: ");
                String course = uI.nextLine();
                
                Student student = new Student(rollNo, age, name, course);
                
            } catch (Exception e) {
                e.printStackTrace();
                
            }
            
            System.out.println("\n+--------------------------------------+\n");
            System.out.print("Do you want to enter another student? \n 1: Yes \n 2: No \nYour selection:  ");
            int Selection = uI.nextInt();
            if (Selection != 1) {
                boo = false;
                System.out.println("\n+--------------------------------------+\n");
                  System.out.println("Exiting the Student Information Program.");
                System.out.println("\n+--------------------------------------+\n");
            }
        }

        uI.close();
    }
}
