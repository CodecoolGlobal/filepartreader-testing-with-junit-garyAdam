import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        List<String> split = splitToList();

        Collections.sort(split);
        return split;
    }

    public List<String> getWordsContainingSubstring(String subString) {
        List<String> split = splitToList();
        split = split
                .stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());
        return split;
    }

    public List<String> getStringsWhichPalindromes() {
        List<String> split = splitToList();
        List<String > result = new ArrayList();
        for (String word : split) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(word);
            String current = stringBuilder.toString();
            String reversed = stringBuilder.reverse().toString();
            if (current.equals( reversed)) {
                result.add(current);
            }
        }
        return result;

    }


    private List<String> splitToList() {
        List<String> spllited =  new ArrayList<>(Arrays.asList(filePartReader.readLines().split(" ")));
        while (spllited.contains("\n")) {
            spllited.remove("\n");
        }
        List<String> stripped = new ArrayList<>();
        for (String word : spllited) {
            String stringword = (String) word;
            stringword = stringword.replaceAll("\n","");
            stripped.add(stringword);

        }
        return stripped;
    }
}
