import team.*;
import java.util.Scanner;
public class Stage {
    Player player;
    // 상대팀
    DK dk = new DK("DK", 150, 1000, 1000, 50, 700, 0);
    T1 t1 = new T1("T1", 150, 1500, 1500, 100, 1000, 30);
    Gen gen = new Gen("GEN G", 200, 2000, 2000, 100, 1000, 0);
    //미니 스테이지 팀
    Enemy mini1 = new Enemy("Mini DK", 100, 500, 500, 200, 300, 0);
    public Stage(Player player){
        this.player = player;
    }
    Scanner sc = new Scanner(System.in);

    Player stageMenu(){
        while(true){
            Shop shop = new Shop(player);
            // 체력 회복
            dk.hp = dk.maxHp;
            t1.hp = t1.maxHp;
            gen.hp = gen.maxHp;
            //
            if(player.stageNum == 4){
                System.out.println("모든 스테이지를 클리어 했다! 우승은 " + player.name + "이다!");
                System.out.println("남은 돈은 " + player.money + "이다! ");
                System.out.println("메인화면으로 돌아간다.");
                break;
            }
            if(player.stageNum == 1 && dk.num == 1){
                System.out.println("───────────────────────────────");
                System.out.println("드디어 첫 번째 스테이지에 왔다. 상대는 DK다. ");
                System.out.println("우선 상점에 가서 챔피언을 사서 경기를 준비하자!");
                System.out.println("[1]. 진행 [2]. 돌아가기");
                System.out.println("───────────────────────────────");
                dk.num -=1;
                int first = sc.nextInt();
                if(first == 1){
                }
                else if(first == 2){
                    break;
                }
                else{
                    System.out.println("올바른 번호를 입력하세요.");
                }
            }

            else if(player.stageNum == 2 && t1.num == 1){
                System.out.println("───────────────────────────────");
                System.out.println("DK를 이겼다. 이번 상대는 T1이다.");
                System.out.println("T1은 공격을 회피를 한다는데...");
                System.out.println("상점에서 팀 정비를 해야겠다!");
                System.out.println("[1]. 진행 [2]. 돌아가기");
                System.out.println("───────────────────────────────");
                t1.num -=1;
                int first = sc.nextInt();
                if(first == 1){
                }
                else if(first == 2){
                    break;
                }
                else{
                    System.out.println("올바른 번호를 입력하세요.");
                }
            }
            else if(player.stageNum == 3 && gen.num == 1){
                System.out.println("───────────────────────────────");
                System.out.println("벌써 마지막 스테이지에 왔다.");
                System.out.println("Gen은 매 턴마다 체력회복을 한다고 한다.");
                System.out.println("준비를 철저히 해야 할 것 같다!");
                System.out.println("[1]. 진행 [2]. 돌아가기");
                System.out.println("───────────────────────────────");
                gen.num -=1;
                int first = sc.nextInt();
                if(first == 1){
                }
                else if(first == 2){
                    break;
                }
                else{
                    System.out.println("올바른 번호를 입력하세요.");
                }
            }


            System.out.println("┌───────────────────────┐");
            System.out.println("│       Stage Menu      │");
            System.out.println("└───────────────────────┘");
            System.out.println("┌───────────────────────┐");
            System.out.println("│       Stage : " + player.stageNum+"       │");
            if(player.stageNum == 1)
                System.out.println("│       Team : DK       │");
            else if(player.stageNum == 2)
                System.out.println("│       Team : T1       │");
            else if(player.stageNum == 3)
                System.out.println("│      Team : Gen       │");
            System.out.println("└───────────────────────┘\n");
            if(player.stageNum == 1)
                System.out.println("DK(체력|공격력|방어력)\n " + dk.hp + " | " + dk.attackDamage + " | " + dk.defense);
            else if(player.stageNum == 2)
                System.out.println("T1(체력|공격력|방어력)\n " + t1.hp + " | " + t1.attackDamage + " | " + t1.defense);
            else if(player.stageNum == 3)
                System.out.println("Gen(체력|공격력|방어력)\n " + gen.hp + " | " + gen.attackDamage + " | " + gen.defense);

            System.out.println("Player(체력|공격력|방어력|회피율)\n" + player.hp + " | " + player.attackDamage + " | " + player.defense+ " | " + player.avoidance);
            System.out.println("1. 진행 2. 미니 스테이지 3. 상점 4. 메인메뉴");
            int menu = sc.nextInt();
            if(menu == 1){
                if(player.life == 0){
                    System.out.println(player.name+" 의 남은 생명이 0입니다. 게임을 종료합니다.");
                    System.out.println("게임 종료");
                    System.exit(0);
                }
                if(player.maxHp == 0){
                    System.out.println(player.name+" 의 체력이 0입니다. 탑 챔피언을 구매하고 다시 진행해 주세요!");
                }
                else if(player.stageNum == 1)
                    stage1();
                else if(player.stageNum == 2)
                    stage2();
                else if(player.stageNum == 3)
                    stage3();
            }
            else if(menu == 2){
                if(player.maxHp == 0){
                    System.out.println(player.name+" 의 체력이 0입니다. 탑 챔피언을 구매하고 다시 진행해 주세요!");
                }
                else{
                    miniStage();
                }
            }
            else if(menu == 3){
                player = shop.mainMenu();
            }
            else if(menu == 4){
                break;
            }
        }
        return player;
    }

