public class CSuiteManager extends Manager {
    private int stockOptions;
    private double strikePrice;
    private String fancyTitle;

    //constructor 1
    public CSuiteManager(String name, int age, String SSN, String passwd, int numSubordinates, int stockOptions, double strikePrice, String fancyTitle) {
        // use "super" to invoke the constructor of the Person class,
        // to create an internal Person object
        super(name, age, SSN, passwd,numSubordinates);

        this.stockOptions = stockOptions;
        this.strikePrice = strikePrice;
        this.fancyTitle = fancyTitle;
    }

    // constructor 2
    public CSuiteManager(String name, int age, String SSN, String passwd, int numSubordinates) {
        // use "super" to invoke the constructor of the Person class,
        // to create an internal Person object
        super(name, age, SSN, passwd,numSubordinates);

        this.stockOptions = 0;
        this.strikePrice = 1.00;
        this.fancyTitle = "Chief Technical Officer";
    }

    //toString
    @Override
    public String toString() {
        return "This is CSuiteManager, Name: " + getName() + " fancyTitle: " + this.fancyTitle;
    }

    //Getter-like method
    public double getCost(){
        return this.stockOptions * this.strikePrice;
    }

    //Setter to increase their number of options, but not to change the strikePrice
    public void setStockOptions(int stockOptions){
        if(stockOptions < this.stockOptions || this.stockOptions < 0){
            throw new IllegalArgumentException();
        }
        this.stockOptions = stockOptions;
    }

    //Provide a method that computes this manager's capitalGains for fully exercising
    public double getCapitalGains(double marketPrice){
        return (marketPrice - this.strikePrice) * this.stockOptions;
    }


}
