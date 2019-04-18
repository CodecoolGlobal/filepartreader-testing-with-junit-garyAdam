import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "hahano";
        fromLine = -1;
        toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
        if (fromLine>toLine || fromLine<1) throw new IllegalArgumentException();

    }

    public String read() throws Exception{

        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    public String readLines (){
        String text="";
        try {
            text = read();
        }catch (Exception e){

        }
        String[] lines = text.split("(?<=\n)");
        String filtered = "";
        for (int i = fromLine-1; i <= Math.min(toLine-1,lines.length-1);i++)
        {
            filtered+=lines[i];
        }
        return filtered;
    }

}

