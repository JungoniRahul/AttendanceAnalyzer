import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
class Attendance {
    public int totalClassesAttended;
    public int totalClassesHappened;
    public int totalClassesPerWeek;
    public int minimumEligibility;
    public Scanner sc = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public Attendance(){

    }

    public Attendance(int totalClassesAttended, int totalClassesHappened, int totalClassesPerWeek, int minimumEligibility){
        this.totalClassesAttended = totalClassesAttended;
        this.totalClassesHappened = totalClassesHappened;
        this.totalClassesPerWeek = totalClassesPerWeek;
        this.minimumEligibility = minimumEligibility;
    }
    public void reachCriteria(){
        int x = (totalClassesHappened * minimumEligibility) - (totalClassesAttended * 100);
        int y = 100 - minimumEligibility;
        int classesNeedToBeAttended = x/y;
        int weeks = classesNeedToBeAttended /totalClassesPerWeek;
        System.out.println();
        System.out.println("Total classes that you need to attend to reach minimum eligibility is " + classesNeedToBeAttended + ". This would take you about " + weeks + " weeks");
        System.out.println("**This only applies if you intend attend all the classes till you reach minimum criteria");
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("For main menu, enter '1', to exit, enter '0'");
        System.out.print("Enter a value: ");
        int userValue = sc.nextInt();
        switch(userValue){
            case 0:
                return;
            case 1:
                String[] args = {};
                Main.main(args);
        }
    }
    public void subWiseAtd(){
        System.out.println("Subject Wise Attendance Analysis");
        System.out.print("Enter the number of subjects: ");
        int userInput = sc.nextInt();
        System.out.print("Enter minimum attendance required (%): ");
        int minimumEligibility = sc.nextInt();
        String[][] arr = new String[userInput][2];
        for(int i = 0; i < userInput; i++){
            int a = i + 1;
            System.out.print("Enter subject " + a +" name: ");
            sc.nextLine();
            arr[i][0] = sc.nextLine();;
            System.out.print("Total classes happened in " + arr[i][0] + " so far: ");
            int totalClassesHappened = sc.nextInt();
            System.out.print("Number of classes attended in " + arr[i][0] + " so far: ");
            int totalClassesAttended = sc.nextInt();
            int x = (totalClassesHappened * minimumEligibility) - (totalClassesAttended * 100);
            int y = 100 - minimumEligibility;
            int classesNeedToBeAttended = x/y;
            arr[i][1] = String.valueOf(classesNeedToBeAttended);
        }
        System.out.println("---------------------------------------------");
        System.out.println("Subject and classes needed to be attended to reach minimum required attendance");
        for(int i = 0; i < userInput; i++){
            int a = i + 1;
            System.out.println(a + ". Subject: " + arr[i][0]);
            System.out.println("   No. of classes: " + arr[i][1]);
        }

        System.out.println("---------------------------------------------");
        System.out.println("For main menu, enter '1', to exit, enter '0'");
        System.out.print("Enter a value: ");
        int userValue = sc.nextInt();
        switch(userValue){
            case 0:
                return;
            case 1:
                String[] args = {};
                Main.main(args);
        }
    }
    public void predictAttendance(){
        System.out.println("Predict Attendance");
        System.out.print("Total number of classes happened: ");
        float totalClassesHappened = sc.nextFloat();
        System.out.print("Number of classes you attended so far: ");
        float totalClassesAttended = sc.nextFloat();
        System.out.print("Number of classes you intend to miss: ");
        int classesIntendToMiss = sc.nextInt();
        float currentAttendance = Float.parseFloat(df.format((totalClassesAttended/totalClassesHappened)*100));
        float x = totalClassesHappened + (float) classesIntendToMiss;
        float expectedAttendance = (float)(totalClassesAttended/x)*100;
        System.out.println("Current Attendance: " + currentAttendance);
        System.out.println("Expected Attendance after missing " + classesIntendToMiss +  " classes: " + expectedAttendance);

        System.out.println("---------------------------------------------");
        System.out.println("For main menu, enter '1', to exit, enter '0'");
        System.out.print("Enter a value: ");
        int userValue = sc.nextInt();
        switch(userValue){
            case 0:
                return;
            case 1:
                String[] args = {};
                Main.main(args);
        }
    }
    public void fullAttendanceReport(){

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select one of the below options:  ");
        System.out.println("1 - To know number of classes to be attended to reach the minimum attendance criteria");
        System.out.println("2 - To get subject wise attendance analysis");
        System.out.println("3 - Predict Attendance (To know how missing classes would your effect overall Attendance)");
        System.out.println("4 - Get full Attendance Report");
        System.out.println();
        System.out.print("Enter a value: ");
        int userValue = sc.nextInt();
        System.out.println("---------------------------------------------");

        switch (userValue){
            case 1:
                System.out.print("Enter total classes attended: ");
                int totalClassesAttended = sc.nextInt();
                System.out.print("Enter total classes happened: ");
                int totalClassesHappened = sc.nextInt();
                System.out.print("Enter total classes per week: ");
                int totalClassesPerWeek = sc.nextInt();
                System.out.print("Minimum Attendance Required: ");
                int minimumEligibility = sc.nextInt();
                Attendance student1 = new Attendance(totalClassesAttended, totalClassesHappened, totalClassesPerWeek, minimumEligibility);
                student1.reachCriteria();
            case 2:
                Attendance student2 = new Attendance();
                student2.subWiseAtd();
            case 3:
                Attendance student3 = new Attendance();
                student3.predictAttendance();
            default:
                System.out.println("Invalid input, select from the above options");
        }

    }
}