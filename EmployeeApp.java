import java.util.Scanner;

class Employee
{
	private String firstName;
	private String lastName;
	private int employeeId;
	private double salary;

	//Constructors
	Employee(){
		this.firstName = "NO FIRST NAME";
		this.lastName = "NO LAST NAME";
		this.employeeId = -1;
		this.salary = -1;
	}

	Employee(String lastName, String firstName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	Employee(String lastName, String firstName, int employeeId, double salary){
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.salary = salary;
	}


	//Mutator Methods	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setEmployeeId(int employeeId){
		if (employeeId > 0){
			this.employeeId = employeeId;
		} else {
			employeeId = -1;
		}
	}
	
	public void setSalary(double salary){
		if (Double.compare(salary, 0.0) > 0){
			this.salary = salary;
		} else {
			this.salary = 0.0;
		}
	}
	
	//Accessor Methods
	public String getFirstName(){
		return this.firstName;	
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public int getEmployeeId(){
		return this.employeeId;
	}

	public double getSalary(){
		return this.salary;
	}

   
	@Override
  public String toString(){
		return this.firstName + " " + this.lastName + "\nEmployee ID: " + this.employeeId + "\nSalary: " + this.salary + "\n";
	} 
   
	public boolean equals(String strLastName){
		return this.lastName.equalsIgnoreCase(strLastName);
	}
   
}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES];
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES )
					{

						employees[empCount] = new Employee();

						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						String firstName;						
						String lastName;						
						int employeeId;
						double salary;

						System.out.println("Enter employee's name (FirstName LastName)");
						firstName = keyboard.nextLine();	
						lastName = firstName.substring(firstName.indexOf(" ") + 1);
						firstName = firstName.substring(0, firstName.indexOf(" "));
						
						System.out.println("Enter Employee Number");
						employeeId = keyboard.nextInt();
			
						System.out.println("Enter Employee Salary");
						salary = keyboard.nextDouble();

						employees[empCount].setFirstName(firstName);
						employees[empCount].setLastName(lastName);
						employees[empCount].setEmployeeId(employeeId);
						employees[empCount].setSalary(salary);
 
						empCount++;
		
						System.out.printf("Successfully created %s %s\n",firstName, lastName);
					} else {
						System.out.println("You may not add a new employee at this time.");
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{
							if ( employees[lp].equals( inputString ) == true )
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							} 
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<empCount; lp++ )
					{
						System.out.println( employees[lp].toString() );
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}
