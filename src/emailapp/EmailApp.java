package emailapp;

import java.util.*;
public class EmailApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first name: ");
        String firstName = sc.next();
        System.out.println("Enter the last name: ");
        String lastName = sc.next();
        Email email = new Email(firstName, lastName);
        int choice = -1;
        System.out.println("Enter the choice\n1. Show Info\n2. Change Password\n3. Change Mailbox Capacity\n4. Change Alternate Email\n5. Menu\n0. Exit");
        do {

            choice = sc.nextInt();
            switch (choice) {
                case 1 -> email.displayDetails();
                case 2 -> {
                    System.out.println("Enter the current password: ");
                    String newPassword = sc.next();
                    email.changePassword(newPassword);
                }
                case 3 -> {
                    System.out.println("Enter the new mailbox capacity: ");
                    int newMailboxCapacity = sc.nextInt();
                    email.setMailboxCapacity(newMailboxCapacity);
                }
                case 4 -> {
                    System.out.println("Enter the new alternate email: ");
                    String newAlternateEmail = sc.next();
                    email.setAlternateEmail(newAlternateEmail);
                }
                case 5 -> {
                    System.out.println("Enter the choice\n1. Show Info\n2. Change Password\n3. Change Mailbox Capacity\n4. Change Alternate Email\n0. Exit");
                }

                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid Choice\n Enter again");
            }
        }while (choice != 0 );

    }
}
