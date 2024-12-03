package software.ulpgc.kata3.architecture.model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Barchart {
    private final String title;
    private Map<String, Integer> counts;

    public Barchart(String title) {
        this.title = title;
        this.counts = new TreeMap<>();
    }

    public String getTitle() {
        return title;
    }

    public void put(String key, Integer value){
        counts.put(key, value);
    }
    public Set<String> categories(){
        return counts.keySet();
    }
    public int get(String key){
        return counts.getOrDefault(key, 0);
    }
}
