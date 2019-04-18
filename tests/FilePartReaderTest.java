import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    void setup() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt",1,3);
        assertThrows(IllegalArgumentException.class,()->filePartReader.setup("test.txt",0,3));
        assertThrows(IllegalArgumentException.class,()->filePartReader.setup("test.txt",2,1));

    }

    @Test
    void read() throws Exception {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt",1,3);
        assertEquals("wow \n damn this does it work\n \n \n \n tacocat\n lol\n",filePartReader.read());
    }

    @Test
    void readLines() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt",1,1);
        assertEquals("wow \n",filePartReader.readLines());
        filePartReader.setup("test.txt",1,3);
        assertEquals("wow \n damn this does it work\n \n",filePartReader.readLines());
        filePartReader.setup("test.txt",1,300);
        assertEquals("wow \n damn this does it work\n \n \n \n tacocat\n lol\n",filePartReader.readLines());
        filePartReader.setup("test.txt",100,300);
        assertEquals("",filePartReader.readLines());


    }
}