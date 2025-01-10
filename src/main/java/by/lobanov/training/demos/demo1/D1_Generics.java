package by.lobanov.training.demos.demo1;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://habr.com/ru/companies/sberbank/articles/416413/">Пришел, увидел, обобщил: погружаемся в Java Generics</a>
 */
public class D1_Generics {

    // Java Generics — это одно из самых значительных изменений за всю историю языка Java.
    // «Дженерики», доступные с Java 5, сделали использование Java Collection Framework проще, удобнее и безопаснее.
    @Data
    public static class Account {
        long amount;
    }

    // До появления «дженериков» метод вычисления суммы выглядел так:
    public long getSum(List accounts) {
        long sum = 0;

        // Мы итерировались, пробегались по списку аккаунтов и проверяли,
        // действительно ли элемент из этого списка является экземпляром класса Account — то есть счетом пользователя.
        // Выполняли приведение типа нашего объекта класса Account и метод getAmount, который возвращал сумму на этом счете.
        for (int i = 0, n = accounts.size(); i < n; i++) {
            Object account = accounts.get(i);
            if (account instanceof Account) {
                sum += ((Account) account).getAmount();
            }
        }

        return sum;
    }

    // С появлением Generics необходимость в проверке и приведении типа отпала:
    public long getSum2(List<Account> accounts) {
        long sum = 0;

        for (Account account : accounts) {
            sum += account.getAmount();
        }

        return sum;
    }

    /**
     * Принцип подстановки
     * <p>
     * Принцип подстановки Барбары Лисков – специфичное определение подтипа в объектно-ориентированном программировании.
     * Идея Лисков о «подтипе» дает определение понятия замещения: если S является подтипом T,
     * тогда объекты типа T в программе могут быть замещены объектами типа S
     * без каких-либо изменений желательных свойств этой программы.
     */
    private void exampleLiskovSubstitutionPrinciple() {
        Number n = Integer.valueOf(42);
        List<Number> aList = new ArrayList<>();
        Collection<Number> aCollection = aList;
        Iterable<Number> iterable = aCollection;
    }

    /**
     * Ковариантность, контравариантность и инвариантность
     * <br>
     * Ковариантность — это сохранение иерархии наследования исходных типов в производных типах в том же порядке.
     * Например, если Кошка — это подтип Животные, то Множество<Кошки> — это подтип Множество<Животные>.
     * Следовательно, с учетом принципа подстановки можно выполнить такое присваивание:
     * Множество<Животные>  = Множество<Кошки>
     * <br>
     * Контравариантность — это обращение иерархии исходных типов на противоположную в производных типах.
     * Например, если Кошка — это подтип Животные, то Множество<Животные> — это подтип Множество<Кошки>.
     * Следовательно,  с учетом принципа подстановки можно выполнить такое присваивание:
     * Множество<Кошки> = Множество<Животные>
     * <br>
     * Инвариантность — отсутствие наследования между производными типами. Если Кошка — это подтип Животные,
     * то Множество<Кошки> не является подтипом Множество<Животные>
     * и Множество<Животные> не является подтипом Множество<Кошки>.
     * <br>
     * Массивы в Java ковариантны. Тип S[] является подтипом T[], если S — подтип T. Пример присваивания:
     * String[] strings = new String[] {"a", "b", "c"};
     * Object[] arr = strings;
     * <br>
     * «Дженерики» инвариантны. Приведем пример:
     */
    private void genericsInvariant() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        // List<Number> nums = ints; // compile-time error. Проблема обнаружилась на этапе компиляции
        // nums.set(2, 3.14);
        assert ints.toString().equals("[1, 2, 3.14]");

