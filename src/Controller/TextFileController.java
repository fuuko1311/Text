package Controller;

import Model.TextFileModel;
import View.TextFileView;

import java.io.*;
import java.util.List;

public class TextFileController {
    private TextFileModel model;
    private TextFileView view;

    public TextFileController(String inputFile, String outputFile) {
        this.model = new TextFileModel(inputFile, outputFile);
        this.view = new TextFileView();
    }

    public void normalizeTextFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(model.getInputFile()))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (!isLineEmpty(line)) {
                    String normalizedLine = normalizeLine(line, isFirstLine);
                    model.addLine(normalizedLine);
                    isFirstLine = false;
                }
            }
            writeToFile(model.getOutputFile());
            view.printMessage("Normalization successful.");
        } catch (FileNotFoundException ex) {
            view.printMessage("File not found.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeToFile(String outputFileName) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName, true)))) {
            List<String> normalizedLines = model.getLines();
            pw.println(String.join(System.getProperty("line.separator"), normalizedLines));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String normalizeLine(String line, boolean isFirstLine) {
        // Normalize spaces between words
        line = line.replaceAll("\\s+", " ");

        // Normalize spaces after comma, dot, and colon
        line = line.replaceAll(",\\s+", ", ");
        line = line.replaceAll("\\.\\s+", ". ");
        line = line.replaceAll(":\\s+", ": ");


        // Normalize spaces before and after quotes
        line = line.replaceAll("\\s+\"\\s+", "\"");


        // Capitalize the first character of the first word in the first line
        if (isFirstLine) {
            line = line.substring(0, 1).toUpperCase() + line.substring(1);
        }

        // Ensure there is a dot at the end of the text
        if (!line.endsWith(".")) {
            line += ".";
        }

        return line;
    }

    private boolean isLineEmpty(String line) {
        return line.trim().isEmpty();
    }
}
