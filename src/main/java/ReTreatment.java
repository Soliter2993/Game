public class ReTreatment {
    Treatment treatment = new Treatment();
    MiniPoker miniPoker = new MiniPoker();

    String howWin;
    int maxWhite = 0;
    int maxBlack = 0;

    String ReTreatment(){
        treatment.treatmentWhite(MiniPoker.cardInHandWhite);
        treatment.treatmentBlack(MiniPoker.cardInHandBlack);
        treatment.combinations();
        //ПРоверяем кто из игроков выиграл
        if (treatment.resultWhite > treatment.resultBlack){
            howWin = "White Gamer is won\nHe have combination: " + treatment.combinations.get(treatment.resultWhite);
        }else if (treatment.resultWhite < treatment.resultBlack){
            howWin = "Black Gamer is won\nHe have combination: " + treatment.combinations.get(treatment.resultBlack);
            //Если у игроков одинаковые комбинации проверяем в какой комбинации бОльшая карта
        }else if (treatment.resultWhite == 2 && treatment.resultBlack == 2) {//Если у игроков комбинация из одной пары, проверяем в чьей паре бОльшая карта
            oneParis();
        }else if (treatment.resultWhite == 3 && treatment.resultBlack == 3){//Если у игроков комбинация из двух пар, проверяем в чьей из пар бОльшая карта
            twoParis();
        } else {
            maxCard();
        }
        return howWin;
    }
    //_________________________________________________________

    String maxCard(){//Метод который определяем наивысшую карту у игроков если у них одинаковая комбинация
        int maxWhite = 0;
        int maxBlack = 0;
        int minWhite = 0;
        int minBlack = 0;
        int midWhite = 0;
        int midBlack = 0;
        for (int x = 0; x < treatment.numberOfCardsWhite.length; x++){
            if (treatment.numberOfCardsWhite[x] == 1){
                maxWhite = x;
            }
        }
        for (int x = 0; x < treatment.numberOfCardsBlack.length; x++){
            if (treatment.numberOfCardsBlack[x] == 1){
                maxBlack = x;
            }
        }
        if (maxBlack < maxWhite){
            howWin = "White Gamer is won\nHe have highest card of: " + maxWhite;
        }else if (maxBlack > maxWhite) {
            howWin = "Black Gamer is won\nHe have highest card of: " + maxBlack;
        }else if (maxBlack == maxWhite) {
            for (int x = treatment.numberOfCardsWhite.length - 1; x > 0; x--) {
                if (treatment.numberOfCardsWhite[x] == 1) {
                    minWhite = x;
                }
            }
            for (int x = treatment.numberOfCardsBlack.length - 1; x > 0; x--) {
                if (treatment.numberOfCardsBlack[x] == 1) {
                    minBlack = x;
                }
            }
            if (minBlack < minWhite) {
                howWin = "White Gamer is won\nHe have highest card of: " + minWhite;
            } else if (minBlack > minWhite) {
                howWin = "Black Gamer is won\nHe have highest card of: " + minBlack;
            } else if (minBlack == minWhite) {
                for (int x = maxWhite; x > minWhite; x--) {
                    if (treatment.numberOfCardsWhite[x] == 1) {
                        midWhite = x;
                    }
                }
                for (int x = maxBlack; x > minBlack; x--) {
                    if (treatment.numberOfCardsBlack[x] == 1) {
                        midBlack = x;
                    }
                }
                if (midBlack < midWhite) {
                    howWin = "White Gamer is won\nHe have highest card of: " + midWhite;
                } else if (midBlack > midWhite) {
                    howWin = "Black Gamer is won\nHe have highest card of: " + midBlack;
                } else {
                    howWin = "Dead Heat";
                }
            }
        }
        return howWin;
    }
    //__________________________________________________________

    String oneParis(){//Метод который вычисляет кто из игроков победил если у обоих по одной паре
        //Бежим по массиву в котором записаны все карты которые есть в коллоде причем карты которых нет у игрока будут записаны в индекс 0
        for (int x = 0; x < treatment.numberOfCardsWhite.length; x++){//для белого игрока
            //Ищем нашу пару, т.е. когда значение с индексом х будет равно 2 это и будет наша пара
            if (treatment.numberOfCardsWhite[x] == 2){
                //записываем значение карты из пары в максимальное
                maxWhite = x;
            }
        }
        //Бежим по массиву в котором записаны все карты которые есть в коллоде причем карты которых нет у игрока будут записаны в индекс 0
        for (int x = 0; x < treatment.numberOfCardsBlack.length; x++) {//для черного игрока
            //Ищем нашу пару, т.е. когда значение с индексом х будет равно 2 это и будет наша пара
            if (treatment.numberOfCardsBlack[x] == 2) {
                //записываем значение карты из пары в максимальное
                maxBlack = x;
            }
        }
        if (maxBlack < maxWhite){
            howWin = "White Gamer is won\nHe have Paris of: " + maxWhite;
        }else if (maxBlack > maxWhite) {
            howWin = "Black Gamer is won\nHe have Paris of: " + maxBlack;
        }else if (maxBlack == maxWhite){
            maxCard();
        }else{
            howWin = "Dead Heat";
        }
        return howWin;
    }
    //_________________________________________________________________________

    String twoParis(){//Метод который вычисляет кто из игроков победил если у обоих по 3 одинаковых карты
        for (int x = 0; x < treatment.numberOfCardsWhite.length; x++){
            if (treatment.numberOfCardsWhite[x] == 2){
                maxWhite = x;
            }
        }
        for (int x = 0; x < treatment.numberOfCardsBlack.length; x++){
            if (treatment.numberOfCardsBlack[x] ==2){
                maxBlack = x;
            }
        }
        if (maxBlack < maxWhite){
            howWin = "White Gamer is won\nHe have first Paris of: " + maxWhite;
        }else if (maxBlack > maxWhite) {
            howWin = "Black Gamer is won\nHe have first Paris of: " + maxBlack;
        }else if (maxBlack == maxWhite){
            for (int x = treatment.numberOfCardsWhite.length - 1; x > 0; x--){
                if (treatment.numberOfCardsWhite[x] == 2){
                    maxWhite = x;
                }
            }
            for (int x = treatment.numberOfCardsBlack.length - 1; x > 0; x--){
                if (treatment.numberOfCardsBlack[x] == 2){
                    maxBlack = x;
                }
            }
            if (maxBlack < maxWhite){
                howWin = "White Gamer is won\nHe have second Paris of: " + maxWhite;
            }else if (maxBlack > maxWhite) {
                howWin = "Black Gamer is won\nHe have second Paris of: " + maxBlack;
            }else if (maxBlack == maxWhite){
                maxCard();
            }else{
                howWin = "Dead Heat";
            }
        }
        return howWin;
    }
}









