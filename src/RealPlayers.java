import java.util.Scanner;
public class RealPlayers {
   RealPlayer realPlayers[];
   RealPlayers(int n){
        RealPlayer arrayRealPlayer[] = new RealPlayer[n];
        Scanner sc = new Scanner((System.in));
        for( int i = 0; i < n; i++) {
            System.out.printf("Nhap ten nguoi choi thu %d: ", i + 1);
            String name = sc.nextLine();
            System.out.printf("\nTen nguoi choi thu %d la: %s \n", i + 1,name );
            arrayRealPlayer[i] = new RealPlayer(name);
        }
        this.realPlayers = arrayRealPlayer;
    }
}
