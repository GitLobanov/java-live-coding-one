package by.lobanov.training.demos.demo16;

public class LC24 {


    public static void main(String[] args) {

    }

    // Проверить, что строка является изограммой (в строке НЕТ повторяющихся букв) (игнорировать регистр)
// Например: "Dermatoglyphics" --> true
// "aba" --> false
// "moOse" --> false (регистр нам не важен, тут две буквы О)
    public static boolean isIsogram(String str) {
        return str.length() == str.toLowerCase().chars()
                .distinct()
                .count();
    }
}
