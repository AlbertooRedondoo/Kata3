package software.ulpgc.kata3.architecture.control;

import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.architecture.model.FilterTitle;
import software.ulpgc.kata3.architecture.model.Title;
import software.ulpgc.kata3.architecture.model.YearFilterTitle;
import software.ulpgc.kata3.architecture.view.HistogramBarchart;

import java.util.List;
import java.util.Map;

public class BarchartCommand implements Command{
    private HistogramBarchart barchartDisplay;
    private final List<Title> titles;

    public BarchartCommand(HistogramBarchart barchartDisplay, List<Title> titles) {
        this.barchartDisplay = barchartDisplay;
        this.titles = titles;
    }

    @Override
    public void execute() {
        barchartDisplay.display(getBarchart());
    }

    private Barchart getBarchart() {
        Barchart barchart = new Barchart("Years");
        FilterTitle yeartitlefilter = new YearFilterTitle();
        Map<String, Integer> stats = yeartitlefilter.filter(titles);
        for(String stat : stats.keySet()){
            barchart.put(stat, stats.get(stat));
        }
        return barchart;
    }
}
