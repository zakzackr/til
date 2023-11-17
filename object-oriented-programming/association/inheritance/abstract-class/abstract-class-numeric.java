public class Main {
    public static void main(String[] args) {
        Numeric num1 = new IntegerNumeric(73);
        Numeric num2 = new IntegerNumeric(23555461);
        Numeric num3 = new CharNumeric('a');
        Numeric num4 = new IntegerNumeric(127);

        numericPrinter(num1);
        numericPrinter(num2);
        numericPrinter(num3);
        numericPrinter(num4);

        System.out.println();

        Numeric hexNum = new HexNumeric("1234abcd");
        Numeric octNum = new OctNumeric("671");
        Numeric bigNum = new BigDecimalNumeric("394.4555643321");
        numericPrinter(hexNum);
        numericPrinter(octNum);
        numericPrinter(bigNum);

        BigDecimalNumeric bigNum2 = new BigDecimalNumeric("394.4555643321");
        BigDecimalNumeric bigNum3 = new BigDecimalNumeric("100.4555643321");

        System.out.println(bigNum2.addBigNums(bigNum3));
    }

    public static void numericPrinter(Numeric num){
        System.out.println(num);
        System.out.println("Byte: " + num.getByte());
        System.out.println("Short: " + num.getShort());
        System.out.println("Long: " + num.getLong());
        System.out.println("Char: " + num.getChar());
        System.out.println("Double: " + num.getDouble());
        System.out.println();
    }
}

// superclass
abstract class Numeric{

    public byte getByte(){
        return (byte)getInteger();
    }

    public short getShort(){
        return (short)getInteger();
    }

    public long getLong(){
        return (long)getInteger();
    }

    public char getChar(){
        return (char)getInteger();
    }

    // abstract methods should be implemented in each concrete class as concrete classes hold int, char, and string data and these methods will have different bodies.
    public abstract int getInteger();
    public abstract double getDouble();

    public String toString(){
        return getClass().getSimpleName() + " of int value: " + getInteger();
    }
}

// takes int value as an instance variable to express number
class IntegerNumeric extends Numeric{
    private int value;

    public IntegerNumeric(int value){
        this.value = value;
    }

    public int getInteger(){
        return this.value;
    }

    public double getDouble(){
        return value + 0.0;
    }
}

// takes char as an instance variable to express number
class CharNumeric extends Numeric{
    private char c;

    public CharNumeric(char c){
        this.c = c;
    }

    public int getInteger(){
        return (int) c;
    }

    public double getDouble(){
        return getInteger() + 0.0;
    }
}

// takes hex string as an instance variable to express number
class HexNumeric extends Numeric{
    private String hex;

    public HexNumeric(String hex){
        this.hex = hex;
    }

    public int getInteger(){
        return Integer.parseInt(hex, 16);
    }

    public double getDouble(){
        return getInteger() + 0.0;
    }
}

// takes oct string as an instance variable to express number
class OctNumeric extends Numeric{
    private String oct;

    public OctNumeric(String oct){
        this.oct = oct;
    }

    public int getInteger(){
        return Integer.parseInt(oct, 8);
    }

    public double getDouble(){
        return getInteger() + 0.0;
    }
}

// takes string representing int value as an instance variable to express number
class BigDecimalNumeric extends Numeric{
    private String bigNum;

    public BigDecimalNumeric(String bigNum){
        this.bigNum = bigNum;
    }

    public int getInteger(){
        return (int) getDouble();
    }

    public double getDouble() {
        return Double.parseDouble(bigNum);
    }

    public double addBigNums(BigDecimalNumeric bigNum){
        return getDouble() + bigNum.getDouble();
    }
}



