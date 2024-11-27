package main.project.controller;

import main.project.RegexUtility;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
    @FXML private TextArea inputTextArea;
    @FXML private TextField regexField;
    @FXML private TextField replaceField;
    @FXML private TextArea outputTextArea;

    public void handleFindMatches() {
        String inputText = inputTextArea.getText();
        String regex = regexField.getText();
        String result = RegexUtility.findMatches(inputText, regex);
        outputTextArea.setText(result);
    }

    public void handleReplaceMatches() {
        String inputText = inputTextArea.getText();
        String regex = regexField.getText();
        String replacement = replaceField.getText();
        String result = RegexUtility.replaceMatches(inputText, regex, replacement);
        outputTextArea.setText(result);
    }

    public void handleClear() {
        inputTextArea.clear();
        regexField.clear();
        replaceField.clear();
        outputTextArea.clear();
    }

    public void handleExit() {
        System.exit(0);
    }
}
