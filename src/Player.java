public class Player {
    protected String name;
    protected int point;
    Player(){
        this.point =  0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public int DiceRoll(){
        int n = (int) (Math.random() * 4) + 1;
        int f = Dice.DiceNumber(n);
        System.out.printf(" Mặt xúc xắc là: %d", f);
        return f;
    }
}
