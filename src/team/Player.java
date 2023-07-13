package team;
import champion.*;

import java.util.Random;
import java.util.ArrayList;

public class Player extends Team { // Player
    public Top top; // 탑
    public Jungle jungle; // 정글
    public Mid mid; // 미드
    public Bot bot; // 바텀
    public ArrayList<Top> tops;
    public ArrayList<Jungle> jungles;
    public ArrayList<Mid> mids;
    public ArrayList<Bot> bots;

    public int stageNum = 1; // 스테이지 정보

    public int life = 3; // 남은 생명
    public Player(String name, int attackDamage, int maxHp, int hp, int defense, int money, int avoidance,
                  Top top, Jungle jungle, Mid mid, Bot bot, ArrayList<Top> tops, ArrayList<Jungle> jungles, ArrayList<Mid> mids, ArrayList<Bot> bots){
        super(name, attackDamage, maxHp, hp, defense, money, avoidance);
        this.top = top;
        this.jungle = jungle;
        this.mid = mid;
        this.bot = bot;
        this.tops = tops;
        this.jungles = jungles;
        this.mids = mids;
        this.bots = bots;
    }

    public int attack(Team opponent){
        System.out.println(name + " 이(가) " + opponent.name + " 를 공격했다! ");
        Random r = new Random();
        if(r.nextInt(100) < opponent.avoidance){
            System.out.println(" 상대가 공격을 회피했다! \n");
            return 0;
        }
        else if(attackDamage-opponent.defense < 0){
            System.out.println("상대의 방어력이 높아 데미지를 입히지 못했다...\n");
            return 0;
        }
        else{
            System.out.println(attackDamage-opponent.defense + " 의 데미지를 입혔다! \n");
            return attackDamage-opponent.defense;
        }
    }


    public void equipTop(Top top){
        this.top = top;
        maxHp = top.hp;
        hp = top.hp;
    }
    public void equipJungle(Jungle jungle){
        this.jungle = jungle;
        defense = jungle.defense;
    }
    public void equipMid(Mid mid){
        this.mid = mid;
        attackDamage = mid.attackDamage;
    }
    public void equipBot(Bot bot){
        this.bot = bot;
        avoidance = bot.avoidance;
    }

    public void unEquipTop(Top top){
        this.top = top;
        maxHp = top.hp;
        hp = top.hp;
    }
    public void unEquipJungle(Jungle jungle){
        this.jungle = jungle;
        defense = jungle.defense;
    }
    public void unEquipMid(Mid mid){
        this.mid = mid;
        attackDamage = mid.attackDamage;
    }
    public void unEquipBot(Bot bot){
        this.bot = bot;
        avoidance = bot.avoidance;
    }
}
