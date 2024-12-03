package software.ulpgc.kata3.architecture.model;

import java.util.HashMap;
import java.util.List;
import java.util.HashMap;

public class YearFilterTitle implements FilterTitle{

    @Override
    public HashMap<String, Integer> filter(List<Title> titles) {
        HashMap<String, Integer> yearCountMap = new HashMap<>();

        // Iterar sobre los títulos y contar los años
        for (Title title : titles) {
            String year = String.valueOf(title.getYear());  // Convertir el año a String
            yearCountMap.put(year, yearCountMap.getOrDefault(year, 0) + 1);  // Incrementar el contador
        }

        // Eliminar el año "0" (si se presenta)
        yearCountMap.remove("0");

        return yearCountMap;
    }
}
