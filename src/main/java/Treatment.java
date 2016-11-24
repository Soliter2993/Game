import java.util.HashMap;
import java.util.Map;

public class Treatment {
    Map<Integer, String> combinations = new HashMap<Integer, String>();
    public void combinations(){
        combinations.put(0, "Imposible");
        combinations.put(1, "Nothing");
        combinations.put(2, "One Paris");// Одна пара
        combinations.put(3, "Two Paris");// Две пары
        combinations.put(4, "Three of Kind");// Три одинаковые карты
        combinations.put(5, "Straight");//5 последовательных (3,4,5,6,7 or 6,8,9,7,5)
        combinations.put(6, "Full House");//Три одинаковые карты и пара
        combinations.put(7, "Four of Kind");//Четыри одинаковые карты

    }
    int resultWhite;

    int[] numberOfCardsWhite = new int[1 + 13];
    public int treatmentWhite(int[] cardInHands){

        for (int x : cardInHands){
            numberOfCardsWhite[x]++;
        }
        int[] numberOfRepeatedCardWhite = new int[1 + 5];
        for (int x : numberOfCardsWhite){
            numberOfRepeatedCardWhite[x]++;
        }

        if (numberOfRepeatedCardWhite[5] == 1){//5 одинаковых карт (невозможно)
            //System.out.println("Imposible");
            resultWhite = 0; // "Imposible";
        }else if (numberOfRepeatedCardWhite[4] == 1){//4 одинаковые карты
           // System.out.println("Four of Kind");
            resultWhite = 7; //"Four of Kind";
        }else if (numberOfRepeatedCardWhite[3] == 1 && numberOfRepeatedCardWhite[2] == 1){//3 одинаковые карты и пара
            //System.out.println("Full House");
            resultWhite = 6; //"Full House";
        }else if (numberOfRepeatedCardWhite[3] == 1){//3 одинаковые карты
            //System.out.println("Three of Kind");
            resultWhite = 4; //"Three of Kind";
        }else if (numberOfRepeatedCardWhite[2] == 2){//2 пары
            //System.out.println("Two Pairs");
            resultWhite = 3; //"Two Paris";
        }else if (numberOfRepeatedCardWhite[2] == 1){//одна пара
            //System.out.println("One Paris");
            resultWhite = 2; //"One Paris";
        }else if (numberOfRepeatedCardWhite[1] == 5){
            int min = 14;
            int max = 0;
            for (int x : cardInHands){
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            if (max - min == 4){
                //System.out.println("Straight");
                resultWhite = 5; //"Straight";
            }else {
                //System.out.println("Nothing");
                resultWhite = 1; //"Nothing";
            }
        }else{
            resultWhite = -1; //"Error. Что то не так";
        }
        return resultWhite;
    }
    int resultBlack;
    int[] numberOfCardsBlack = new int[1 + 13];
    public int treatmentBlack(int[] cardInHands){

        for (int x : cardInHands){
            numberOfCardsBlack[x]++;
        }
        int[] kolichestvoPovtorCardBlack = new int[1 + 5];
        for (int x : numberOfCardsBlack){
            kolichestvoPovtorCardBlack[x]++;
        }

        if (kolichestvoPovtorCardBlack[5] == 1){//5 одинаковых карт (невозможно)
            //System.out.println("Imposible");
            resultBlack = 0; //"Imposible";
        }else if (kolichestvoPovtorCardBlack[4] == 1){//4 одинаковые карты
            // System.out.println("Four of a Kind");
            resultBlack = 7; //"Four of a Kind";
        }else if (kolichestvoPovtorCardBlack[3] == 1 && kolichestvoPovtorCardBlack[2] == 1){//3 одинаковые карты и пара
            //System.out.println("Full House");
            resultBlack = 6; //"Full House";
        }else if (kolichestvoPovtorCardBlack[3] == 1){//3 одинаковые карты
            //System.out.println("Three of a Kind");
            resultBlack = 4; //"Three of Kind";
        }else if (kolichestvoPovtorCardBlack[2] == 2){//2 пары
            //System.out.println("Two Pairs");
            resultBlack = 3; //"Two Paris";
        }else if (kolichestvoPovtorCardBlack[2] == 1){//одна пара
            //System.out.println("One Paris");
            resultBlack = 2; //"One Paris";
        }else if (kolichestvoPovtorCardBlack[1] == 5){
            int min = 14;
            int max = 0;
            for (int x : cardInHands){
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            if (max - min == 4){
                //System.out.println("Straight");
                resultBlack = 5; //"Straight";
            }else {
                //System.out.println("Nothing");
                resultBlack = 1; //"Nothing";
            }
        }else{
            resultBlack = -1; //"Error. Что то не так";
        }
        return resultBlack;
    }






}
