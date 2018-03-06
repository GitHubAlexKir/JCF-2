package JCF.calc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class EenFrequentie implements Callable {
    private String input;
    private List<Character> characters;

    public EenFrequentie(String input){
        this.input = input;
    }

    @Override
    public String call() throws Exception {
        input = input.replaceAll("\\s","");
        this.characters = this.input.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();

        /*
            Loop over all words.
        */

        for(Character word: this.characters) {

            /*
                Check if word already exists in wordCount.
            */

            Integer count = charCount.get(word);

            /*
                Put the word in wordCount, with the amount of times it's presented.
            */

            charCount.put(word, (count==null) ? 1 : count+1);
        }

        /*
            Create the string. And sort it.
        */

        StringBuilder stringBuilder = new StringBuilder();
        charCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(x -> stringBuilder.append(x + "\n"));

        return stringBuilder.toString();
    }
}
