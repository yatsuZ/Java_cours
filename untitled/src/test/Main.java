package test;

import java.util.Scanner;//bibliotheque pour scaner

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        //sa
/*
        for (String arg: args){
            System.out.println(args);
        }
*/
        //OU Sa
        if (args.length >= 1) {
            int i;

            i = 0;
            while (i < args.length)
            {
                System.out.println(args[i++]);
            }
        }
        System.out.println("Pour prendre en inpute du texte il faut \nScaner\n");
        System.out.print("test : ");
        Scanner clavier = new Scanner(System.in);
        int age = clavier.nextInt();
        System.out.printf("Vous avez entre commre nombre : ");
        System.out.println(age);
    }
}