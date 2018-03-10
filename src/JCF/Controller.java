package JCF;

import JCF.calc.EenFrequentie;
import JCF.calc.Huffman;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Controller {
    @FXML
    private TextArea ta_input;
    @FXML
    private TextArea ta_output;

    @FXML
    private void eenFrequentie() {

        long start = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        EenFrequentie task = new EenFrequentie(ta_input.getText());
        Future<String> futureEenFrequentie = pool.submit(task);
        String output = null;
        try {
            output = futureEenFrequentie.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long stop = System.currentTimeMillis();
        long time = stop - start;
        ta_output.setText("tijd berekening " + time + " ms\n" + output);


    }
    @FXML
    private void tweeHuffman() {

        long start = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Huffman task = new Huffman(ta_input.getText());
        Future<String> futureHuffman = pool.submit(task);
        String output = null;
        try {
            output = futureHuffman.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long stop = System.currentTimeMillis();
        long time = stop - start;
        ta_output.setText("tijd berekening " + time + " ms\n" + output);


    }
}
