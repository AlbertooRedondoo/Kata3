package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Title;

public class TsvTitleDeserializer implements TitleDeserializer {

    @Override
    public Title deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Title deserialize(String[] split) {
        return new Title(split[3],
                toInt(split[5]),
                toInt(split[7]));
    }

    private int toInt(String field) {
        return field.equals("\\N")?0 : Integer.parseInt(field);
    }
}