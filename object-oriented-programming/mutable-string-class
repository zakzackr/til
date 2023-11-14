// As string objects are immutable, it is sometimes inconvenient to make some changes to string objects.
// This MutableString class will act as a container of a string object and allow you to modify the original string.

// Java provides the StringBuilder class to modify the original string.

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MutableString mutableStr = new MutableString("hello");
        mutableStr.setString("Hello");
        System.out.println(mutableStr.getString());  // Hello

        mutableStr.concat(" World");
        System.out.println(mutableStr.getString());  // Hello World
        mutableStr.append('!');
        System.out.println(mutableStr.getString());  // Hello World!

        MutableString mutableStr2 = mutableStr.substring(6, 11);
        System.out.println(mutableStr2.getString());  // World
        System.out.println(mutableStr.getString());  // Hello World!

        System.out.println(mutableStr2.length());  // 5

        char[] cArr = {' ', '!', '!'};
        mutableStr2.concat(cArr);
        System.out.println(mutableStr2.getString());

        MutableString mutableStr3 = new MutableString("Hello");
        mutableStr3.concat(mutableStr2);
        System.out.println(mutableStr3.getString());
    }
}

class MutableString{
    private ArrayList<Character> string;

    public MutableString(ArrayList<Character> string){
        this.string = string;
    }

    public MutableString(String string){
        this.string = new ArrayList<>();

        for (int i = 0; i < string.length(); i++){
            this.string.add(string.charAt(i));
        }
    }

    public String getString(){
        String str = "";
        for (int i = 0; i < string.size(); i++){
            str += string.get(i);
        }

        return str;
    }

    public void setString(String str){
        this.string = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            this.string.add(str.charAt(i));
        }
    }

    public void append(char c){
        string.add(c);
    }

    public MutableString substring(int start){
        ArrayList<Character> newString = new ArrayList<>(string.subList(start, string.size()));
        return new MutableString(newString);
    }

    public MutableString substring(int start, int end){
        ArrayList<Character> newString = new ArrayList<>(string.subList(start, end));
        return new MutableString(newString);
    }

    public void concat(char[] cArr){
        for (char c: cArr){
            string.add(c);
        }
    }

    public void concat(String stringInput){
        for (int i = 0; i < stringInput.length(); i++){
            string.add(stringInput.charAt(i));
        }
    }

    public void concat(MutableString stringInput){
        ArrayList<Character> arrInput = stringInput.string;
        for (int i = 0; i < arrInput.size(); i++){
            string.add(arrInput.get(i));
        }
    }

    public int length(){
        return string.size();
    }
}
