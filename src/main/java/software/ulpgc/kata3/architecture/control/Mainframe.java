package software.ulpgc.kata3.architecture.control;

import software.ulpgc.kata3.architecture.view.HistogramBarchart;
import software.ulpgc.kata3.architecture.view.JFreeHistogramBarchartDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Mainframe extends JFrame {
    private final Map<String, Command> comands;
    private HistogramBarchart barchartDisplay;

    public Mainframe()throws HeadlessException{
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setTitle("Statistics");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(getJFreeBarchartDisplay());
        add(menu(), BorderLayout.NORTH);
        this.comands = new HashMap<>();
        setVisible(true);

    }

    private Component menu() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(showChart());
        return panel;
    }

    private JButton showChart() {
        JButton button = new JButton("chart");
        button.addActionListener(e -> comands.get("chart").execute());
        return button;
    }

    private JPanel getJFreeBarchartDisplay() {
        JFreeHistogramBarchartDisplay display = new JFreeHistogramBarchartDisplay();
        barchartDisplay = display;
        return display;
    }

    public void put(String chart, Command command) {
        comands.put(chart, command);
    }

    public HistogramBarchart getBarchartDisplay() {
        return barchartDisplay;
    }
}
