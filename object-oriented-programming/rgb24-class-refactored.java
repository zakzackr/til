// refactored rgb24 class following contract

public class Main {

    public static void main(String[] args) {
        RGB24 color1 = new RGB24(0, 153, 255);
        RGB24 color2 = new RGB24("ff99cc");//rgb(255, 153, 204)
        RGB24 color3 = new RGB24("100110011111111100110011");//rgb(153, 255, 51)
        RGB24 grey = new RGB24("7b7b7b");//rgb(123, 123, 123)

        System.out.println(color1);
        System.out.println(color2);
        System.out.println(color3);
        System.out.println(grey);
    }
}
class RGB24{
    private String rgbHex;

    public RGB24(int red, int green, int blue){
        this.rgbHex = String.format("%02x%02x%02x", red, green, blue);
//        this.rgbHex = Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
    }

    public RGB24(String inputString){
        int l = inputString.length();

        if(l == 6) this.setColorsByHex(inputString);
        else if(l == 24) this.setColorsByBin(inputString);
        else this.setAsBlack();
    }

    public void setColorsByHex(String hex){
        if(hex.length() != 6) this.setAsBlack();
        else this.rgbHex = hex;
    }

    public void setColorsByBin(String bin){
        if(bin.length() != 24) this.setAsBlack();
        else{
            int red = Integer.parseInt(bin.substring(0, 8), 2);
            int green = Integer.parseInt(bin.substring(8, 16), 2);
            int blue = Integer.parseInt(bin.substring(16, 24), 2);

            this.rgbHex = String.format("%02x%02x%02x", red, green, blue);
        }
    }

    public void setAsBlack(){
        this.rgbHex = "000000";
    }

    public String getHex(){
        return rgbHex;
    }

    public String getBits(){
        return Integer.toBinaryString(Integer.parseInt(this.rgbHex, 16));
    }

    public String getColorShade(){
        int red = Integer.parseInt(this.rgbHex.substring(0, 2), 16);
        int green = Integer.parseInt(this.rgbHex.substring(2, 4), 16);
        int blue = Integer.parseInt(this.rgbHex.substring(4, 6), 16);

        if(red == green && green == blue) return "greyscale";
        String[] stringTable = new String[]{"red","green","blue"};
        int[] values = {red, green, blue};

        int max = values[0];
        int maxIndex = 0;
        for(int i = 1; i < values.length; i++){
            if(max <= values[i]){
                max = values[i];
                maxIndex = i;
            }
        }

        return stringTable[maxIndex];
    }

    public String toString(){
        int red = Integer.parseInt(this.rgbHex.substring(0, 2), 16);
        int green = Integer.parseInt(this.rgbHex.substring(2, 4), 16);
        int blue = Integer.parseInt(this.rgbHex.substring(4, 6), 16);

        return "The color is rgb(" + red + "," + green + "," + blue + "). Hex: " + this.getHex() + ", binary: " + this.getBits();
    }
}

