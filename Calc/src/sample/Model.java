package sample;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static java.math.RoundingMode.*;

public class Model {

    private View view;
    private String mathOperator = "+";
    private StringBuffer firstNum = new StringBuffer("");
    private StringBuffer secondNum = new StringBuffer("");
    private boolean lastBtnWasNum = true,doubleProcessing;

    public Model(View view){
        this.view=view;
    }


    public String processNum(String numb){
        if(numb.contains(",")){
            numb.replace(",",".");
        }
        if (lastBtnWasNum) {
            firstNum.append(numb);
            numb=firstNum.toString();
        }
        else
        {
            secondNum.append(numb);
            numb=firstNum.toString()+mathOperator+secondNum;
        }
        return numb;

    }

    public String processBinOp(String string){
        lastBtnWasNum=false;
        secondNum.delete(0,secondNum.length());
        switch (string){
            case "+":
                mathOperator="+";
                 break;
            case "-":
                mathOperator="-";
                break;
            case "/":
                mathOperator="/";
                break;
            case "*":
                mathOperator="*";
                break;
        }
        return firstNum+mathOperator;
    }

    public static String removeLastSymbol(String st){
        return (st==null)
                ?null
                : (st.length()==0)
                ?""
                :(st.substring(0,st.length()-1));
    }

    public String del(String string){
        if (string.length()>firstNum.length()+1){
            secondNum.delete(secondNum.length()-1,secondNum.length());
            if(secondNum.length()==0)
                lastBtnWasNum=false;
        }
        else if (string.length()==firstNum.length()+1){
            mathOperator="";
        }
        else{
            firstNum.delete(firstNum.length()-1,firstNum.length());
        }
        string= removeLastSymbol(string);
        if (string.length()==0){
            firstNum.delete(0,firstNum.length());
            secondNum.delete(0,secondNum.length());
            mathOperator="";
            lastBtnWasNum=true;
            return "0";
        }
        lastBtnWasNum=true;
        return string;
    }

    public String Cdel(){
        firstNum.delete(0,firstNum.length());
        secondNum.delete(0,secondNum.length());
        mathOperator="";
        lastBtnWasNum=true;
        return "0";
    }

    public String CEdel(String string){
        int i;
        boolean thereIsAnOperator=false;
        char[] str=string.toCharArray();
        char[] DelimitedString= new char[]{'+','-','*','/'}; //MORE TO ADD
  outMark:
        for (i = 0; i <string.length() ; i++) {
            for (int j = 0; j <DelimitedString.length; j++) {
                if(str[i]==DelimitedString[j]) {
                    thereIsAnOperator=true;
                    break outMark;
                }
            }

        }
        if(thereIsAnOperator){
            lastBtnWasNum=false;
            i++;
            if (i < str.length) {
                secondNum.delete(0,secondNum.length());
                return string.substring(0, i)
                             .concat("0");
            }
            return string.concat("0");
        }
        firstNum.delete(0,firstNum.length());
        return "0";
    }

    public String getResult(String text){
        lastBtnWasNum=true;
        BigDecimal num1;
        BigDecimal num2;
        if (text.contains(".")||mathOperator=="/") {
            doubleProcessing=true;
            num1 = new BigDecimal(Double.parseDouble(firstNum.toString())).setScale(20, RoundingMode.HALF_EVEN);
            num2 = new BigDecimal(Double.parseDouble(secondNum.toString())).setScale(20, RoundingMode.HALF_EVEN);
        }
        else{
            doubleProcessing=false;
            num1=new BigDecimal(Integer.parseInt(firstNum.toString()));
            num2=new BigDecimal(Integer.parseInt(secondNum.toString()));
        }

        switch (mathOperator){
            case "+":
                    text=num1.add(num2).toString();
                break;
            case "-":
                    text=num1.subtract(num2).toString();
                break;
            case "*":
                    text=num1.multiply(num2).toString();
                break;
            case "/":
                    num1=num1.divide(num2,HALF_EVEN);
                    text=num1.toString();
                break;
        }
        if(doubleProcessing) {
            while (text.charAt(text.length()-1) == '0') {
                text=removeLastSymbol(text);
            }
            if(text.charAt(text.length()-1)=='.'){
                text=removeLastSymbol(text);
            }
        }
        // ADD if not user input and num of symbols after . >8
        //      round result
        //      
        firstNum.delete(0,firstNum.length());
        firstNum.append(text);
        secondNum.delete(0,secondNum.length());
        mathOperator="";
        return text;
    }
}

