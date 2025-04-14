package by.lobanov.training.ru.review.equals;

import java.util.HashSet;
import java.util.Objects;

public class MyObjectEquals {

    public static void main (String[] args) {
        MyObject obj = new MyObject(10);
        HashSet<MyObject> set = new HashSet<>();
        set.add(obj);
        obj.set(1000);

        System. out. println(set.contains(obj));
        System. out. println(set.contains(new MyObject(10)));
        System. out. println(set.contains(new MyObject(1000)));
        System. out. println(Objects.equals(new MyObject(1000), obj));
        System. out. println(obj.equals(new MyObject(1000)));
    }
    static class MyObject {
        private int i;
        public MyObject(int i) {
            set(i);
        }
        public void set(int i) {
            this.i = i;
        }

        public int hashCode() {
            return i;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            MyObject myObject = (MyObject) object;
            return i == myObject.i;
        }
    }
}
