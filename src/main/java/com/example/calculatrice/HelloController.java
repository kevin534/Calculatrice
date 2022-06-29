package com.example.calculatrice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    TextArea inputCaracter = new TextArea();

    @FXML
    protected void onHelloButtonClick() {
        String input= inputCaracter.getText();
        try {
            Double result = null;
            Model app = new Model(input);
             result =  app.evaluationOfExpression(input);

            welcomeText.setText(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void onResetButtonClick() {

        inputCaracter.clear();

        welcomeText.setText("");
    }

}