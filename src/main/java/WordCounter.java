import java.util.*;

public class WordCounter {
    public String getCounter(String s) {

        if (Objects.isNull(s))
            throw new NullPointerException("Input cannot be null");

        String[] arrOfStr = s.toLowerCase().split("[\s.,]+");
        HashSet<String> h = new HashSet<>(Arrays.asList(arrOfStr));

        if (!h.contains(""))
            return String.format("Has %s unique words.", h.size());

        return "Has 0 unique words.";
    }
}
