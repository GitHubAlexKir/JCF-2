package JCF;

import JCF.calc.EenFrequentie;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private TextArea ta_input;
    @FXML
    private TextArea ta_output;

    @FXML
    private void eenFrequentie(){

        Thread t1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            EenFrequentie task = new EenFrequentie(ta_input.getText());
            String output = task.start();
            long stop = System.currentTimeMillis();
            long time = stop - start;
            ta_output.setText("tijd berekening "  + time + " ms\n" + output);
        });
        t1.start();
    }

}
