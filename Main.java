package myPackage;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the application!");
        System.out.println("Project name: Final Project");
        System.out.println("This application is developed by Full Stack Developer: Abilash Ravi.");
        System.out.println("|---------------------------------------------------------------------|");
        Base1 myF = new Base1();
        Base my = new Base();
        myF.start();
        my.run();
        myF.listFiles();
        myF.fileManager();
        myF.reOption();
    }
}

class Base extends Thread{
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Enter the file directory: ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Base1 {
    Scanner myScanner = new Scanner(System.in);
    String directory;

    public void start() {
        System.out.println("Enter 1 to continue / Enter 0 to exit the application: ");
        try {
            int option = myScanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Welcome to the application!");
                    myScanner.nextLine();
                    System.out.println("|-----------------------------------------------------------------|");
                    break;
                case 0:
                    System.out.println("Thank you for your time!");
                    System.exit(-1);
                    break;
                default:
                    System.err.println("Invalid input. ");
                    System.out.println("|-----------------------------------------------------------------|");
                    start();
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input.");
            System.out.println("|-----------------------------------------------------------------|");
            myScanner.next();
            start();
        }
    }

    public void listFiles() {
        directory = myScanner.nextLine();
        File file = new File(directory);
        if (file.isDirectory()) {
            System.out.println("Directory exists: " + directory);
            System.out.println("|-----------------------------------------------------------------|");
            System.out.println("Enter 1 to list files / Enter 2 to continue without listing / Enter 0 to exit the app: ");
            isDirectory();
        } else {
            System.out.println("Directory does not exist. ");
            System.out.println("|-----------------------------------------------------------------|");
            opt();
        }

    }

    public void opt() {
        System.out.println("Press 1 to re-enter the valid directory / Enter 0 to exit: ");
        try {
            int option = myScanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Thank you for your time!");
                    System.exit(-1);
                    break;
                case 1:
                    System.out.println("Enter a valid directory: ");
                    myScanner.nextLine();
                    listFiles();
                    break;
                default:
                    System.err.println("Invalid input.");
                    System.out.println("|-----------------------------------------------------------------|");
                    opt();
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input.");
            System.out.println("|-----------------------------------------------------------------|");
            myScanner.next();
            opt();
        }
    }

    public void isDirectory() {
        try {
            int option = myScanner.nextInt();
            switch (option) {
                case 1:
                    File myFile = new File(directory);
                    List myList = Arrays.asList(myFile.list());
                    for (int i = 0; i < myList.size(); i++) {
                        System.out.println(myList.get(i));
                    }
                    System.out.println("|-----------------------------------------------------------------|");
                    options();
                    break;
                case 2:
                    options();
                    break;
                case 0:
                    System.out.println("Thank you for your time!");
                    System.exit(-1);
                    break;
                default:
                    System.err.println("Invalid option!");
                    System.out.println("|-----------------------------------------------------------------|");
                    System.out.println("Enter 1 to list files / Enter 2 to continue without listing / Enter 0 to exit the app : ");
                    isDirectory();
                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input.");
            System.out.println("|-----------------------------------------------------------------|");
            System.out.println("Enter 1 to list files / Enter 2 to continue without listing / Enter 0 to exit the app: ");
            myScanner.next();
            isDirectory();
        }
    }

    public static void options() {
        System.out.println("Enter 1 to add a user specified file");
        System.out.println("Enter 2 to delete a user specified file");
        System.out.println("Enter 3 to search a user specified file from the application");
        System.out.println("Enter 4 to close the application");
    }

    public void fileManager() throws IOException {
        try {
            int option = myScanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter your new file name: ");
                    myScanner.nextLine();
                    String filename = myScanner.nextLine();
                    File newFile = new File(directory + "//" + filename);
                    newFile.createNewFile();
                    System.out.println("The new file has been created: " + newFile.getName());
                    System.out.println("|-----------------------------------------------------------------|");
                    reOption();
                    break;
                case 2:
                    System.out.println("Enter the file you want to delete: ");
                    myScanner.nextLine();
                    String fileName = myScanner.nextLine();
                    File newFile1 = new File(directory + "//" + fileName);
                    if (newFile1.exists()) {
                        newFile1.delete();
                        System.out.println("The file has been deleted: " + newFile1.getName());
                        System.out.println("|-----------------------------------------------------------------|");
                    } else {
                        System.out.println("The file does not exit: " + newFile1.getName());
                        System.out.println("|-----------------------------------------------------------------|");
                    }
                    reOption();
                    break;
                case 3:
                    System.out.println("Enter the file you want to search: ");
                    myScanner.nextLine();
                    String searchFile = myScanner.nextLine();
                    File myFile = new File(directory + "//" + searchFile);
                    if (myFile.exists()) {
                        System.out.println("The file exists: " + myFile.getName());
                        System.out.println("|-----------------------------------------------------------------|");
                    } else {
                        System.out.println("The file doesn't exit: " + myFile.getName());
                        System.out.println("|-----------------------------------------------------------------|");
                    }
                    reOption();
                    break;
                case 4:
                    System.out.println("Thank you for your time!");
                    System.exit(-1);
                default:
                    System.err.println("Invalid input. ");
                    System.out.println("|-----------------------------------------------------------------|");
                    options();
            }
            fileManager();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input.");
            System.out.println("|-----------------------------------------------------------------|");
            myScanner.next();
            options();
        }
        fileManager();
    }

    public void reOption() throws IOException {
        System.out.println("Enter 1 to change the directory.");
        System.out.println("Enter 2 to display options for the present / given directory.");
        System.out.println("Enter 0 to exit the application.");
        try {
            int option1 = myScanner.nextInt();
            if (option1 == 1) {
                System.out.println("Enter the file directory: ");
                myScanner.nextLine();
                listFiles();
            } else if (option1 == 2) {
                options();
                fileManager();
            } else if (option1 == 0) {
                System.out.println("Thank you for your time!");
                System.exit(-1);
            } else {
                System.err.println("Invalid input.");
                System.out.println("|-----------------------------------------------------------------|");
                reOption();
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input.");
            System.out.println("|-----------------------------------------------------------------|");
            myScanner.next();
            reOption();
        }
    }
}


