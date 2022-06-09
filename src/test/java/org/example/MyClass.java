package org.example;

public class MyClass {

    public String reverseString(String s) {

        char[] character = s.toCharArray();
        int i=0;
        int j = s.length()-1;
        while(i<j)
        {
            char temp=character[i];
            character[i++]=character[j];
            character[j--] = temp;
        }

        return new String(character);

    }

    public static void main(String args[]) {
        MyClass cl =  new MyClass();
        System.out.println(cl.reverseString("hello"));

    }
}