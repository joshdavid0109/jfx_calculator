package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Button CEButton;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private Button buttonEight;

    @FXML
    private Button buttonFive;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonNine;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonSeven;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonThree;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonZero;

    @FXML
    private Button decimalButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button equalsButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button moduloButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button plusOrMinusButton;

    @FXML
    private Label textFieldAnswer;

    private double operand1 = 0;
    private double operand2 = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;



    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
        try {
            // Load the second view (View2.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("second-view.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene to the second view
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleNumberClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();

        if (!isOperatorPressed) {
            textFieldAnswer.setText(textFieldAnswer.getText() + buttonText);
        } else {
            textFieldAnswer.setText(buttonText);
            isOperatorPressed = false;
        }
    }

    @FXML
    void handleOperatorClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        operator = clickedButton.getText();
        operand1 = Double.parseDouble(textFieldAnswer.getText());
        textFieldAnswer.setText(textFieldAnswer.getText() + operator);
        isOperatorPressed = true;
    }




    @FXML
    void calculate(ActionEvent event) {
        operand2 = Double.parseDouble(textFieldAnswer.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    textFieldAnswer.setText("Error");
                    return;
                }
                break;
            case "%":
                result = operand1 % operand2;
                break;
        }

        textFieldAnswer.setText(String.valueOf(result));
        operand1 = result; // Allow chaining calculations
        isOperatorPressed = false;

    }

    @FXML
    void ce(ActionEvent event) {
        operand1 = 0;
        operand2 = 0;
        operator = "";
        isOperatorPressed = false;
        textFieldAnswer.setText("");
    }

    @FXML
    void divide(ActionEvent event) {

    }

    @FXML
    void minus(ActionEvent event) {

    }

    @FXML
    void modulo(ActionEvent event) {

    }

    @FXML
    void multiply(ActionEvent event) {

    }

}
