import java.util.*;
import java.util.stream.Collectors;

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
        return splitToList()
                .stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() {
        return splitToList()
                .stream()
                .filter(this::isItPalindrome)
                .collect(Collectors.toList());

    }
    private boolean isItPalindrome(String word){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word);
        String current = stringBuilder.toString();
        String reversed = stringBuilder.reverse().toString();
        return current.equals(reversed);
    }


    private List<String> splitToList() {
        return Arrays.stream(filePartReader.readLines().split(" "))
                .filter((word) -> !word.equals("\n"))
                .map((word) -> word.replaceAll("\n", ""))
                .collect(Collectors.toList());
    }
}
