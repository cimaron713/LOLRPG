package team;

import java.util.Random;

public class Enemy extends Team{
    public Enemy(String name, int attackDamage, int maxHp, int hp, int defense, int money, int avoidance){
        super(name, attackDamage, maxHp, hp, defense, money, avoidance);
    }

    public int attack(Player opponent){
        System.out.println(name + " 이(가) " + opponent.name + " 를 공격했다!");
        Random r = new Random();
        if(r.nextInt(100) < opponent.avoidance){
            System.out.println(opponent.name + " 이 공격을 회피했다!\n");
            return 0;
        }
        else if(attackDamage-opponent.defense < 0){
            System.out.println(opponent.name + "의 방어력이 높아 데미지를 입히지 못했다!\n");
            return 0;
        }
        else{
            System.out.println(attackDamage-opponent.defense + " 의 데미지를 입혔다!\n");
            return attackDamage-opponent.defense;
        }
    }
}
