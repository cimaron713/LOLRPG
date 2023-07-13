package team;

import java.util.Random;

public class Gen extends Enemy { // 매 턴마다 체력 회복
    public int num = 1;
    public Gen(String name, int attackDamage, int maxHp, int hp, int defense, int money, int avoidance){
        super(name, attackDamage, maxHp, hp, defense, money, avoidance);
    }

    public void recovery(Gen gen){
        gen.hp += 100;
    }

}
