import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        Department itDept =  new Department("IT");
        Department hrDept = new Department("HR");
        Department humasDept = new Department("Humas");

        Employee emp1 = Employee.createFullTimeEmployee("Amor", itDept, 12000000);
        Employee emp2 = Employee.createPartTimeEmployee("Haidar", hrDept, 7000000);
        Employee emp3 = Employee.createContractEmployee("Hafiz", humasDept, 8000000);
    
        service.addEmployee(emp1);
        service.addEmployee(emp2);
        service.addEmployee(emp3);

        System.out.println("=== Data Karyawan Awal ===");
        printEmployeeInfo(service.getEmployee(1));
        printEmployeeInfo(service.getEmployee(2));
        printEmployeeInfo(service.getEmployee(3));

        System.out.println("\n--- Menaikkan gaji semua karyawan sebesar 20% ---");
        service.raiseSalary(1, 20.0);
        service.raiseSalary(2, 20.0);
        service.raiseSalary(3, 20.0);

        System.out.println("\n=== Data Karyawan Setelah Kenaikan Gaji ===");
        printEmployeeInfo(service.getEmployee(1));
        printEmployeeInfo(service.getEmployee(2));
        printEmployeeInfo(service.getEmployee(3));
    }

    public static void printEmployeeInfo(Employee emp) {
        if (emp != null) {
            System.out.printf("ID: %d | Nama: %-5s | Dept: %-3s | Tipe: %-10s | Gaji: Rp %,.0f %n",
                emp.getId(), 
                emp.getName(), 
                emp.getDepartment().getName(), 
                emp.getType().getType(), 
                emp.getSalary());
        }
    }
}