    void stage1() {
        int num = 1;
        System.out.println("STAGE 1! \n 상대는 DK다! 전투를 시작한다.\n");
        while (player.hp >= 0 && (dk.hp >= 0 || dk.reviveNum == 1)){
            System.out.println("1. 공격한다. 2. 도망간다.\n");
            int turn = sc.nextInt();
            if(turn == 1);
            else{
                break;
            }
            System.out.println("=========================================");
            System.out.println("                " + num++ +"번째 턴");
            System.out.println("=========================================\n");

            System.out.println("----------------" + player.name + " 의 공격----------------");
            int damage = player.attack(dk);
            dk.hp = dk.hp - damage;
            if(dk.hp > 0)
                System.out.println("현재 DK의 체력은 " + dk.hp + " 이다.\n");

            else if(dk.hp < 0 && dk.reviveNum == 1){
                System.out.println("DK의 체력은 : 0이다. 갑자기 체력이 250으로 부활했다!\n");
                dk.revive();
                dk.reviveNum = 0;
            }

            else if(dk.hp <= 0 && dk.reviveNum == 0){
                System.out.println("DK의 체력이 0이 되었다! "+ player.name + " 는 승리했다.");
                player.stageNum = 2;
                System.out.println("돈 " + dk.money + " 을 획득했다!");
                player.money += dk.money;
                System.out.println("스테이지 메뉴로 돌아간다.\n");
                player.hp = player.maxHp;
                break;
            }

            System.out.println("----------------" + dk.name + " 의 공격----------------");
            damage = dk.attack(player);
            player.hp = player.hp - damage;
            if(player.hp > 0)
                System.out.println("현재 " + player.name + " 의 체력은 " + player.hp + " 이다.\n");

            else if(player.hp <= 0){
                System.out.println(player.name + "의 체력은 0이다. 전투에서 패배했다.");
                System.out.println("스테이지 메뉴로 돌아간다.\n");
                player.life -= 1;
                player.hp = player.maxHp;
                break;
            }
        }

    }

    void stage2() {
        int num = 1;
        System.out.println("STAGE 2! \n 상대는 T1이다! 전투를 시작한다.\n");
        while (player.hp >= 0 && t1.hp >= 0){
            System.out.println("1. 공격한다. 2. 도망간다.\n");
            int turn = sc.nextInt();
            if(turn == 1);
            else{
                break;
            }
            System.out.println("=========================================");
            System.out.println("                " + num++ +"번째 턴");
            System.out.println("=========================================\n");
            System.out.println("----------------" + player.name + " 의 공격----------------");
            int damage = player.attack(t1);
            t1.hp = t1.hp - damage;
            if(t1.hp > 0)
                System.out.println("현재 T1의 체력은 " + t1.hp + " 이다.\n");

            else if(t1.hp <= 0){
                System.out.println("T1의 체력이 0이 되었다! "+ player.name + " 는 승리했다.");
                player.stageNum = 3;
                System.out.println("돈 " + t1.money + " 을 획득했다!");
                player.money += t1.money;
                System.out.println("스테이지 메뉴로 돌아간다.\n");
                player.hp = player.maxHp;
                break;
            }

            System.out.println("----------------" + t1.name + " 의 공격----------------");
            damage = t1.attack(player);
            player.hp = player.hp - damage;
            if(player.hp > 0)
                System.out.println("현재 " + player.name + " 의 체력은 " + player.hp + " 이다.\n");

            else if(player.hp <= 0){
                System.out.println(player.name + "의 체력은 0이다. 전투에서 패배했다.");
                System.out.println("스테이지 메뉴로 돌아간다.\n");
                player.life -= 1;
                player.hp = player.maxHp;
                break;
            }
        }



    }

