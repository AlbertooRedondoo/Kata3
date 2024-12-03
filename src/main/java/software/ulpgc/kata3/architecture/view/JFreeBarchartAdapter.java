package software.ulpgc.kata3.architecture.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.architecture.model.Barchart;

public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart){
        return ChartFactory.createBarChart("Movies", barchart.getTitle(), "Number of films", datasetOf(barchart));
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String categorie : barchart.categories()){
            dataset.addValue(barchart.get(categorie), "", categorie);
        }
        return dataset;
    }
}
