package software.ulpgc.kata3.architecture.view;

import org.jfree.chart.ChartPanel;
import software.ulpgc.kata3.architecture.model.Barchart;

import javax.swing.*;

public class JFreeHistogramBarchartDisplay extends JPanel implements HistogramBarchart {


    @Override
    public void display(Barchart barchart) {
        removeAll();
        add(new ChartPanel(JFreeBarchartAdapter.adapt(barchart)));
        revalidate();
    }
}
