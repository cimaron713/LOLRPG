package champion;

public class Jungle extends Champion {
    public int defense;
    public Jungle(String name, int price, int defense) {
        super(name, price);
        this.defense = defense;
    }
}
