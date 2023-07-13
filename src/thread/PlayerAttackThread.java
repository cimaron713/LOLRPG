package thread;

import champion.*;
import team.*;

public class PlayerAttackThread extends Thread{
    public Player player;
    public Gen gen;
    public T1 t1;
    public DK dk;

    public PlayerAttackThread(Player player,Gen gen, T1 t1, DK dk){
        this.player = player;
        this.gen = gen;
        this.t1 = t1;
        this.dk = dk;


    }

    public void run() {
        /* 스레드 실행코드 */
    }
}
