import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    void getWordsOrderedAlphabetically() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt", 1, 1);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        String[] resultvalue = new String[]{"wow"};
        assertArrayEquals(resultvalue, fileWordAnalyzer.getWordsOrderedAlphabetically().toArray());
        filePartReader.setup("test.txt", 1, 1000);
        resultvalue = new String[]{"damn", "does", "it", "lol", "tacocat", "this", "work", "wow"};
        assertArrayEquals(resultvalue, fileWordAnalyzer.getWordsOrderedAlphabetically().toArray());
    }

    @Test
    void getWordsContainingSubstring() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt", 1, 1000);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        String[] resultvalue = new String[]{"wow", "work"};
        assertArrayEquals(resultvalue, fileWordAnalyzer.getWordsContainingSubstring("wo").toArray());
        resultvalue = new String[]{"damn", "does"};
        assertArrayEquals(resultvalue, fileWordAnalyzer.getWordsContainingSubstring("d").toArray());
    }

    @Test
    void getStringsWhichPalindromes() {

        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt", 1, 1000);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        String[] resultvalue = new String[]{"wow", "tacocat","lol"};
        assertArrayEquals(resultvalue, fileWordAnalyzer.getStringsWhichPalindromes().toArray());
    }
}