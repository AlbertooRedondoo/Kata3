package software.ulpgc.kata3.architecture.model;

import java.util.HashMap;
import java.util.List;

public interface FilterTitle {
    HashMap<String, Integer> filter(List<Title> titleList);
}