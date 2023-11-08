import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Battery mc96 = new Battery("VTec", "MC96", 14.4, 6.6, 0.55, 72, 97, 51.5);
        Battery mc60 = new Battery("VTec", "MC60", 14.4, 4.2, 0.35, 52, 77, 40.5);
        Battery mdPL140 = new Battery("BowserPower", "MD-PL140", 14.4, 9.9, 1.18, 89, 119, 85);
        Battery zlD72 = new Battery("MT-Dell Tech", "ZL-D72", 7.2, 9.9, 1.18, 38, 80, 70);

        // creating shallow-copy of mc96
        Battery shallowMc96 = mc96;
        // creating deep-copy of mc96
        Battery deepMc96 = new Battery("VTec", "MC96", 14.4, 6.6, 0.55, 72, 97, 51.5);

        System.out.println(mc96.isEquals(shallowMc96)); // true
        System.out.println(mc96.isEquals(deepMc96));  // true
        System.out.println(mc96.isEquals(mc60));  //false

        System.out.println(" ");
        System.out.println(mc96.isBigger(mdPL140));  // true
        System.out.println(mc96.isBiggerOrEqual(mc60)); // false
        System.out.println(mc96.isBiggerOrEqual(deepMc96)); // true

        System.out.println(" ");

        System.out.println(mdPL140.isSmaller(zlD72));  // true
        System.out.println(mc96.isSmallerOrEqual(shallowMc96)); // true
        System.out.println(mc96.isSmallerOrEqual(mc60)); // true
    }
}

class Battery{
    public String manufacturer;
    public String model;
    public double voltage;
    public double ampHours;
    public double weightKg;
    public double[] dimensionMm;

    public Battery(String manufacturer,
                   String model,
                   double voltage,
                   double ampHours,
                   double weightKg,
                   double wMm,
                   double hMm,
                   double dMm){
        this.manufacturer = manufacturer;
        this.model = model;
        this.voltage = voltage;
        this.ampHours = ampHours;
        this.weightKg = weightKg;
        this.dimensionMm = new double[]{wMm, hMm, dMm};
    }

    public double getPowerCapacity(){
        return ampHours * voltage;
    }

    public boolean isEquals(Battery battery){
        return manufacturer.equals(battery.manufacturer) && model.equals(battery.model) && voltage == battery.voltage
                && weightKg == battery.weightKg && Arrays.equals(dimensionMm, battery.dimensionMm);
    }

    public boolean isBigger(Battery battery){
        return battery.getPowerCapacity() > getPowerCapacity();
    }

    public boolean isBiggerOrEqual(Battery battery){
        return isBigger(battery) || isEquals(battery);
    }

    public boolean isSmaller(Battery battery){
        return battery.getPowerCapacity() < getPowerCapacity();
//        return !isBiggerOrEqual(battery);
    }

    public boolean isSmallerOrEqual(Battery battery){
        return isEquals(battery) || isSmaller(battery);
    }

    public String toString(){
        String hash = Integer.toHexString(hashCode());
        return "Battery details- manufacturer: " + manufacturer + ", model: " + model + ", hash: " + hash;
    }
}
