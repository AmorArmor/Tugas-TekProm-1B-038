public class Commision extends Hourly {
    private double totalSales;
    private double commRate;

    public Commision(String eName, String eAddress, String ePhone,
    String socSecNumber, double rate, double commRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commRate = commRate;
    }

    public void addSales (double totalSales){
        this.totalSales += totalSales;
    }
    
    @Override
    public double pay()
    {
        double payment = super.pay() + (commRate * totalSales);
        totalSales = 0;
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTotal Sales: " + totalSales;
    }
}
