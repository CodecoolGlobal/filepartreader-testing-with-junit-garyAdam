import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        setup("lol.txt",3,1);
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {

        if (fromLine>toLine || fromLine<1) throw new IllegalArgumentException();
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }

    public String read(){

        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    public String readLines(){

        String read = read();
        String[] lines = read.split("\n");
        String filtered = "";
        for (int i = fromLine-1; i <= toLine-1;i++)
        {
            filtered+=lines[i];
        }
        return filtered;
    }

}

