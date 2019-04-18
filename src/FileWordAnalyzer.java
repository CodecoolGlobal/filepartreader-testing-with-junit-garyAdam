import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically() {
        ArrayList split = splitToList();
        Collections.sort(split);
        return split;
    }

    public List getWordsContainingSubstring(String subString) {
        ArrayList split = splitToList();
        return Stream.of(split).filter(word -> word.contains(subString)).collect(Collectors.toCollection(ArrayList::new));

    }

    public List getStringsWhichPalindromes() {
        ArrayList split = splitToList();
        ArrayList result = new ArrayList();
        for (Object word : split) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(word);
            if (stringBuilder == stringBuilder.reverse()) {
                result.add(stringBuilder);
            }
        }
        return result;

    }


    private ArrayList splitToList() {
        return new ArrayList<>(Arrays.asList(filePartReader.readLines().split(" ")));
    }
}
