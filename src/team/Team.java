package team;

public class Team {
    public String name; // 이름
    public int attackDamage; // 공격력
    public int maxHp; // 최대체력
    public int hp; //현제 체력
    public int defense; // 방어력
    public int money; // 돈
    public int avoidance; // 회피율

    public Team(String name, int attackDamage, int maxHp, int hp, int defense, int money, int avoidance){
        this.name = name;
        this.attackDamage = attackDamage;
        this.maxHp = maxHp;
        this.hp = hp;
        this.defense = defense;
        this.money = money;
        this.avoidance = avoidance;
    }

    public int attack(Team opponent){ // 공격
        return attackDamage-defense; // 공격 공식, 공격력 - 방어력
    };
}