        /**
         * Если взять список целых чисел, то он не будет являться ни подтипом типа Number, ни каким-либо другим подтипом.
         * Он является только подтипом самого себя. То есть List <Integer> — это List<Integer> и ничего больше.
         * Компилятор позаботится о том, чтобы переменная ints, объявленная как список объектов класса Integer,
         * содержала только объекты класса Integer и ничего кроме них.
         * На этапе компиляции производится проверка, и у нас в рантайме уже ничего не упадет.
         */
    }

    /**
     * Wildcards
     * Всегда ли Generics инварианты? Нет. Приведу примеры:
     */
    private void genericsCovariant() {
        List<Integer> ints = new ArrayList<Integer>();
        List<? extends Number> nums = ints;

        // Это ковариантность. List<Integer> — подтип List<? extends Number>
    }

    private void genericsContrvariant() {
        List<Number> nums = new ArrayList<Number>();
        List<? super Integer> ints = nums;

        // Это контравариантность. List<Number> является подтипом List<? super Integer>.
    }

    /**
     * Запись вида "? extends ..." или "? super ..." — называется wildcard или символом подстановки,
     * с верхней границей (extends) или с нижней границей (super).
     * List<? extends Number> может содержать объекты,
     * класс которых является Number или наследуется от Number.
     * List<? super Number> может содержать объекты,
     * класс которых Number или  у которых Number является наследником (супертип от Number).
     */

    // Почему в примере ниже compile-time error? Какое значение можно добавить в список nums?
    private void wildcardExtendsError() {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        // nums.add(3.14); // compile-time error

        // Если контейнер объявлен с wildcard ? extends, то можно только читать значения.
        // В список нельзя ничего добавить, кроме null.
        // Для того чтобы добавить объект в список нам нужен другой тип wildcard — ? super
    }

    // Почему нельзя получить элемент из списка ниже?
    public static <T> T getSuperFirst(List<? super T> list) {
        // return list.get(0); // compile-time error
        return (T) list.get(0);
    }

    // Нельзя прочитать элемент из контейнера с wildcard ? super, кроме объекта класса Object
    public static <T> Object getFirst(List<? super T> list) {
        return list.get(0);
    }

    // The Get and Put Principle или PECS (Producer Extends Consumer Super)

    /**
     * Если мы объявили wildcard с extends, то это producer.
     * Он только «продюсирует», предоставляет элемент из контейнера, а сам ничего не принимает.
     * Если же мы объявили wildcard с super — то это consumer.
     * Он только принимает, а предоставить ничего не может.
     */
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        /**
         * Метод осуществляет копирование элементов из исходного списка src в список dest.
         * src — объявлен с wildcard ? extends и является продюсером, а dest — объявлен с wildcard ? super и является потребителем.
         * Учитывая ковариантность и контравариантность wildcard, можно скопировать элементы из списка ints в список nums:
         */
        List<Number> nums = Arrays.<Number>asList(4.1F, 0.2F);
        List<Integer> ints = Arrays.asList(1, 2);
        Collections.copy(nums, ints);

        // Если же мы по ошибке перепутаем параметры метода copy и попытаемся выполнить копирование из списка nums в список ints,
        // то компилятор не позволит нам это сделать:
        // Collections.copy(ints, nums); // Compile-time error
    }


    /**
     * <?> и Raw типы
     * Ниже приведен wildcard с неограниченным символом подстановки.
     * Мы просто ставим <?>, без ключевых слов super или extends:
     */
    private void printCollection(Collection<?> c) {
        // a wildcard collection
        for (Object o : c) {
            System.out.println(o);
        }
    }

    /**
     * На самом деле такой «неограниченный» wildcard все-таки ограничен, сверху.
     * Collection<?>  — это тоже символ подстановки, как и "? extends Object".
     * Запись вида Collection<?> равносильна Collection<? extends Object> ,
     * а значит — коллекция может содержать объекты любого класса,
     * так как все классы в Java наследуются от Object – поэтому подстановка называется неограниченной.
     * <p>
     * Если мы опустим указание типа, например, как здесь:
     * ArrayList arrayList = new ArrayList();
     * то, говорят, что ArrayList — это Raw тип параметризованного ArrayList<T>.
     * Используя Raw типы, мы возвращаемся в эру до дженериков и сознательно отказываемся от всех фич,
     * присущих параметризованным типам.
     */

    private void checkedUncheckedGenerics() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList = strings; // Ok
        strings = arrayList; // Unchecked assignment
        arrayList.add(1); //unchecked call
    }

    // Wildcard Capture


}
