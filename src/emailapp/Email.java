package emailapp;
import java.util.*;
import java.io.*;
public class Email {
    // Setting up the variables as private so that they can be accessed only by the methods of this class
    public Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
//    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private int length = 8;

    public Email(String firstName, String lastName){    // Constructor to take the first name and last name
        this.firstName = firstName;
        // this.firstName refers to the instance variable of the class
        // firstName refers to the local variable of the constructor
        this.lastName = lastName;
        //this.lastName refers to the instance variable of the class
        // lastName refers to the local variable of the constructor
        System.out.println("Email Created: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
        this.password = generatePassword(length);
        this.email = generateMail();



    }

    // to generate the mail id
    private String generateMail(){
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + ".company.com";
    }

    // ask for the department
    private String setDepartment(){
        System.out.println("Enter the department\n1. Sales\n2. Development\n3. Accounting\n0. None");
        int choice = sc.nextInt();
        return switch (choice) {    // switch expression
            case 1 -> "Sales";
            case 2 -> "Development";
            case 3 -> "Accounting";
            default -> "";
        };
    }

    // generate a random password
    private String generatePassword(int length){
        this.length = length;
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            // Math.random() * passwordSet.length() means that the random number generated will be between 0 and passwordSet.length()
            password[i] = passwordSet.charAt(rand);   // passwordSet.charAt(rand) returns the character at the index rand
        }
        return new String(password);
    }

    // change the password
    public void changePassword(String password){

        boolean flag = false;

        do {
                System.out.println("Do you want to change the password?(Y/N)");
                char choice = sc.next().charAt(0);
                if (choice == 'Y' || choice == 'y')
                {
                    flag = true;

                    System.out.println("Enter the current password");
                    String temp = sc.next();
                    if (temp.equals(this.password)) {
                        // this.password refers to the instance variable of the class password refers to the local variable of the method
                        System.out.println("Enter the new password");
                        this.password = sc.next();
                        System.out.println("Password changed successfully");
                    } else {
                        System.out.println("Incorrect password! Try again!!!");
                    }


                }
                else if (choice == 'N' || choice == 'n')
                {
                    flag = true;
                    System.out.println("Password not changed");
                } else
                {
                    System.out.println("Invalid choice");
                }

            } while (!flag);


    }

    // set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        System.out.println("Current mailbox capacity: " + this.mailboxCapacity + "MB");
        System.out.println("Do you want to change the mailbox capacity?(Y/N)");
        char choice = sc.next().charAt(0);
        if(choice == 'Y' || choice == 'y'){
            this.mailboxCapacity = capacity;
            System.out.println("Mailbox capacity changed successfully");
        }
        else if(choice == 'N' || choice == 'n'){
            System.out.println("Mailbox capacity not changed");
        }
        else{
            System.out.println("Invalid choice");
        }
    }
    // set the alternate email
    public void setAlternateEmail(String alternateEmail){
        System.out.println("Current alternate email: " + this.alternateEmail);
        System.out.println("Do you want to change the alternate email?(Y/N)");
        char choice = sc.next().charAt(0);
        if(choice == 'Y' || choice == 'y'){
            this.alternateEmail = alternateEmail;
            System.out.println("Alternate email changed successfully");
        }
        else if(choice == 'N' || choice == 'n'){
            System.out.println("Alternate email not changed");
        }
        else{
            System.out.println("Invalid choice");
        }
    }

    // display the details
    public void displayDetails(){
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox capacity: " + this.mailboxCapacity + "MB");
        System.out.println("Alternate email: " + this.alternateEmail);
    }

    public void storefiles(){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\vidit\\OneDrive\\Desktop\\details.txt");
            fw.write("Name: " + this.firstName + " " + this.lastName + "\n");
            fw.append("Department: ").append(this.department).append("\n");
            fw.append("Email: ").append(this.email).append("\n");
            fw.append("Password: ").append(this.password).append("\n");
            fw.append("Mailbox capacity: ").append(String.valueOf(this.mailboxCapacity)).append("MB").append("\n");
            fw.append("Alternate email: ").append(this.alternateEmail).append("\n");
            fw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        //  file reader
        try {
            FileReader fr = new FileReader("C:\\Users\\vidit\\OneDrive\\Desktop\\details.txt");
            int i;
            while((i=fr.read()) != -1){
                System.out.print((char) i);
            }
            fr.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
