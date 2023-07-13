import champion.*;
import team.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Shop {
    Player player;
    Scanner sc = new Scanner(System.in);
    Top[] tops;
    Jungle[] jungles;
    Mid[] mids;
    Bot[] bots;
    public Shop(Player player){
        this.player = player;
        tops = new Top[4];
        jungles = new Jungle[4];
        mids = new Mid[4];
        bots = new Bot[4];

        tops[0] = new Top("가렌", 1000,1300);
        tops[1] = new Top("다리우스", 600, 1000);
        tops[2] = new Top("레넥톤", 400, 8000);
        tops[3] = new Top("없음", 0,0);

        jungles[0] = new Jungle("그라가스", 1000, 120);
        jungles[1] = new Jungle("니달리", 600, 60);
        jungles[2] = new Jungle("람머스", 400, 400);
        jungles[3] = new Jungle("없음", 0, 0);

        mids[0]= new Mid("갈리오", 1000, 300);
        mids[1] = new Mid("제드",600,200);
        mids[2] = new Mid("야스오", 400, 1500);
        mids[3] = new Mid("없음", 0, 0);

        bots[0] = new Bot("애쉬", 1000, 40);
        bots[1] = new Bot("베인", 600, 20);
        bots[2] = new Bot("시비르", 400, 100);
        bots[3] = new Bot("없음", 0, 0);
    }
    // 메인메뉴
    public Player mainMenu(){
        while(true){
            Scanner sc = new Scanner(System.in);
            int menu;
            System.out.println("┌───────────────────────────┐");
            System.out.println("│            Shop           │");
            System.out.println("└───────────────────────────┘");

            System.out.println("\n@@@ 현재 보유 금액: " + player.money + " @@@");
            System.out.println("\n어느 라인을 관리하실껀가요?");
            System.out.println("1. 탑\n2. 정글\n3. 미드\n4. 바텀\n5. 돌아가기");
            menu = sc.nextInt();
            if(menu == 1)
                topMenu();
            else if(menu == 2)
                jungleMenu();
            else if(menu == 3){
                midMenu();
            }
            else if(menu == 4){
                botMenu();
            }
            else {
                break;
            }
        }
        return player;
        }

    // 구입


    // =============================탑=============================
    void topMenu(){
        while(true){
            System.out.println("TOP MENU\n1. 탑 장착 2. 탑 구매 및 판매 3. 돌아가기 ");
            int numtop = sc.nextInt();
            if(numtop == 1){
                System.out.println("보유중인 챔피언은 아래와 같습니다. 어느 챔피언을 장착하시겠습니까? 돌아가기 [0]\n 이름 | HP | 가격 ");
                for (int i = 0; i<player.tops.size(); i++){
                    System.out.println((i+1)+". " + player.tops.get(i).name + " | " + player.tops.get(i).hp + " | " + player.tops.get(i).price/2);
                }
                System.out.println("====장착중인 탑 챔피언====");
                System.out.println((player.tops.size()+1)+". " + player.top.name + " | " + player.top.hp + " | " + player.top.price/2 + "\n");
                int topequip = sc.nextInt();
                if(topequip == 0){
                }
                else if(topequip < player.tops.size()+1){
                    if(player.top.price != 0){
                        player.tops.add(player.top); // 끼고 있던 것 인벤토리에 추가
                        player.equipTop(player.tops.get(topequip-1)); // 장착
                        System.out.println("챔피언 " + player.tops.get(topequip-1).name + " 장착!\n");
                        player.tops.remove(topequip-1); // 인벤토리에서 제거
                    }
                    else if(player.top.price == 0){
                        player.equipTop(player.tops.get(topequip-1)); // 장착
                        System.out.println("챔피언 " + player.tops.get(topequip-1).name + " 장착!\n");
                        player.tops.remove(topequip-1); // 인벤토리에서 제거
                    }

                }

            }
            else if(numtop == 2){
                System.out.println("\n번호를 입력하세요. 돌아가기는 [0]입니다. ");
                System.out.println("현재 보유 금액: " + player.money);
                System.out.println("=======탑 구매=======\n 챔피언 | HP | 가격");
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + ". " + tops[i].name + " | " + tops[i].hp + " | " + tops[i].price);
                }
                System.out.println("\n=======보유 중인 탑 판매=======\n판매는 절반 가격으로 할 수 있습니다.");
                for (int i = 0; i<player.tops.size(); i++){
                    System.out.println((i+4)+". " + player.tops.get(i).name + " | " + player.tops.get(i).hp + " | " + player.tops.get(i).price/2);
                }
                System.out.println("========================");
                int numChampion = sc.nextInt();
                if(numChampion == 0){
                }
                else if(numChampion == 1 || numChampion == 2 || numChampion == 3) {
                    if(player.money >= tops[numChampion-1].price){
                        player.tops.add(tops[numChampion-1]); // 탑 챔피언 추가
                        player.money = player.money - tops[numChampion-1].price;
                        System.out.println("챔피언 " + tops[numChampion-1].name + " 구입완료!\n");
                    }
                    else if(player.money >= tops[numChampion-1].price){
                        player.money = player.money - tops[numChampion-1].price;
                        player.equipTop(tops[numChampion-1]);
                        System.out.println("챔피언 " + tops[numChampion-1].name + " 구입완료!\n");
                    }
                    else{
                        System.out.println("돈이 부족합니다!\n");
                    }
                }

                else if(numChampion < player.tops.size()+4){
                    player.money = player.money + player.tops.get(numChampion-4).price/2;
                    System.out.println("챔피언 " + player.tops.get(numChampion-4).name + " 판매완료!\n");
                    player.tops.remove(numChampion-4); // 인벤토리에서 제거
                }
            }
            else if(numtop == 3){
                break;
            }
        }


    }
    //=============================정글=============================
    void jungleMenu(){
        while(true){
            System.out.println("JUNGLE MENU\n1. 장착 2. 구매 및 판매 3. 돌아가기 ");
            int numjungle = sc.nextInt();
            if(numjungle == 1){
                System.out.println("보유중인 챔피언은 아래와 같습니다. 어느 챔피언을 장착하시겠습니까?\n 이름 | 방어력 | 가격 ");
                for (int i = 0; i<player.jungles.size(); i++){
                    System.out.println((i+1)+". " + player.jungles.get(i).name + " | " + player.jungles.get(i).defense + " | " + player.jungles.get(i).price/2);
                }
                System.out.println("====장착중인 정글 챔피언====");
                System.out.println((player.jungles.size()+1)+". " + player.jungle.name + " | " + player.jungle.defense + " | " + player.jungle.price/2 + "\n");
                int jungleequip = sc.nextInt();
                if(jungleequip == 0){
                }
                else if(jungleequip < player.jungles.size()+1){
                    if(player.jungle.price != 0){
                        player.jungles.add(player.jungle); // 끼고 있던 것 인벤토리에 추가
                        player.equipJungle(player.jungles.get(jungleequip-1)); // 장착
                        System.out.println("챔피언 " + player.jungles.get(jungleequip-1).name + " 장착!\n");
                        player.jungles.remove(jungleequip-1); // 인벤토리에서 제거
                    }
                    else if(player.jungle.price == 0){
                        player.equipJungle(player.jungles.get(jungleequip-1)); // 장착
                        System.out.println("챔피언 " + player.jungles.get(jungleequip-1).name + " 장착!\n");
                        player.jungles.remove(jungleequip-1); // 인벤토리에서 제거
                    }
                    else{

                    }

                }

            }
            else if(numjungle == 2){
                System.out.println("\n번호를 입력하세요. 돌아가기는 [0]입니다. ");
                System.out.println("현재 보유 금액: " + player.money);
                System.out.println("=======정글 구매=======\n 챔피언 | 방어력 | 가격");
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + ". " + jungles[i].name + " | " + jungles[i].defense + " | " + jungles[i].price);
                }
                System.out.println("\n=======보유 중인 정글 판매=======\n판매는 절반 가격으로 할 수 있습니다.");
                for (int i = 0; i<player.jungles.size(); i++){
                    System.out.println((i+4)+". " + player.jungles.get(i).name + " | " + player.jungles.get(i).defense + " | " + player.jungles.get(i).price/2);
                }
                System.out.println("========================");
                int numChampion = sc.nextInt();
                if(numChampion == 1 || numChampion == 2 || numChampion == 3) {
                    if(player.money >= jungles[numChampion-1].price){
                        player.jungles.add(jungles[numChampion-1]); // 탑 챔피언 추가
                        player.money = player.money - jungles[numChampion-1].price;
                        System.out.println("챔피언 " + jungles[numChampion-1].name + " 구입완료!\n");
                    }
                    else if(player.money >= jungles[numChampion-1].price){
                        player.money = player.money - jungles[numChampion-1].price;
                        player.equipJungle(jungles[numChampion-1]);
                        System.out.println("챔피언 " + jungles[numChampion-1].name + " 구입완료!\n");
                    }
                    else{
                        System.out.println("돈이 부족합니다!\n");
                    }
                }
                else if(numChampion == 0){
                }
                else if(numChampion < player.jungles.size()+4){
                    player.money = player.money + player.jungles.get(numChampion-4).price/2;
                    System.out.println("챔피언 " + player.jungles.get(numChampion-4).name + " 판매완료!\n");
                    player.jungles.remove(numChampion-4); // 인벤토리에서 제거
                }
            }
            else if(numjungle == 3){
                break;
            }
        }
    }

    //=============================미드=============================
    void midMenu(){
        while(true){
            System.out.println("MID MENU\n1. 장착 2. 구매 및 판매 3. 돌아가기 ");
            int nummid = sc.nextInt();
            if(nummid == 1){
                System.out.println("보유중인 챔피언은 아래와 같습니다. 어느 챔피언을 장착하시겠습니까?\n 이름 | 방어력 | 가격 ");
                for (int i = 0; i<player.mids.size(); i++){
                    System.out.println((i+1)+". " + player.mids.get(i).name + " | " + player.mids.get(i).attackDamage + " | " + player.mids.get(i).price/2);
                }
                System.out.println("====장착중인 미드 챔피언====");
                System.out.println((player.mids.size()+1)+". " + player.mid.name + " | " + player.mid.attackDamage + " | " + player.mid.price/2 + "\n");
                int midequip = sc.nextInt();
                if(midequip == 0){
                }
                else if(midequip < player.mids.size()+1){
                    if(player.mid.price != 0){
                        player.mids.add(player.mid); // 끼고 있던 것 인벤토리에 추가
                        player.equipMid(player.mids.get(midequip-1)); // 장착
                        System.out.println("챔피언 " + player.mids.get(midequip-1).name + " 장착!\n");
                        player.mids.remove(midequip-1); // 인벤토리에서 제거
                    }
                    else if(player.mid.price == 0){
                        player.equipMid(player.mids.get(midequip-1)); // 장착
                        System.out.println("챔피언 " + player.mids.get(midequip-1).name + " 장착!\n");
                        player.mids.remove(midequip-1); // 인벤토리에서 제거
                    }
                    else{

                    }

                }

            }
            else if(nummid == 2){
                System.out.println("\n번호를 입력하세요. 돌아가기는 [0]입니다. ");
                System.out.println("현재 보유 금액: " + player.money);
                System.out.println("=======미드 구매=======\n 챔피언 | 방어력 | 가격");
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + ". " + mids[i].name + " | " + mids[i].attackDamage + " | " + mids[i].price);
                }
                System.out.println("\n=======보유 중인 미드 판매=======\n판매는 절반 가격으로 할 수 있습니다.");
                for (int i = 0; i<player.mids.size(); i++){
                    System.out.println((i+4)+". " + player.mids.get(i).name + " | " + player.mids.get(i).attackDamage + " | " + player.mids.get(i).price/2);
                }
                System.out.println("========================");
                int numChampion = sc.nextInt();
                if(numChampion == 1 || numChampion == 2 || numChampion == 3) {
                    if(player.money >= mids[numChampion-1].price){
                        player.mids.add(mids[numChampion-1]); // 탑 챔피언 추가
                        player.money = player.money - mids[numChampion-1].price;
                        System.out.println("챔피언 " + mids[numChampion-1].name + " 구입완료!\n");
                    }
                    else if(player.money >= mids[numChampion-1].price){
                        player.money = player.money - mids[numChampion-1].price;
                        player.equipMid(mids[numChampion-1]);
                        System.out.println("챔피언 " + mids[numChampion-1].name + " 구입완료!\n");
                    }
                    else{
                        System.out.println("돈이 부족합니다!\n");
                    }
                }
                else if(numChampion == 0){
                }
                else if(numChampion < player.mids.size()+4){
                    player.money = player.money + player.mids.get(numChampion-4).price/2;
                    System.out.println("챔피언 " + player.mids.get(numChampion-4).name + " 판매완료!\n");
                    player.mids.remove(numChampion-4); // 인벤토리에서 제거
                }
            }
            else if(nummid == 3){
                break;
            }
        }
    }
    //=============================바텀=============================
    void botMenu(){
        while(true){
            System.out.println("BOT MENU\n1. 장착 2. 구매 및 판매 3. 돌아가기 ");
            int numbot = sc.nextInt();
            if(numbot == 1){
                System.out.println("보유중인 챔피언은 아래와 같습니다. 어느 챔피언을 장착하시겠습니까?\n 이름 | 방어력 | 가격 ");
                for (int i = 0; i<player.bots.size(); i++){
                    System.out.println((i+1)+". " + player.bots.get(i).name + " | " + player.bots.get(i).avoidance + " | " + player.bots.get(i).price/2);
                }
                System.out.println("====장착중인 바텀 챔피언====");
                System.out.println((player.bots.size()+1)+". " + player.bot.name + " | " + player.bot.avoidance + " | " + player.bot.price/2 + "\n");
                int botequip = sc.nextInt();
                if(botequip == 0){
                }
                else if(botequip < player.bots.size()+1){
                    if(player.bot.price != 0){
                        player.bots.add(player.bot); // 끼고 있던 것 인벤토리에 추가
                        player.equipBot(player.bots.get(botequip-1)); // 장착
                        System.out.println("챔피언 " + player.bots.get(botequip-1).name + " 장착!\n");
                        player.bots.remove(botequip-1); // 인벤토리에서 제거
                    }
                    else if(player.bot.price == 0){
                        player.equipBot(player.bots.get(botequip-1)); // 장착
                        System.out.println("챔피언 " + player.bots.get(botequip-1).name + " 장착!\n");
                        player.bots.remove(botequip-1); // 인벤토리에서 제거
                    }
                    else{

                    }

                }

            }
            else if(numbot == 2){
                System.out.println("\n번호를 입력하세요. 돌아가기는 [0]입니다. ");
                System.out.println("현재 보유 금액: " + player.money);
                System.out.println("=======바텀 구매=======\n 챔피언 | 방어력 | 가격");
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + ". " + bots[i].name + " | " + bots[i].avoidance + " | " + bots[i].price);
                }
                System.out.println("\n=======보유 중인 바텀 판매=======\n판매는 절반 가격으로 할 수 있습니다.");
                for (int i = 0; i<player.bots.size(); i++){
                    System.out.println((i+4)+". " + player.bots.get(i).name + " | " + player.bots.get(i).avoidance + " | " + player.bots.get(i).price/2);
                }
                System.out.println("========================");
                int numChampion = sc.nextInt();
                if(numChampion == 1 || numChampion == 2 || numChampion == 3) {
                    if(player.money >= bots[numChampion-1].price){
                        player.bots.add(bots[numChampion-1]); // 탑 챔피언 추가
                        player.money = player.money - bots[numChampion-1].price;
                        System.out.println("챔피언 " + bots[numChampion-1].name + " 구입완료!\n");
                    }
                    else if(player.money >= bots[numChampion-1].price){
                        player.money = player.money - bots[numChampion-1].price;
                        player.equipBot(bots[numChampion-1]);
                        System.out.println("챔피언 " + bots[numChampion-1].name + " 구입완료!\n");
                    }
                    else{
                        System.out.println("돈이 부족합니다!\n");
                    }
                }
                else if(numChampion == 0){
                }
                else if(numChampion < player.bots.size()+4){
                    player.money = player.money + player.bots.get(numChampion-4).price/2;
                    System.out.println("챔피언 " + player.bots.get(numChampion-4).name + " 판매완료!\n");
                    player.bots.remove(numChampion-4); // 인벤토리에서 제거
                }
            }
            else if(numbot == 3){
                break;
            }
        }
    }
}
