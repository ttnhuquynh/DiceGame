import java.util.Scanner;

public class Referee {
    protected  int numberRealPlayers;
    protected int numberOfPlayers;
    protected RealPlayer RealPlayers[];
    protected VirtualPlayer VirtualPlayers[];
    protected Player winner;
    protected int win;

    Referee(int numberRealPlayers, RealPlayer RealPlayers[],VirtualPlayer VirtualPlayers[], int numberOfPlayers ){
        this.numberRealPlayers = numberRealPlayers;
        this.RealPlayers = RealPlayers;
        this.VirtualPlayers = VirtualPlayers;
        this.win = 0;
        this.numberOfPlayers = numberOfPlayers;
    }
    public int Start(){
        int firstPlayer = (int)Math.floor(Math.random() * numberOfPlayers );
        return firstPlayer;
    }

    public int nextPlayer(int n){
        if(n >= numberOfPlayers - 1) n = 0;
        else n++;
        return n;
    }

    public void printCurrentPlayer(){
        for(int j = 0; j < numberRealPlayers; j++) {
            System.out.printf(" %s %d\n", RealPlayers[j].getName(), RealPlayers[j].getPoint());
        }

        for(int j = 0; j < numberOfPlayers - numberRealPlayers; j++) {
            System.out.printf(" %s %d\n", VirtualPlayers[j].getName(), VirtualPlayers[j].getPoint());
        }
    }

    public void Play(){
        int first = Start();
        System.out.printf("\nLượt đầu random người chơi: %s", first >= numberRealPlayers ? VirtualPlayers[first-numberRealPlayers].getName() : RealPlayers[first].getName());

        if( first >= numberRealPlayers){
            VirtualPlayer nextP = VirtualPlayers[first-numberRealPlayers];
            int roll = nextP.DiceRoll();
           setPointForVirtualPlayer(nextP, roll);

        }
        else{
            RealPlayer nextP = RealPlayers[first];
            int roll = nextP.DiceRoll();
            setPointForRealPlayer(nextP, roll);
        }

        System.out.print("\n");
        printCurrentPlayer();

        int player = first;
        while(win == 0){
            player = nextPlayer(player);
            System.out.printf("Người chơi hiện tại là: %s", player >= numberRealPlayers ? VirtualPlayers[player-numberRealPlayers].getName() : RealPlayers[player].getName());
            if(player < numberRealPlayers) {
                System.out.println(". Nhấn ENTER để lăn xúc xắc");
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }
            if( player >= numberRealPlayers){
                VirtualPlayer nextP = VirtualPlayers[player-numberRealPlayers];
                int roll = nextP.DiceRoll();
                setPointForVirtualPlayer(nextP, roll);

            }
            else{
                RealPlayer nextP = RealPlayers[player];
                int roll = nextP.DiceRoll();
                setPointForRealPlayer(nextP, roll);
            }

            System.out.print("\n");
            printCurrentPlayer();
        }
    }

    public void setPointForRealPlayer(RealPlayer player, int DiceRoll){
        int currentPoint = player.getPoint() + DiceRoll;
        if(currentPoint == 10) {
            winner = (RealPlayer)player;
            player.setPoint(10);
            System.out.printf("\n-----Winner: %s------", player.getName());
            win = 1;
        }
        else if (currentPoint > 10){
            player.setPoint(0);
        }
        else {
            player.setPoint(player.getPoint() + DiceRoll);
        }

    }

    public void setPointForVirtualPlayer(VirtualPlayer player, int DiceRoll){
        int currentPoint = player.getPoint() + DiceRoll;
        if(currentPoint == 10){
            winner = (VirtualPlayer)player;
            player.setPoint(10);
            System.out.printf("\n-----Winner: %s------", player.getName());
            win = 1;
        }
        else if (currentPoint > 10){
            player.setPoint(0);
        }
        else {
            player.setPoint(player.getPoint() + DiceRoll);
        }

    }
}
