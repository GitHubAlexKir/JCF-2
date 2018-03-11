package JCF.calc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class HuffmanDecode {
    private FileInputStream fis;
    private String encoded;
    private HashMap<Character,String> charHuff;

    public HuffmanDecode(FileInputStream fis, String encoded) {
        this.fis = fis;
        this.encoded = encoded;
    }

    public String decode() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(fis);
        charHuff = (HashMap<Character,String>) ois.readObject();
        ois.close();
        String decode = "";
        while (encoded.length() > 0)
        {
            for(Map.Entry<Character, String> entry : charHuff.entrySet()) {
                Character key = entry.getKey();
                String value = entry.getValue();
                int place = encoded.indexOf(value);
                if (place == 0)
                {
                    decode += key;
                    encoded = encoded.substring(value.toString().length());
                }
            }
        }
        return decode;
    }
}
