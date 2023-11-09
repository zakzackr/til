public class Main {

    public static void main(String[] args) {
        Battery7v zlD72 = new Battery7v("MT-Dell Tech", "ZL-D72", 9.9, 1.18, 38, 80, 70);
        System.out.println("Created instances: " + Battery7v.manufacturedCount);
        System.out.println("Created instances: " + zlD72.manufacturedCount);

        Battery7v zlD50 = new Battery7v("MT-Dell Tech", "ZL-D50", 6.6, 0.9, 28, 50, 65);
        Battery7v zlD40 = new Battery7v("MT-Dell Tech", "ZL-D40", 5.3, 1.18, 38, 80, 70);

        System.out.println(zlD72);
        System.out.println(zlD50);
        System.out.println(zlD40);

        // changing the value of class variable
        Battery7v.type = "unknown-type";
        // changing the value of member variable
        zlD72.model = "unknown-model";

        System.out.println();
        System.out.println(zlD72);
        System.out.println(zlD50);
        System.out.println(zlD40);
    }
}

class Battery7v{
    public String manufacturer;
    public String model;
    public static double voltage = 7.2;
    public static String type = "Lithium-Ion";
    public static int manufacturedCount;
    public double ampHours;
    public double weightKg;
    public double[] dimensionMm;

    public Battery7v(String manufacturer, String model, double ampHours, double weightKg, double wMm, double hMm, double dMm){
        this.manufacturer = manufacturer;
        this.model = model;
        this.ampHours = ampHours;
        this.weightKg = weightKg;
        this.dimensionMm = new double[]{wMm, hMm, dMm};
        this.manufacturedCount += 1;
    }

    public String toString(){
        return "count: " + manufacturedCount + ", model: " + model + ", type: " + type + ", ampHours: " + ampHours + ", weightKg: " + weightKg + ", wMm: " + dimensionMm[0] + ", hMm: " + dimensionMm[1] + ", dMm: " + dimensionMm[2];
    }

    public double getPowerCapacity(){
        return voltage * ampHours;
    }

    public double getVoltage(){
        return dimensionMm[0] * dimensionMm[1] * dimensionMm[2];
    }
}
