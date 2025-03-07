package by.lobanov.training.demos.demo16;

public class LC25 {


    public static void main(String[] args) {
        System.out.println(validatePin("1234"));
        System.out.println(validatePin("12345"));
        System.out.println(validatePin("123456"));
    }

    // Валидация пин-кода. Проверить валиден ли пин-код (должен состоять из 4 либо 6 цифр)
    public static boolean validatePin(String pin) {

        return pin.matches("([0-9]{4})|([0-9]{6})");
    }
}
