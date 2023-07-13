package champion;

public class Bot extends Champion{
    public int avoidance;

    public Bot(String name, int price, int avoidance) {
        super(name, price);
        this.avoidance = avoidance;
    }
}