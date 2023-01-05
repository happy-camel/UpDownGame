package app;

import java.util.Scanner;

public class Control {

    private int guessNumber;
    private int inputNumber;
    Database database;

    public Control(Database database) {
        this.database = database;
    }

    public void playgame(){

        //1. 10~99까지의 숫자를 생성
        database.generateGuessNumber();

        guessNumber = database.getRandom();

        //2.  사용자 입력 받기
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println();
            while (true) {
                System.out.println("10~99사이의 숫자를 입력해 주세요");
                //nextInt는 버그가 많다
                try{
                    inputNumber = Integer.parseInt(in.nextLine());
                }catch(Exception e){
                    System.out.println("숫자를 입력해 주세요");
                    continue;
                }
                break;
            }
            int diff = guessNumber-inputNumber;
            database.addToInputList(inputNumber);
            database.addToDiffList(Math.abs(diff));

            //비교하기 편하게 이터레이터 추가해보기
            //3. 입력한 수가 guessNumber보다 크면 Down, 작으면 Up 이라고 출력
            if (diff>0){
                System.out.println("제가 생각한 값이 입력값보다 큽니다");

            } else if (diff<0) {
                System.out.println("제가 생각한 값이 입력값보다 작습니다");
            } else {
                System.out.println("맞췄습니다!");
                break;
            }
        }
        //4. 정답을 입력할 때까지 2,3 반복
        //5. 정답 출력

        //6. 지금까지 입력한 숫자를 정답과 오차를 함께 순서대로 출력
        System.out.println(database.getTrysave());
        System.out.println(database.getDiff());
        //7. 종료 및 메세지 출력
    }
}