    void stage3() {
        int num = 1;
        System.out.println("STAGE 3! \n 상대는 Gen이다! 전투를 시작한다.\n");
        while (player.hp >= 0 && gen.hp >= 0){
            System.out.println("1. 공격한다. 2. 도망간다.\n");
            int turn = sc.nextInt();
            if(turn == 1);
            else{
                break;
            }
            System.out.println("=========================================");
            System.out.println("                " + num++ +"번째 턴");
            System.out.println("=========================================\n");
            if(num != 1){
                if(gen.hp < gen.maxHp){
                    if(gen.hp + 100 > gen.maxHp){
                        System.out.println("앗! Gen이 체력 " + (gen.maxHp-gen.hp) + "을 회복했다!");
                        gen.hp = gen.maxHp;
                        System.out.println("Gen의 현재 체력은 " + gen.hp + "이다.\n");
                    }

                    else{
                        System.out.println("앗! Gen이 체력 100을 회복했다!");
                        gen.hp += 100;
                        System.out.println("Gen의 현재 체력은 " + gen.hp + "이다.\n");
                    }
                }

            }

            System.out.println("----------------" + player.name + " 의 공격----------------");
            int damage = player.attack(gen);
            gen.hp = gen.hp - damage;
            if(gen.hp > 0)
                System.out.println("현재 gen의 체력은 " + gen.hp + " 이다.\n");

            else if(gen.hp <= 0){
                System.out.println("Gen의 체력이 0이 되었다! "+ player.name + " 는 승리했다.");
                player.stageNum = 4;
                System.out.println("돈 " + gen.money + " 을 획득했다!");
                player.money += gen.money;
                System.out.println("스테이지 메뉴로 돌아간다.\n");
                player.hp = player.maxHp;
                break;
            }

            System.out.println("----------------" + gen.name + " 의 공격----------------");
            damage = gen.attack(player);
            player.hp = player.hp - damage;
            if(player.hp > 0)
                System.out.println("현재 " + player.name + " 의 체력은 " + player.hp + " 이다.\n");

            else if(player.hp <= 0){
                System.out.println(player.name + "의 체력은 0이다. 전투에서 패배했다.");
                System.out.println("스테이지 메뉴로 돌아간다.\n");
                player.life -= 1;
                player.hp = player.maxHp;
                break;
            }
        }
    }

    void miniStage(){
        System.out.println("==============================");
        System.out.println("미니 스테이지 입니다!");
        System.out.println("여기서 돈을 벌 수 있습니다.");
        System.out.println("단, 여기서 감소된 체력은 회복되지 않습니다.");
        System.out.println("==============================");

        System.out.println("1. 진입 2. 돌아가기");
        int miniMenu = sc.nextInt();
        if(miniMenu == 1){
            int miniNum = 1;
            System.out.println("MINI STAGE! \n 전투를 시작한다.\n");
            while (player.hp >= 0 && mini1.hp >= 0){
                System.out.println("=========================================");
                System.out.println("                " + miniNum++ +"번째 턴");
                System.out.println("=========================================\n");
                System.out.println("----------------" + player.name + " 의 공격----------------");
                int damage = player.attack(mini1);
                mini1.hp = mini1.hp - damage;
                if(mini1.hp > 0)
                    System.out.println("현재 Mini의 체력은 " + mini1.hp + " 이다.\n");

                else if(mini1.hp <= 0){
                    System.out.println("mini의 체력이 0이 되었다! "+ player.name + " 는 승리했다.");
                    System.out.println("돈 " + mini1.money + " 을 획득했다!");
                    player.money += mini1.money;
                    mini1.hp = mini1.maxHp;
                    System.out.println("스테이지 메뉴로 돌아간다.\n");
                    break;
                }

                System.out.println("----------------" + mini1.name + " 의 공격----------------");
                damage = mini1.attack(player);
                player.hp = player.hp - damage;
                if(player.hp > 0)
                    System.out.println("현재 " + player.name + " 의 체력은 " + player.hp + " 이다.\n");

                else if(player.hp <= 0){
                    System.out.println(player.name + "의 체력은 0이다. 전투에서 패배했다.");
                    System.out.println("스테이지 메뉴로 돌아간다.\n");
                    player.hp = player.maxHp;
                    player.life -= 1;
                    mini1.hp = mini1.maxHp;
                    break;
                }
            }
        }
    }

}

