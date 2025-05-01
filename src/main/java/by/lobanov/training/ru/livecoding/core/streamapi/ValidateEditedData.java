package by.lobanov.training.ru.livecoding.core.streamapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Реализовать метод, который сравнит 2 List<Data> и выведет в консоль code тех Data, в который изменились version.
// Известно что списки приходящие на вход всегда имеют одинаковые длину и одинаковые code у Data,
// однако version и порядок элементов могут отличаться.
public class ValidateEditedData {

    public static void main(String[] args) {
        List<Data> dataList = List.of(
                new Data("22", "1"),
                new Data("11", "3"),
                new Data("33", "1")
        );
        List<Data> dataList1 = List.of(
                new Data("11", "3"),
                new Data("22", "3"),
                new Data("33", "2")
        );
        System.out.println(findEditedData(dataList, dataList1));
    }

    public static Collection<String> findEditedData(List<Data> data, List<Data> data2) {
        return Stream.concat(data.stream(), data2.stream())
                .collect(Collectors.toMap(
                        Data::getCode,
                        Data::getVersion,
                        (v1, v2) -> {
                            return v1.equals(v2) ? v2 : "-1";
                        }
                )).entrySet().stream()
                .filter(entry -> entry.getValue().equals("-1"))
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Collection<String> findEditedData2(List<Data> oldData, List<Data> newData) {
        Map<String, String> newVersions = newData.stream()
                .collect(Collectors.toMap(Data::getCode, Data::getVersion));

        return oldData.stream()
                .filter(data -> !data.getVersion().equals(newVersions.get(data.getCode())))
                .map(Data::getCode)
                .toList();
    }

    public static class Data {
        String code;
        String version;

        public Data(String code, String version) {
            this.code = code;
            this.version = version;
        }

        // ... getters, setters, equals, hashcode ...


        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
