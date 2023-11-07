public class Main {

    public static void main(String[] args) {
        RGB24 color1 = new RGB24(0, 153, 255);
        RGB24 color2 = new RGB24("ff99cc"); //rgb(255, 153, 204)
        RGB24 color3 = new RGB24("100110011111111100110011"); //rgb(153, 255, 51)
        RGB24 gray = new RGB24("7b7b7b"); //rgb(123, 123, 123)

        System.out.println(color1);
        System.out.println(color2);
        System.out.println(color3);
        System.out.println(gray);

        System.out.println();
        System.out.println("Changing the state of colors");
        System.out.println();

        gray.setAsBlack();
        System.out.println(gray);
        color1.setColorsByHex("2EB656");
        System.out.println(color1);
    }
}

class RGB24{
    public int red;
    public int green;
    public int blue;

    public RGB24(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public RGB24(String inputString){
        int len = inputString.length();

        if (len == 6) setColorsByHex(inputString);
        else if (len == 24) setColorsByBin(inputString);
        else setAsBlack();
    }

    public void setColorsByBin(String bin){
        if (bin.length() != 24) setAsBlack();
        red = Integer.parseInt(bin.substring(0, 8), 2);
        green = Integer.parseInt(bin.substring(8, 16), 2);
        blue = Integer.parseInt(bin.substring(16), 2);
    }

    public void setColorsByHex(String hex){
        if (hex.length() != 6) setAsBlack();
        red = Integer.parseInt(hex.substring(0, 2), 16);
        green = Integer.parseInt(hex.substring(2, 4), 16);
        blue = Integer.parseInt(hex.substring(4), 16);
    }


    public void setAsBlack(){
        red = 0;
        green = 0;
        blue = 0;
    }

    public String getBits(){
        String bits = Integer.toBinaryString(red);
        bits += Integer.toBinaryString(green);
        bits += Integer.toBinaryString(blue);

        return bits;
    }

    public String getHex(){
        return Integer.toHexString(Integer.parseInt(getBits(), 2));
    }

    public String getColorShade(){
        if (red == green && green == blue) return "grayscale";

        int[] rgb = new int[]{red, green, blue};
        String[] rgbString = new String[]{"red", "green", "blue"};

        String greatestString = rgbString[0];
        int greatest = rgb[0];

        for (int i = 1; i < rgb.length; i++){
            if (rgb[i] > greatest){
                greatestString = rgbString[i];
                greatest = rgb[i];
            }
        }

        return greatestString;

//        String greatestString = "red";
//        int greatest = red;
//
//        if (green > greatest){
//            greatestString = "green";
//            greatest = green;
//        }
//
//        if (blue > greatest){
//            greatestString = "blue";
//            greatest = blue;
//        }
//
//        return greatestString;
    }

    public String toString(){
        return "The color is " + getColorShade() + ", rgb(" + red + "," + green + "," + blue + "), hex: " + getHex() + ", binary: " + getBits() + ".";
    }
}

