package by.lobanov.training.ru.livecoding.core.regex;

public class SearchSwiftCodeInText {

    public static void main(String[] args) {
        /*
        "DEUTDEFF"
        "DEUTDEFF500"
        "COBADEFFXXX"
         */

        /*
        "DEUT123FF"  // неверный формат
        "DEUTDEFF5"  // некорректная длина
        "DEUTDEFF5!!"  // запрещённые символы
         */

        //\b[A-Z]{6}[A-Z0-9]{2}(?:[A-Z0-9]{3})?\b
    }

}
