import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    private static final String WORD_SPLIT = "\\s+";
    private static final String BLANK_SPACE = " ";
    private static final String CALCULATE_ERROR = "Calculate Error";
    public static final String DELIMITER = "\n";

    public String getResult(String inputStr) {
        if (inputStr.split(WORD_SPLIT).length==1) {
            return inputStr + " 1";
        } else {

            try {

                //split the input string with 1 to n pieces of spaces
                String[] words = inputStr.split(WORD_SPLIT);

                List<Input> wordInfos = new ArrayList<>();
                for (String word : words) {
                    Input input = new Input(word, 1);
                    wordInfos.add(input);
                }

                //get the wordMap for the next step of sizing the same word
                Map<String, List<Input>> wordMap =getListMap(wordInfos);

                List<Input> list = new ArrayList<>();
                for (Map.Entry<String, List<Input>> entry : wordMap.entrySet()) {
                    Input input = new Input(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                wordInfos = list;

                wordInfos.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner(DELIMITER);
                for (Input w : wordInfos) {
                    String s = w.getValue() + BLANK_SPACE +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
        }
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            }
            else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
