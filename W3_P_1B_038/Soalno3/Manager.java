import java.util.Calendar;
import java.util.GregorianCalendar;

class Manager extends Employee {
    private String secretaryName;
    private double bonus;

    public Manager(String n, double s, int d, int m, int y) {
        super(n, s, d, m, y);
        secretaryName = "";
    }

    public void setBonus(double b) {
        bonus = b;
    }

    @Override
    public void raiseSalary(double byPercent) {
        // Menambahkan bonus 1/2% untuk setiap tahun masa kerja
        GregorianCalendar todaysDate = new GregorianCalendar();
        int currentYear = todaysDate.get(Calendar.YEAR);
        double bonus = 0.5 * (currentYear - hireYear());

        super.raiseSalary(byPercent + bonus);
    }

    @Override
    public double getSalary() {
        // Mengambil gaji pokok dari superclass (Employee) lalu ditambah bonus
        return super.getSalary() + bonus;
    }

    public String getSecretaryName() {
        return secretaryName;
    }
}
