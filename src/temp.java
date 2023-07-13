public class temp {/*
    void jungleMenu(){
        System.out.println("번호를 입력하세요. 돌아가기는 [0]입니다.\n현재 보유 금액: " + player.money);
        System.out.println("=======정글 구매=======\n 챔피언 | 방어력 | 가격");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + jungles[i].name + " | " + jungles[i].defense + " | " + jungles[i].price);
        }
        System.out.println("\n=======장착중인 정글 판매=======\n판매는 절반 가격으로 할 수 있습니다.");
        System.out.println("4. " + player.jungle.name + " | " + player.jungle.defense + " | " + player.jungle.price/2 + "\n");
        System.out.println("========================");
        int numChampion = sc.nextInt();
        if(numChampion == 1 || numChampion == 2 || numChampion == 3) {
            if(player.jungle.price != 0){
                System.out.println("@@@현재 착용중인 정글 챔피언이 있습니다. 판매 후 다시 시도하세요.@@@");
                jungleMenu();
            }
            if(player.money >= jungles[numChampion-1].price){
                player.money = player.money - jungles[numChampion-1].price;
                player.equipJungle(jungles[numChampion-1]);
                System.out.println("챔피언 " + jungles[numChampion-1].name + " 구입완료!\n");
                mainMenu();
            }
            else{
                System.out.println("돈이 부족합니다!\n");
                mainMenu();
            }
        }
        else if(numChampion == 4){
            player.money = player.money + player.jungle.price/2;
            System.out.println("챔피언 " + player.jungle.name + " 판매완료!\n");
            player.unEquipJungle(jungles[3]);
            mainMenu();
        }
        else if(numChampion == 0){
            mainMenu();
        }
    }*/
/*
    //=============================미드=============================
    void midMenu(){
        System.out.println("번호를 입력하세요. 돌아가기는 [0]입니다.\n현재 보유 금액: " + player.money);
        System.out.println("=======미드 구매=======\n 챔피언 | 공격력 | 가격");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + mids[i].name + " | " + mids[i].attackDamage + " | " + mids[i].price);
        }
        System.out.println("\n=======장착중인 미드 판매=======\n판매는 절반 가격으로 할 수 있습니다.");
        System.out.println("4. " + player.mid.name + " | " + player.mid.attackDamage + " | " + player.mid.price/2 + "\n");
        System.out.println("========================");
        int numChampion = sc.nextInt();
        if(numChampion == 1 || numChampion == 2 || numChampion == 3) {
            if(player.mid.price != 0){
                System.out.println("@@@현재 착용중인 미드 챔피언이 있습니다. 판매 후 다시 시도하세요.@@@");
                midMenu();
            }
            if(player.money >= mids[numChampion-1].price){
                player.money = player.money - mids[numChampion-1].price;
                player.equipMid(mids[numChampion-1]);
                System.out.println("챔피언 " + mids[numChampion-1].name + " 구입완료!\n");
                mainMenu();
            }
            else{
                System.out.println("돈이 부족합니다!\n");
                mainMenu();
            }
        }
        else if(numChampion == 4){
            player.money = player.money + player.mid.price/2;
            System.out.println("챔피언 " + player.mid.name + " 판매완료!\n");
            player.unEquipMid(mids[3]);
            mainMenu();
        }
        else if(numChampion == 0){
            mainMenu();
        }
    }
    //=============================바텀=============================
    void botMenu(){
        System.out.println("번호를 입력하세요. 돌아가기는 [0]입니다.\n현재 보유 금액: " + player.money);
        System.out.println("=======바텀 구매=======\n 챔피언 | 회피율 | 가격");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + bots[i].name + " | " + bots[i].avoidance + " | " + bots[i].price);
        }
        System.out.println("\n=======장착중인 바텀 판매=======\n판매는 절반 가격으로 할 수 있습니다.");
        System.out.println("4. " + player.bot.name + " | " + player.bot.avoidance + " | " + player.bot.price/2 + "\n");
        System.out.println("========================");
        int numChampion = sc.nextInt();
        if(numChampion == 1 || numChampion == 2 || numChampion == 3) {
            if(player.bot.price != 0){
                System.out.println("@@@현재 착용중인 바텀 챔피언이 있습니다. 판매 후 다시 시도하세요.@@@");
                botMenu();
            }
            if(player.money >= bots[numChampion-1].price){
                player.money = player.money - bots[numChampion-1].price;
                player.equipBot(bots[numChampion-1]);
                System.out.println("챔피언 " + bots[numChampion-1].name + " 구입완료!\n");
                mainMenu();
            }
            else{
                System.out.println("돈이 부족합니다!\n");
                mainMenu();
            }
        }
        else if(numChampion == 4){
            player.money = player.money + player.bot.price/2;
            System.out.println("챔피언 " + player.bot.name + " 판매완료!\n");
            player.unEquipBot(bots[3]);
            mainMenu();
        }
        else if(numChampion == 0){
            mainMenu();
        }
    }*/
}
