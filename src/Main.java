import Controller.TextFileController;
import Model.TextFileModel;
import View.TextFileView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Controller.TextFileController.*;

public class Main {
/*public static void main(String[] args) {
        TextFileModel model = new TextFileModel();
        TextFileView view = new TextFileView();
        //TextFileController controller = new TextFileController(model, view);

        // Specify your input and output file names
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        TextFileController normalizer = new TextFileController(inputFileName, outputFileName);
        normalizer.normalizeTextFile();

        // Read, normalize, and write to the file
        //controller.readAndNormalizeFile(inputFileName, outputFileName);
    }*/


    public static void main(String[] args) {
        // Specify your input and output file names
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        // Uncomment the line below to create an instance of TextFileController
        TextFileController normalizer = new TextFileController(inputFileName, outputFileName);
        normalizer.normalizeTextFile();
    }
}
