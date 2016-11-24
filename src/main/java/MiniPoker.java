import java.util.Scanner;

public class MiniPoker {
    public static int[] cardInHandWhite = new int[5];
    public static int[] cardInHandBlack = new int[5];

    public static void main(String[] args) {
        //Заполнили массив для временной работы(пока проект в разработке для быстрой проверки работоспособности
        cardInHandWhite[0] = 7;
        cardInHandWhite[1] = 7;
        cardInHandWhite[2] = 7;
        cardInHandWhite[3] = 5;
        cardInHandWhite[4] = 6;

        cardInHandBlack[0] = 7;
        cardInHandBlack[1] = 7;
        cardInHandBlack[2] = 7;
        cardInHandBlack[3] = 5;
        cardInHandBlack[4] = 4;

        Treatment treatment = new Treatment();
        ReTreatment reTreatment = new ReTreatment();

        treatment.combinations();//инициализируем мапу (присваиваем названию комбинации интовое значение)

        Scanner scanner = new Scanner(System.in);

        //Даем пользователю возможность ввести карты оппонентов
//        for (int i = 0; i < cardInHandWhite.length; i++) {
//            System.out.println("Write card for White #" + (i + 1));
//            cardInHandWhite[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < cardInHandBlack.length; i++){
//
//            System.out.println("Write card for Black #" + (i + 1));
//            cardInHandBlack[i] = scanner.nextInt();
//
//        }
        //Выводим в консоль какие карты находятся у белого игрока
        System.out.print("White Gamer have a Cards: ");
        for (int i = 0; i < cardInHandWhite.length; i++){
            System.out.print(cardInHandWhite[i] + " ");
        }
        System.out.println();

        //Выводим в консоль какие карты находятся у черного игрока
        System.out.print("Black Gamer have a Cards: ");
        for (int i = 0; i < cardInHandBlack.length; i++){
            System.out.print(cardInHandBlack[i] + " ");
        }
        System.out.println();
        treatment.treatmentWhite(cardInHandWhite);
        treatment.treatmentBlack(cardInHandBlack);
        //Выводим в консоль какие комбинации у игроков
        System.out.println("White Gamer have a combination: " + treatment.combinations.get(treatment.resultWhite));
        System.out.println("Black Gamer have a combination: " + treatment.combinations.get(treatment.resultBlack));
        //Проверяем кто из игроков выиграл и при возникновении одинаковых комбинаций проверяем на наивысшую карту
        System.out.println(reTreatment.ReTreatment());









    }




}
