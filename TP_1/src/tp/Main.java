package tp;

import java.util.Random;
import java.util.Scanner;

import tp.visualisation.echec.Jeu;

public class Main {
    public static String saisie(String prompte, int rapid){
        System.out.print(prompte);
        if (rapid == 0){
            return ("Rapid");
        }
        Scanner name = new Scanner(System.in);
        return name.next();
    }

    public static String[]  choiceWhite(String name1, String name2){
        String[] tab = new String[2];
        if (new Random().nextBoolean()){
            tab[0] = name1;
            tab[1] = name2;
        }
        else {
            tab[1] = name1;
            tab[0] = name2;
        }
        return tab;
    }
    public static void main(String[] args) {
        System.out.println("Bien venue sur mon super jeu d'echecs...");
        String j1 = saisie("Joueur 1 : ", 0);
        String j2 = saisie("\nJoueur 2 : ", 0);
        System.out.println("Bien venue " + j1 + " et " + j2);
        Jeu game = new Jeu(choiceWhite(j1, j2));
        while (true){
            game.dessinePlateau();
            
        }
    }
}