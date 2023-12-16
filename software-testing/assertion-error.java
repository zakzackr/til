class Assertion{
    public static void run(boolean b) throws Exception{
        if (!b) throw new Exception("Assertion Error...");
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        Assertion.run(formatDecimal(10.875) == 11);
        Assertion.run(formatDecimal(20.345) == 20);
        Assertion.run(formatDecimal(54.075) == 54);
        Assertion.run(formatDecimal(54.065) == 54);
        Assertion.run(formatDecimal(86.558) == 87);
//        Assertion.run(formatDecimal(86.258) == 87); // throwing an assertion error...
    }

    public static long formatDecimal(double num){
        long result = Math.round(num);
        System.out.println(num + " rounded to " + result);
        return result;
    }
}

