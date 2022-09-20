package tp.visualisation.echec;

import princeton.StdDraw;

public class Jeu {
    public int Yfenetre;
    public int Xfenetre;
    public Gamer joueurBlanc;
    public Gamer joueurNoir;
    public Jeu(String[] tab){
        joueurBlanc = new Gamer(tab[0], 0);
        joueurNoir = new Gamer(tab[1], 1);
        System.out.println("\nLe Joueur Blanc est : " + tab[0] + "\nLe Joueur Noir est  : " + tab[1]);
        Yfenetre = 500;
        Xfenetre = 500;
        princeton.StdDraw.setCanvasSize(Xfenetre, Yfenetre);
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
    //    System.out.println("une unite x ou y jsp = "+result);
        return result;
    }
    public void placerToutesLesPieces(){
        this.joueurNoir.placerLesPieces();
        this.joueurBlanc.placerLesPieces();
    }
    public void dessineToutsLesPieces(){
        for (int i = 0; i < 16; i++){
            this.joueurBlanc.pieces[i].placement();
            this.joueurNoir.pieces[i].placement();
//                  princeton.StdDraw.show(25);
        }
    }
    public void dessinePlateau(int option) {
        int i = 0;
        int compteur = 0;
        int j = 0;
        int test = this.Xfenetre/adjustementSize(this.Xfenetre);
        princeton.StdDraw.setXscale(0, test);
        test = this.Yfenetre/adjustementSize(this.Yfenetre);
        princeton.StdDraw.setYscale(0, test);
        while (i < 64) {
            if ((i % 8) == 0 && i != 0){
                j++;
                compteur = 0;
            }
            if (((compteur % 2 == 0) && j % 2 == 0) || compteur % 2 == 1 && j % 2 == 1){
                princeton.StdDraw.setPenColor(StdDraw.DARK_GRAY);
            }else {
                princeton.StdDraw.setPenColor(StdDraw.RED);
            }
            princeton.StdDraw.filledSquare(0.5+compteur, 0.5+j, 0.5);
            compteur++;
            i++;
//            princeton.StdDraw.show(25);
        }
        if (option == 0){
            dessineToutsLesPieces();
        }
    }
    public int[] attenderClick() {
        while (! StdDraw.isMousePressed() ){
//            System.out.println("X = "+princeton.StdDraw.mouseX()+" | Y = "+princeton.StdDraw.mouseY());
            StdDraw.pause(100);
        }
        int xmouse = (int)Math.floor(princeton.StdDraw.mouseX());
        int ymouse = (int)Math.floor(princeton.StdDraw.mouseY());
        while ( StdDraw.isMousePressed() ){
//            System.out.println("END= X = "+princeton.StdDraw.mouseX()+" | Y = "+princeton.StdDraw.mouseY());
            StdDraw.pause(100);
        }
        if (xmouse != (int)Math.floor(princeton.StdDraw.mouseX()) || ymouse != (int)Math.floor(princeton.StdDraw.mouseY())){
            return attenderClick();
        }
        return (new int[]{xmouse, ymouse});
    }
    private void drawCircle(int mouseX, int mouseY){
        StdDraw.setPenRadius(0.1);
        princeton.StdDraw.setPenColor(StdDraw.BLUE);
        princeton.StdDraw.point(mouseX+.5, mouseY+.5);
        princeton.StdDraw.circle(mouseX+.5, mouseY+.5, 0.1);

    }
    //return 0 si il trouve rien sinon un nbr entre 1 et 18 si blanc ou -1 et 18 si noir, à ne pas oublier faire -1 pour []
    public int findPieces(int mouseX, int mouseY){
        int i = 0;
        while (i < 16){
            if (this.joueurBlanc.pieces[i].x == mouseX && this.joueurBlanc.pieces[i].y == mouseY){
                return (i+1);
            }else if (this.joueurNoir.pieces[i].x == mouseX && this.joueurNoir.pieces[i].y == mouseY){
                return ((i+1)*-1);
            }
            i++;
        }
        return 0;
    }
    public void selectionPiece(){
        int[] tab = attenderClick();
        int pieceSelection = findPieces(tab[0], tab[1]);
        int newXPiece;
        int newYPiece;
        while (pieceSelection == 0){
            tab = attenderClick();
            pieceSelection = findPieces(tab[0], tab[1]);
        }
        if (pieceSelection > 0){
            System.out.println("Tu as choisi la piece \""+this.joueurBlanc.pieces[pieceSelection-1].name);
        }else {
            System.out.println("Tu as choisi la piece \""+this.joueurNoir.pieces[(pieceSelection*-1)-1].name);
        }
        dessinePlateau(1);
        drawCircle(tab[0], tab[1]);
        dessineToutsLesPieces();
        //faire deplacer les piece et manger les adverser
        selectionneCible(pieceSelection);
        }
        public boolean eat(int attaquant, int deffenseur){
            //return !(((deffenseur < 0 && attaquant < 0) || (deffenseur > 0 && attaquant > 0)));
            if (((deffenseur < 0 && attaquant < 0) || (deffenseur > 0 && attaquant > 0))) {
                return (false);
            }
            return (true);
        }
        public void selectionneCible(int pieceChoisi){
            int[] mouseXY = attenderClick();
            int newPosition = findPieces(mouseXY[0], mouseXY[1]);
            if (newPosition == pieceChoisi){
                System.out.println("Tu desselection la piece.\n---------------------------------------");
                return;
            }
            while (!(eat(pieceChoisi, newPosition))){
                mouseXY = attenderClick();
                newPosition = findPieces(mouseXY[0], mouseXY[1]);
                if (newPosition == pieceChoisi){
                    System.out.println("Tu desselection la piece.\n---------------------------------------");
                    return;
                }
            }
            if (newPosition != 0){
                if (newPosition < 0) {
                    System.out.println(this.joueurNoir.pieces[(newPosition*-1)-1].name+" est mort !!!");
                    this.joueurNoir.pieces[(newPosition*-1)-1].dead();
                }else {
                    System.out.println(this.joueurBlanc.pieces[newPosition-1].name+" est mort !!!");
                    this.joueurBlanc.pieces[newPosition-1].dead();
                }
            }
            if (pieceChoisi < 0){
                System.out.println(this.joueurNoir.pieces[(pieceChoisi*-1)-1].name+" passe de : [x = "+this.joueurNoir.pieces[(pieceChoisi*-1)-1].x+ " | y = "+this.joueurNoir.pieces[(pieceChoisi*-1)-1].y+"] à [ x = "+ mouseXY[0]+"| y = "+mouseXY[1]+"]");
                this.joueurNoir.pieces[(pieceChoisi*-1)-1].x = mouseXY[0];
                this.joueurNoir.pieces[(pieceChoisi*-1)-1].y = mouseXY[1];
            }else {
                System.out.println(this.joueurBlanc.pieces[pieceChoisi-1].name+" passe de : [x = "+this.joueurBlanc.pieces[pieceChoisi-1].x+ " | y = "+this.joueurBlanc.pieces[pieceChoisi-1].y+"] à [ x = "+ mouseXY[0]+"| y = "+mouseXY[1]+"]");
                this.joueurBlanc.pieces[pieceChoisi-1].x = mouseXY[0];
                this.joueurBlanc.pieces[pieceChoisi-1].y = mouseXY[1];
            }
        }
}