package tp.visualisation.echec;

import princeton.StdDraw;

public class Jeu {
    public Gamer joueurBlanc;
    public Gamer joueurNoir;
    public Jeu(String[] tab){
        joueurBlanc = new Gamer(tab[0], 0);
        joueurNoir = new Gamer(tab[1], 1);
        System.out.println("\nLe Joueur Blanc est : " + tab[0] + "\nLe Joueur Noir est  : " + tab[1]);
        placerToutesLesPieces();
    }
    public int adjustementSize(int size){
        int i = size;
        int result = 8;
        while (i != 0){
            if (size / i == 8) {
                result = i;
            }
            i--;
        }
        System.out.println("une unite x ou y jsp = "+result);
        return result;
    }
    public void placerToutesLesPieces(){
        this.joueurNoir.placerLesPieces();
        this.joueurBlanc.placerLesPieces();
    }
    public void dessinePlateau() {
        int Yfenetre = 500;
        int Xfenetre = 500;
        int i = 0;
        int compteur = 0;
        int j = 0;
        princeton.StdDraw.setCanvasSize(Xfenetre, Yfenetre);
        int test = Xfenetre/adjustementSize(Xfenetre);
        princeton.StdDraw.setXscale(0, test);
        test = Yfenetre/adjustementSize(Yfenetre);
        princeton.StdDraw.setYscale(0, test);
        while (i < 64) {
            if ((i % 8) == 0 && i != 0){
                j++;
                compteur = 0;
            }
            if (((compteur % 2 == 0) && j % 2 == 0) || compteur % 2 == 1 && j % 2 == 1){
                princeton.StdDraw.setPenColor(StdDraw.DARK_GRAY);
            }else {
                princeton.StdDraw.setPenColor(StdDraw.WHITE);
            }
            princeton.StdDraw.filledSquare(0.5+compteur, 0.5+j, 0.5);
            compteur++;
            i++;
        }
        for (i = 0; i < 16; i++){
            this.joueurBlanc.pieces[i].placement();
            this.joueurNoir.pieces[i].placement();
        }
//        princeton.StdDraw.picture(0.5, 6.5,"./tp/visualisation/echec/images/Pb.png", 1, 1);
//        Pion b = new Pion(0, 0);
//        Tour n = new Tour(7, 0);
//        System.out.println(b.name);
//        System.out.println(n.name);
//        Cavalier c = new Cavalier(1, 0);
//        System.out.println(c.name);
    }
}