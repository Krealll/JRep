package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements View { //HERE IS TEXT VALIDATION

    @FXML
    private TextField textField= new TextField("0");
    private Model model;
    public Controller(){
        model=new Model(this);
    }

    @FXML
    private void onActionBtnDel(ActionEvent event){
        Button button = (Button) event.getSource();
        String del  = button.getText();
        switch (del) {
            case "C":
                del = model.Cdel();
                textField.setText(del);
                break;
            case "CE":
                del=textField.getText();
                del=model.CEdel(del);
                textField.setText(del);
                break;
            case "◄":
                del =textField.getText();
                del = model.del(del);
                textField.setText(del);
                break;
        }
    }

    @FXML
    private void onActionBtnNum(ActionEvent event){
        Button button = (Button)event.getSource();
        String num=button.getText();
        textField.setText(model.processNum(num));
    }

    @FXML
    private void onActionBtnBinOperator(ActionEvent event){
        Button button = (Button)event.getSource();
        String num=button.getText();
        textField.setText(model.processBinOp(num));
    }

    @FXML
    private void onActionBtnUnOperator(ActionEvent event){
        Button button = (Button)event.getSource();
        String num=button.getText();
       // model.processUnOp(num);
    }

    @FXML
    private void onActionBtnEqu(ActionEvent event){
        textField.setText(model.getResult(textField.getText()));
    }

    @Override
    public String getView(){
        return textField.getText();
    }

    @Override
    public void setView(String string){
        textField.setText(string);
    }


    @FXML  // <== perhaps you had this missing??
    void keyPressed(KeyEvent event) {
        switch (event.getCharacter()) {
            case"\u007F":
                textField.setText(model.CEdel(textField.getText()));
                break;
            case"C":
                textField.setText(model.Cdel());
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
              textField.setText(model.processNum(event.getCharacter()));
              break;
            case "+":
            case "-":
            case "*":
            case "/":
                textField.setText(model.processBinOp(event.getCharacter()));
                break;
            case "=":
            case "\r":
                textField.setText(model.getResult(textField.getText()));
                break;
            case"\b":
                textField.setText(model.del(textField.getText()));
                break;
            default:
                textField.setText("NONE");
                break;
        }
    }

}
