package by.lobanov.training.demos.demo19;

// в метод parse передается строка вида key1=val1;key2=val2;key2=val3... и нужно это все упаковать
// каким то образом чтобы getRecord возвращала начальную строку
// getValue сложность O(1)
// getRecord - кэшируем строку в методе parse в переменную String и возвращаем
// 1 доп - Сделать так, чтобы могли храниться дубликаты значений (решал через HashMap<String, String> переделал -> HashMap<String, List<String>>)
// 2 доп сделать класс иммутабельным (метод parse = конструктор и все вспомогательные поля private final геттеры не создавать)

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseHolder {

    private Map<String, String> map = new HashMap<>();
    private String record;

    // key1=val1;key2=val2;key2=val3
    public void parse(String str) {
        record = str;
        map = Arrays.stream(str.split(";"))
                .map(el -> el.split("="))
                .collect(Collectors.toMap(el -> el[0], el -> el[1], (s, s2) -> s));
    }

    public String getRecord() {
        return record;
    }

    // За O(1)
    public String getValue(String key) {
        return map.getOrDefault(key, "null");
    }

    public static void main(String[] args) {
        ParseHolder parseHolder = new ParseHolder();
        parseHolder.parse("key1=val1;key2=val2;key2=val3");
        System.out.println(parseHolder.getRecord());
        System.out.println(String.format("value for key1 is %s", parseHolder.getValue("key1")));
    }

}
