package guicarcalc;

public class TravelCost {
    private double MtoDrive;
    private double MperG;
    private double GasPrice;
    private double ParkingCost;
    private double TollCost;
    private double TotalCost;
    
    public TravelCost(double a, double b, double c, double d,  double f)
    {
        this.MtoDrive=a;
        this.MperG=b;
        this.GasPrice=c;
        this.ParkingCost=d;
        this.TollCost=f;     
    }
    
    public void CalCost()
    {
        this.TotalCost=(this.MtoDrive/this.MperG)*this.GasPrice+this.ParkingCost+this.TollCost;
    }
    
    public double getTotalCost()
    {
        return this.TotalCost;
    }
}
