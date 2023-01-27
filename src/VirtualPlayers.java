public class VirtualPlayers {
    VirtualPlayer virtualPlayers[];
    VirtualPlayers(int n){
        VirtualPlayer arrayVirtualPlayer[] = new VirtualPlayer[n];
        for (int i = 0; i < n; i++){
            arrayVirtualPlayer[i] = new VirtualPlayer();
        }
        this.virtualPlayers = arrayVirtualPlayer;
    }
}
