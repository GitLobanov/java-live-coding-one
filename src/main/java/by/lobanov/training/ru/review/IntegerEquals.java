package by.lobanov.training.ru.review;

public class IntegerEquals {

    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1.equals(i2));

        Integer j1 = 128;
        Integer j2 = j1;
        System.out.println(j1.equals(j2));

        Integer h1 = 128;
        System.out.println(h1.equals(128));

        Integer v1 = 128;
        System.out.println(v1 == 128);

        Integer m1 = 128;
        //System.out.println(m1.hashCode()==128.hashCode());

        Integer r1 = 128;
        Integer r2 = 128;
        System.out.println(i1.hashCode() == i2.hashCode());

        Integer d1 = 128;
        Integer d2 = 128;
        //System.out.println(d1.hashCode().equals(d2.hashCode()));

        Integer s1 = 128;
        Integer s2 = 128;
        System.out.println(s1 == 12);

        Integer l1 = 127;
        Integer l2 = 127;
        System.out.println(l1 == l2);

        int b1 = 128;
        int b2 = 128;
        System.out.println(b1 == b2);
    }
}
