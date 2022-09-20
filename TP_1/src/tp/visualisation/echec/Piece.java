package tp.visualisation.echec;

public class Piece {
    String  name;
    public int Alive;
    public int     x;
    public int     y;
    int     blackWhite;
    String  pathPng;
    public int findTeam(int nbr){
        if (nbr % 2 == 0){
            return (1);
        }
        return (-1);
    }
    public void oppose(){
        if (this.y == 0){
            this.y = 7;
        }else {
        this.y = 6;
        }
    }
    public void placement(){
        princeton.StdDraw.picture(this.x+0.5, this.y+0.5, this.pathPng, 1, 1);
    }

    public Piece(String name, int x, int blackWhite){
        String path = "./tp/visualisation/echec/images/" + name;
        this.Alive = 1;
        this.x = x;
        this.y = 0;
        if (name.equals("P")){
            this.y = 1;
        }
        this.blackWhite = findTeam(blackWhite);
        if (this.blackWhite == 1){
            name += "b";
            path += "b.png";
        }else{
            name += "n";
            path += "n.png";
            oppose();
        }
        if (name.equals("Pb") || name.equals("Pn")){
            name += x;
        }else{
            if (x < 3){
                name += 1;
            }else if (x > 4){
                name += 2;
            }
        }
        this.pathPng = path;
        this.name = name;
//        System.out.println(this.x);
    }
    public void dead(){
        this.Alive = 0;
        this.x += 18;
        this.y += 18;
    }
}

