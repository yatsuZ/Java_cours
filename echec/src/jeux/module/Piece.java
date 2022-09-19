package jeux.module;

public class Piece {
    private String Apparence;
    private int Team;
    public Piece(String App, int T){
        Apparence = App;
        Team = T%2;
    }

    public String getApparence() {
        return Apparence;
    }

    public int getTeam() {
        return Team;
    }
    public void thisTeam(){
        if (Team == 0){
            System.out.println("Apartien aux J1");
        } else {
            System.out.println("Apartien aux J2");
        }
    }
}
