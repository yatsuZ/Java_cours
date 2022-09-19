package jeux;
import jeux.module.*;
//cree un jeux d'echec
//1 cree plateau
//2 cree la structure de chaque obj
//3 donner la possibilité de jouer
//4 dire condition de fin

public class Main {
    public static void main(String[] args) {
        Piece p = new Piece("\u265F\uFE0F", 0);
        System.out.println(p.getApparence());
        p.thisTeam();
    }
}