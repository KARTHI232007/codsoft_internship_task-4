import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String grade;

    Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Grade: " + grade);
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n---- STUDENT MANAGEMENT SYSTEM ----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String g = sc.nextLine();

                    list.add(new Student(r, n, g));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : list) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int search = sc.nextInt();
                    boolean found = false;

                    for (Student s : list) {
                        if (s.rollNo == search) {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to remove: ");
                    int remove = sc.nextInt();
                    boolean removed = false;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).rollNo == remove) {
                            list.remove(i);
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println("Student Removed Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program... Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
