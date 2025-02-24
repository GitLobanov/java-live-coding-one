package by.lobanov.training.demos.demo8;

public class LC10 {

    /**
     * Ребенок играет с мячом на n-м этаже высотного здания. Высота этого этажа над уровнем земли h известна.
     * Он выбрасывает мяч из окна. Мяч отскакивает (например) на две трети своей высоты (отскок 0,66).
     * Его мать смотрит в окно на высоте 1,5 метра от земли.
     * Сколько раз мать увидит, как мяч пролетает перед ее окном (в том числе когда он падает и подпрыгивает)?
     *
     * Для успешного эксперимента должны быть соблюдены три условия:
     *
     *     Плавающий параметр «h» в метрах должен быть больше 0.
     *     Плавающий параметр «bounce» (отскок) должен быть больше 0 и меньше 1.
     *     Плавающий параметр «window» (окно) должен быть меньше h.
     *
     * Если все три условия выше выполнены, верните положительное целое число, в противном случае верните -1.
     *
     * Примечание:
     * Мяч можно увидеть только в том случае, если высота отскакивающего мяча строго больше параметра окна.
     *
     * Примеры:
     * - h = 3, bounce = 0.66, window = 1.5, result is 3
     * - h = 3, bounce = 1, window = 1.5, result is -1
     */

    public static void main(String[] args) {
        System.out.println(bouncingBall(100, 0.99, 1));
    }

    public static int bouncingBall(double h, double bounce, double window) {
        if (h > 0 && (0 < bounce && bounce < 1) && window < h) {
            int times = 0;
            while (h > window) {
                times++;
                h = h * bounce;
                if(h>window) {
                    times++;
                }
            }
            return times;
        }

        return -1;
    }
}
