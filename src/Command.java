import java.util.Scanner;
public class Command {
    public int numberOfRealPlayer;
    public Command(int numberOfPlayers ) {
        Display(numberOfPlayers);
    }
    public void Display(int numberOfPlayers) {
        System.out.printf("Nhập số  người chơi (tối đa %d người): ", numberOfPlayers);
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num > numberOfPlayers || num < 0) {
            System.out.printf("Nhập số  người chơi (tối đa %d người): ", numberOfPlayers);
            num = sc.nextInt();
        }

        numberOfRealPlayer = num;
        System.out.printf("Số  người chơi: %d\n", numberOfRealPlayer);

        RealPlayers realPlayers = new RealPlayers(numberOfRealPlayer);
        for (int j = 0; j < numberOfRealPlayer; j++) {
            System.out.printf(" %s %d\n", realPlayers.realPlayers[j].getName(), realPlayers.realPlayers[j].getPoint());
        }

        VirtualPlayers virtualPlayers = new VirtualPlayers(numberOfPlayers - numberOfRealPlayer);
        for (int j = 0; j < numberOfPlayers - numberOfRealPlayer; j++) {
            System.out.printf(" %s %d\n", virtualPlayers.virtualPlayers[j].getName(), virtualPlayers.virtualPlayers[j].getPoint());
        }

        Referee referee = new Referee(numberOfRealPlayer, realPlayers.realPlayers, virtualPlayers.virtualPlayers,  numberOfPlayers);
        referee.Play();
    }
}
