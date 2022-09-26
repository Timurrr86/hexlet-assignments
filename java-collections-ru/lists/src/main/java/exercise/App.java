package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        List<String> list = new ArrayList<>();
        String[] setSymbols = symbols.toLowerCase().split("");
        String[] wordSymbols = word.toLowerCase().split("");
        //наполняем список набором символов
        for (var setSymbol : setSymbols) {
            list.add(setSymbol);
        }
        //проверяем вхождение
        //удаляем символ из списка для избежания повторов
        for (int i = 1; i < wordSymbols.length; i++) {
            if (!list.remove(wordSymbols[i])) {
                return false;
            }
        }
        return true;
    }
}

//END
