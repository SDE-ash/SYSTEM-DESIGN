package SOLIDORINCIPLES;

//SRP -> single responsibility principle
// a class should have only and only one reason to be change;
// real world example : Employee management system :
class Employee{
    private String name;

    private String email;

    private double salary;

    public Employee(String name, String email, double salary){
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setNamw(String name){
        this.name = name;
    }

    public void SetEmail(String email){
        this.email = email;
    }
    

    public void setSalary(double salary){
        this.salary = salary;
    }
}


// save emplyee to db 
class EmployeeSave{

    public void saveEmployee (Employee e){
        System.out.print("Employee with the name "+ e.getName()+ " is saved");
    }
}

//sending email
class SendEmail{

    public void sendEmail(Employee e){
        System.out.println("email is triggreed for the employee "+ e.getName()+ "at email "+ e.getEmail());
    }
}


// payment service;
class SalaryEmployee{

    public void printSalarySlip(Employee e){
        System.out.println(" salary is just dhoka "+ e.getSalary());
    }
}

class EmployeeService{
    private final EmployeeSave employeeSave;

    private final SalaryEmployee salaryEmployee;

    private final SendEmail sendEmail;


    public EmployeeService(EmployeeSave employeeSave,SalaryEmployee salaryEmployee ,SendEmail sendEmail){
        this.employeeSave = employeeSave;
        this.salaryEmployee= salaryEmployee;
        this.sendEmail = sendEmail;
    }

    public void emailservice(Employee e){
        sendEmail.sendEmail(e);
    }

}

public class SRP {
    
}
