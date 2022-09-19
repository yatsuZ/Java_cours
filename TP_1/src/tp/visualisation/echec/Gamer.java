package tp.visualisation.echec;

public class Gamer {
    public Piece[] pieces = new Piece[16];
    String name;
    String equipe;

    int couleur;
    public Gamer(String n, int t) {
        this.name = n;
        if (t % 2 == 0) {
            this.equipe = "Blanc";
            this.couleur = 0;
        } else {
            this.equipe = "Noir";
            this.couleur = 1;
        }
    }
    public void placerLesPieces(){
        int i = 0;
        while (i < 8){
            this.pieces[i] = new Pion(i, couleur);
            i++;
        }
        i = 0;
        while (i < 8){
            if (i == 0 || i == 7){
                this.pieces[i+8] = new Tour(i, couleur);
            } else if (i == 1 || i == 6) {
                this.pieces[i+8] = new Cavalier(i, couleur);
            } else if (i == 2 || i == 5) {
                this.pieces[i+8] = new Fou(i, couleur);
            } else if (i == 3) {
                this.pieces[i+8] = new Dame(i, couleur);
            }else {
                this.pieces[i+8] = new Roi(i, couleur);
            }
            i++;
        }
    }
}
