package app;

import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class Database {
    //랜덤숫자 저장 객체
    //오차 저장 객체
    //시도를 저장할 객체
    private int random;
    private ArrayList<Integer> diff = new ArrayList<>();
    private ArrayList<Integer> trysave = new ArrayList<>();

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public ArrayList<Integer> getDiff() {
        return diff;
    }

    public ArrayList<Integer> getTrysave() {
        return trysave;
    }


    //1. 10~99까지의 숫자를 생성 메소드로..

    public void generateGuessNumber(){
        setRandom((int) Math.random()*90+10);
        System.out.println("랜덤숫자 생성을 완료했습니다");
    }

    public void addToInputList(int number){
        trysave.add(number);
    }

    public void addToDiffList(int number){
        diff.add(number);
    }

}