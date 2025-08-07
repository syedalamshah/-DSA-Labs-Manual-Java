import java.util.Scanner;

public class Ticketcost
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter hours worked per week: ");
        double hoursPerWeek = sc.nextDouble();
        
        System.out.print("Enter hourly wage: ");
        double hourlyWage = sc.nextDouble();
        
        System.out.print("Enter vacation days: ");
        int vacationDays = sc.nextInt();
        
        // Calculate yearly salary
        double totalWorkHours = hoursPerWeek * 52; // 52 weeks in year
        double vacationHours = vacationDays * 8;   // 8 hours per day
        double paidHours = totalWorkHours - vacationHours;
        double yearlySalary = paidHours * hourlyWage;
        
        // Display result
        System.out.println("Your yearly salary: $" + yearlySalary);
        
        sc.close();
    }
}