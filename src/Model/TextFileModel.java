package Model;

import java.util.ArrayList;
import java.util.List;

public class TextFileModel {
    private final String inputFile;
    private final String outputFile;
    private List<String> lines;

    public TextFileModel(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.lines = new ArrayList<>();
    }

    public List<String> getLines() {
        return lines;
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }
}