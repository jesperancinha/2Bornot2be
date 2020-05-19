package org.jesperancinha.jtd;


public class InstanceOf {

    public static void main(String[] args) {
        final Object cat = "Bob cat";
        final Object cat2 = "Lynx";

        if(cat instanceof String  s && s.equals("Bob cat")){
            System.out.println("This is a bob cat!");
        }

        if(cat instanceof String  s && s.length() == 7){
            System.out.println("We've written the bob cat sentence with enough characters!");
        }

        if(cat2 instanceof String s && s.equals("Lynx")){
            System.out.println("This is a Lynx");
        }

        if(cat2 instanceof String s && s.length() == 4){
            System.out.println("Indeed, we write Lynx with 4 letters");
        }
    }
}
