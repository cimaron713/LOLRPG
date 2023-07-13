package team;

import java.util.Random;

public class DK extends Enemy{ // 죽으면 1회 부활
    public int reviveNum = 1;
    public int num = 1;
    public DK(String name, int attackDamage, int maxHp, int hp, int defense, int money, int avoidance){
        super(name, attackDamage, maxHp, hp, defense, money, avoidance);

    }

    public void revive(){
        hp = 250;
    }
}
