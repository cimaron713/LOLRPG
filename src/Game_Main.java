import champion.*;
import team.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Game_Main {
    public static void main(String[] args) {
        // NULL 방지
        Top top0 = new Top("없음",0,0);
        Jungle jungle0 = new Jungle("없음",0,0);
        Mid mid0 = new Mid("없음",0,0);
        Bot bot0 = new Bot("없음",0,0);

        // 화면
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("┌─────────────────┐");
            System.out.println("│     LOL RPG     │");
            System.out.println("├─────────────────┤");
            System.out.println("│  1. Start Game  │");
            System.out.println("│  2. Exit        │");
            System.out.println("└─────────────────┘");
            int num = sc.nextInt();
            if(num == 1){
                break;
            }
            else if(num == 2){
                System.out.println("게임 종료");
                System.exit(0);
            }
            else{
                System.out.println("올바른 번호를 입력하세요.");
            }
        }


        // 플레이어
        System.out.println("=========팀 생성=========");
        System.out.println("사용할 팀 이름을 지정하세요.");
        String teamName = sc.next();
        System.out.println("당신의 팀 명은 "+teamName+" 입니다.");
        System.out.println("게임을 시작합니다!\n");
        Player player = new Player(teamName, 0,0,0,0,2000, 0,
                top0, jungle0, mid0, bot0, new ArrayList<>(),new ArrayList<>(), new ArrayList<>(),new ArrayList<>());

        // 상점 추가
        Shop shop = new Shop(player);

        // 스테이지
        Stage stage = new Stage(player);


        //메인 메뉴
        while(true){
            System.out.println("┌───────────────────────────┐");
            System.out.println("│          LOL RPG          │");
            System.out.println("└───────────────────────────┘");
            System.out.println("\n==========메인메뉴==========");
            System.out.println("1. 스테이지 진행\n2. 상점\n3. 내 정보 \n4. 게임 가이드\n5. 게임종료");
            System.out.println("==========================\n");
            int menu = sc.nextInt();

            if(menu == 1){

                player = stage.stageMenu();
            }
            else if(menu == 2){
                player = shop.mainMenu();
            }
            else if(menu == 3){
                System.out.println("내 정보");
                System.out.println("팀 이름: " + player.name);
                System.out.println("능력치\n(HP | 공격력 | 방어력 | 회피율 | 남은 생명)\n"
                        + player.hp + " | " + player.attackDamage + " | " + player.defense + " | " + player.avoidance + " | " + player.life);
                System.out.println("\n보유 돈:" + player.money);
                System.out.println("\n보유중인 챔피언");

                System.out.println("@@탑@@");
                for(int i=0; i<player.tops.size(); i++){
                    System.out.println(player.tops.get(i).name);
                }
                System.out.println("\n");
                System.out.println("@@정글@@");
                for(int i=0; i<player.jungles.size(); i++){
                    System.out.println(player.jungles.get(i).name);
                }
                System.out.println("\n");
                System.out.println("@@미드@@");
                for(int i=0; i<player.mids.size(); i++){
                    System.out.println(player.mids.get(i).name);
                }
                System.out.println("\n");
                System.out.println("@@바텀@@");
                for(int i=0; i<player.bots.size(); i++){
                    System.out.println(player.bots.get(i).name);
                }
                System.out.println("\n");
                System.out.println("장착중인 챔피언\n(탑 | 정글 | 미드 | 바텀)\n"
                        + player.top.name + " | " + player.jungle.name + " | " + player.mid.name + " | " + player.bot.name + "\n");
            }
            else if(menu == 4){
                System.out.println("=========게임 가이드=========");
                System.out.println("스테이지는 총 3단계로 구성되어 있으며, \n스테이지 클리어 시 돈을 획득하고 다음 스테이지로 넘어간다.");
                System.out.println("챔피언을 구매해 Hp, 방어력, 공격력, 회피율을 높여 전투에서 승리해야 한다.");
                System.out.println("각 라인별 능력치는 다음과 같다. \n탑 : Hp | 정굴 : 방어력 | 미드 : 공격력 | 바텀 : 회피");
                System.out.println("스테이지 클리어 시, 스테이지 메뉴에서 챔피언을 구매 또는 판매를 할 수 있다.");
                System.out.println("만약, 챔피언을 구입할 돈이 부족하다면 미니스테이지를 통해 돈을 얻을 수 있다.");
                System.out.println("미니 스테이지는 체력이 회복되지 않고, Player의 체력이 0이 되면 생명력 1을 감소한다.");
                System.out.println("마지막 스테이지를 클리어 하면 게임이 종료된다.\n");
            }
            else if(menu == 5){
                System.out.println("게임 종료");
                System.exit(0);
            }
            else{
                System.out.println("올바른 번호를 입력하시오.");
            }
        }
    }

}
