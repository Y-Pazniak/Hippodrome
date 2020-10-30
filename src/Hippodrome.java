import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public List getHorses(){
        return horses;
    }

    public void run(){
        for(int a = 0; a < 100; a++){
            move();
            print();
            try{
                Thread.sleep(200);}
            catch (InterruptedException exc){exc.printStackTrace();}
        }
    }

    public void move(){
        List<Horse> horses = getHorses();
        for(Horse horse : horses){
            horse.move();
        }
    }

    public void print(){
        List<Horse> horses = getHorses();
        for(Horse horse : horses){
            horse.print();
        }
        for(int a = 0; a < 10; a++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        double maxDistance = 0;
        List<Horse> horses = getHorses();
        Horse winner = null;
        for(Horse horse : horses){
            if(horse.getDistance() > maxDistance){
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("(1)\uD83D\uDC0E", 3, 0));
        game.horses.add(new Horse("(2)\uD83D\uDC0E", 3, 0));
        game.horses.add(new Horse("(3)\uD83D\uDC0E", 3, 0));
        game.run();
        game.printWinner();
    }
}
