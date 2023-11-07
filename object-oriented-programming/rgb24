class RGB24{
    public int red;
    public int green;
    public int blue;

    public RGB24(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String getHex(){
        String hex = Integer.toHexString(red);
        hex += Integer.toHexString(green);
        hex += Integer.toHexString(blue);

        return hex;
    }

    public String getBits(){
        return Integer.toBinaryString(Integer.parseInt(getHex(), 16));
    }

    // public String getBits(){
    //     String bit = Integer.toBinaryString(red);
    //     bit += Integer.toBinaryString(green);
    //     bit += Integer.toBinaryString(blue);

    //     return bit;
    // }

    public String getColorShade(){
        if (red == green && green == blue) return "grayscale";

        String greatestString = "red";
        int greatest = red;

        if (green > greatest){
            greatestString = "green";
            greatest = green;
        }

        if (blue > greatest){
            greatestString = "blue";
            greatest = blue;
        }

        return greatestString;
    }
}

class Main{
    public static void main(String[] args){
        RGB24 color1 = new RGB24(0, 153, 255);
        RGB24 color2 = new RGB24(255, 153, 204);
        RGB24 color3 = new RGB24(153, 255, 51);
        RGB24 gray = new RGB24(123, 123, 123);

        System.out.println(color1.getHex() + " <-> " + color1.getBits() + ". Color: " + color1.getColorShade());
        System.out.println(color2.getHex() + " <-> " + color2.getBits() + ". Color: " + color2.getColorShade());
        System.out.println(color3.getHex() + " <-> " + color3.getBits() + ". Color: " + color3.getColorShade());
        System.out.println(gray.getHex() + " <-> " + gray.getBits() + ". Color: " + gray.getColorShade());
    }
}
