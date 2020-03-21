package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class Controller implements View { //HERE IS TEXT VALIDATION

    @FXML
    private TextArea textArea = new TextArea("0");
    private Model model;
    private boolean onlyOperatorAllowed,
                    newLine,
                    stopFlag;
    public Controller(){
        model=new Model(this);
    }

    @FXML
    private void onActionBtnDel(ActionEvent event){
        Button button = (Button) event.getSource();
        String del  = button.getText();
        switch (del) {
            case "C":
                newLine=false;
                setView(model.Cdel());
                break;
            case "CE":
                model.CEdel(getView());
                setView(del);
                break;
            case "◄":
                del =getView();
                if (del.length()<=20)
                    newLine=false;
                del = model.del(del);
                setView(del);
                break;
        }
    }

    @FXML
    private void onActionBtnNum(ActionEvent event){
        Button button = (Button)event.getSource();
        String num=button.getText();
        setView(model.processNum(num));
    }

    @FXML
    private void onActionBtnBinOperator(ActionEvent event){
        Button button = (Button)event.getSource();
        String num=button.getText();
        setView(model.processBinOp(num));
    }

    @FXML
    private void onActionBtnUnOperator(ActionEvent event){
        Button button = (Button)event.getSource();
        String num=button.getText();
       // model.processUnOp(num);
    }

    @FXML
    private void onActionBtnEqu(ActionEvent event){
        String temp =model.getResult(getView());
        newLine=false;
        if(temp.length()>19){
            model.Cdel();
            temp="ERROR:BIG_NUMBER";
        }
        setView(temp);
    }

    @Override
    public String getView(){
        String string=textArea.getText();
        string=string.replace("\n","");
        if(string.length()>39){
          stopFlag=true;
        }
        if (string.length()==19){
            onlyOperatorAllowed =true;
            if(!(string.charAt(18)>='0'&&string.charAt(18)<='9')){
                onlyOperatorAllowed=false;
                newLine=true;
            }
        }
        else {
            onlyOperatorAllowed =false;
        }

        return  string;
    }

    @Override
    public void setView(String string){
        if (string.length()>19&&onlyOperatorAllowed){
            switch (string.charAt(string.length()-1)){
                case '*':
                case '/':
                case '+':
                case '-':
                onlyOperatorAllowed =false;
                newLine=true;
                break;
                default:
            }
        }
        if(newLine){
            if(string.charAt(18)>='0'&&string.charAt(18)<='9'){
                string=string.substring(0,20)+"\n"+string.substring(20);
            }
            else {
                string=string.substring(0,19)+"\n"+string.substring(19);
            }
        }
        System.out.println(string);
        textArea.setText(string);
    }


    @FXML
    void keyPressed(KeyEvent event) {
        String temp = getView();
        switch (event.getCharacter()) {
            case"\u007F":
                newLine=false;
                setView(model.CEdel(temp));
                break;
            case"C":
                newLine=false;
                setView(model.Cdel());
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
                if(!onlyOperatorAllowed)
                setView(model.processNum(event.getCharacter()));
              break;
            case "+":
            case "-":
            case "*":
            case "/":
                setView(model.processBinOp(event.getCharacter()));
                break;
            case "=":
            case "\r":
                temp =model.getResult(temp);
                newLine=false;
                if(temp.length()>19){
                    model.Cdel();
                    temp="ERROR:BIG_NUMBER";
                }
                setView(temp);
                break;
            case"\b":
                if (temp.length()<=20)
                    newLine=false;
                setView(model.del(temp));
                break;
            default:
                setView("NONE");
                break;
        }
    }

}
