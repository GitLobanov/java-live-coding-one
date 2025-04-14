package by.lobanov.training.ru.review.serivice;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public class MyServiceJSONArray {

    /*
     Провести код ревью
    @Service
    @Slf4j
    public class MyService {
        private static ArrayList<String> words;
        private static final int wordsCount = 10;

        public static ArrayList<String> getWords() {
            words = new ArrayList<>();
            String response = requestRandomWord();
            log.debug("getWords: " + response);
            for (int i = 0; i < wordsCount; i++){
                try {
                    words.add(new JSONArray(response).getJSONObject(i).getString("word"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return words;
            }
            return null;
        }

        private static String requestRandomWord () {
            return "";
        }
    }
     */
}
