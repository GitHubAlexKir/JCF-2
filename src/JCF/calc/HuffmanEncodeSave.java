package JCF.calc;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class HuffmanEncodeSave {
    private HashMap<Character,String > charHuff;
    private String encoded;
    private String fileName;

    public HuffmanEncodeSave(HashMap<Character, String> charHuff, String encoded,String fileName) {
        this.charHuff = charHuff;
        this.encoded = encoded;
        this.fileName = fileName;
    }

    public void save() throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(fileName + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.charHuff);
        oos.close();
        try (PrintWriter out = new PrintWriter(fileName + ".txt")) {
            out.println(encoded);
        }
    }
}
