// Exercise 10.13: PayrollSystemTest.java
// Employee hierarchy test program.
// Noah Watson
// CS 145
// 4/30/2024
// Assignment: Add get methods to Data.java class. Create array of Employee variables to stores references to previous employee objects. 
// In a loop, calculate the payroll for each Employee polymorphically, and add a $100 bonus to the employee's payroll amount if current month includes their birthday.

import java.util.Scanner; // program uses Scanner to obtain user input

public class PayrollSystemTest {
   public static void main(String[] args) {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee(
         "John", "Smith", "111-11-1111", 6, 15, 1944, 800.00);
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee(
         "Karen", "Price", "222-22-2222", 12, 29, 1960, 16.75, 40);
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee(
         "Sue", "Jones", "333-33-3333", 9, 8, 1954, 10000, .06);
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee(
         "Bob", "Lewis", "444-44-4444", 3, 2, 1965, 5000, .04, 300);

      System.out.println("Employees processed individually:\n");
      
      System.out.printf("%s\n%s: $%,.2f\n\n", 
         salariedEmployee, "earned", salariedEmployee.earnings());
      System.out.printf("%s\n%s: $%,.2f\n\n",
         hourlyEmployee, "earned", hourlyEmployee.earnings());
      System.out.printf("%s\n%s: $%,.2f\n\n",
         commissionEmployee, "earned", commissionEmployee.earnings());
      System.out.printf("%s\n%s: $%,.2f\n\n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4]; 

      // initialize array with Employees
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee; 
      employees[3] = basePlusCommissionEmployee;

      Scanner input = new Scanner(System.in); // to get current month
      int currentMonth;

      // get and validate current month
      do {
         System.out.print("Enter the current month (1 - 12): ");
         currentMonth = input.nextInt();
         System.out.println();
      } while ((currentMonth < 1) || (currentMonth > 12));

      System.out.println("Employees processed polymorphically:\n");
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee); // invokes toString

         // if month of employee's birthday, add $100 to salary
         if (currentMonth == currentEmployee.getBirthDate().getMonth()) {
            System.out.printf(
               "earned $%,.2f %s\n\n", currentEmployee.earnings(), "plus $100.00 birthday bonus");
         } else {
            System.out.printf(
               "earned $%,.2f\n\n", currentEmployee.earnings());
         }
      }

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++) {
         System.out.printf("Employee %d is a %s\n", j, 
            employees[j].getClass().getName()); 
      }
   }
}

