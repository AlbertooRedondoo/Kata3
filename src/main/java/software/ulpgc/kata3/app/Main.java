package software.ulpgc.kata3.app;


import software.ulpgc.kata3.architecture.control.BarchartCommand;
import software.ulpgc.kata3.architecture.control.Mainframe;
import software.ulpgc.kata3.architecture.io.FileTitleLoader;
import software.ulpgc.kata3.architecture.io.TitleDeserializer;
import software.ulpgc.kata3.architecture.io.TitleLoader;
import software.ulpgc.kata3.architecture.io.TsvTitleDeserializer;
import software.ulpgc.kata3.architecture.model.Title;
import software.ulpgc.kata3.architecture.model.FilterTitle;
import software.ulpgc.kata3.architecture.model.YearFilterTitle;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/alber/desktop/title.basics.tsv");
        TitleDeserializer titleDeserilizer = new TsvTitleDeserializer();
        TitleLoader titleLoader = new FileTitleLoader(file, titleDeserilizer);
        List<Title> titleList = titleLoader.load();
        Mainframe mainframe = new Mainframe();
        mainframe.put("chart", new BarchartCommand(mainframe.getBarchartDisplay(), titleList));
        mainframe.setVisible(true);

    }
}
