package team;
import java.util.Random;
public class T1 extends Enemy { // 회피 가능
    public int num = 1;
    public T1(String name, int attackDamage, int maxHp, int hp, int defense, int money, int avoidance){
        super(name, attackDamage, maxHp, hp, defense, money, avoidance);
    }
}