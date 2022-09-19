package tp.visualisation.echec;

public class Pion extends Piece {
    public Pion(int x, int blackOrWhite) {
        super("P", x, blackOrWhite);
    }
}
/*        String  n = "P";
        String  path;
        this.x = 1;
        if (findTeam(blackOrWhite) == 1){
            path = "./images/Pb.png";
            n = n+"b";
        }else {
            path = "./images/Pn.png";
            n += "n";
            this.x = 6;
        }
        n += y;
        this.y = y;
        super(n, x, y, blackOrWhite, path);*/
