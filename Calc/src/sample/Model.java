package sample;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static java.math.RoundingMode.*;

public class Model {
    final int ALLOWED_SCALE=10;
    private View view;
    private String mathOperator = "+";
    private String firstNum = String.valueOf("");
    private String secondNum = String.valueOf("");
    private boolean lastBtnWasNum = true,
                    doubleProcessing,
                    UnOperatorWasPushed;

    public Model(View view){
        this.view=view;
    }


    public String processNum(String numb){
        if (lastBtnWasNum) {
            if(numb.contains(",")){
                numb.replace(",",".");
            }else if(firstNum.equals("0"))
                firstNum="";
            firstNum=firstNum.concat(numb);
            numb=firstNum;
        }
        else
        {
            secondNum=secondNum.concat(numb);
            numb=firstNum+mathOperator+secondNum;
        }
        System.out.println(lastBtnWasNum);
        return numb;

    }

    public String processBinOp(String string){
        lastBtnWasNum=false;
        if(firstNum.length()==0)
            firstNum=firstNum.concat("0");
        secondNum="";
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
        System.out.println(lastBtnWasNum);
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
            secondNum=secondNum.substring(0,secondNum.length()-1);
            if(secondNum.length()==0)
                lastBtnWasNum=false;
        }
        else if (string.length()==firstNum.length()+1){
            mathOperator="";
            lastBtnWasNum=true;
        }
        else{
            firstNum=firstNum.substring(0,firstNum.length()-1);
            lastBtnWasNum=true;
        }
        string= removeLastSymbol(string);
        if (string.length()==0){
            firstNum="";
            secondNum="";
            mathOperator="";
            lastBtnWasNum=true;
            return "0";
        }
        System.out.println(lastBtnWasNum);
        return string;
    }

    public String Cdel(){
        firstNum="";
        secondNum="";
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
                secondNum="";
                return string.substring(0, i)
                             .concat("0");
            }
            return string.concat("0");
        }
        firstNum="";
        return "0";
    }

    public String getResult(String text){
        if ((text.equals("0")||secondNum.length()==0)&&!UnOperatorWasPushed){
            return text;
        }
        lastBtnWasNum=true;
        BigDecimal num1;
        BigDecimal num2;
        if (text.contains(".")|| mathOperator.equals("/")) {
            doubleProcessing=true;
            num1 = new BigDecimal(Double.parseDouble(firstNum)).setScale(20, RoundingMode.HALF_EVEN);
            num2 = new BigDecimal(Double.parseDouble(secondNum)).setScale(20, RoundingMode.HALF_EVEN);
        }
        else{
            doubleProcessing=false;
            num1=new BigDecimal(firstNum);
            num2=new BigDecimal(secondNum);
        }

        switch (mathOperator){
            case "+":
                    text=num1.add(num2).toString();
                break;
            case "-":
                    text=num1.subtract(num2).toString();
                break;
            case "*":
                    num1=num1.multiply(num2);
                    if(num1.scale()>ALLOWED_SCALE)
                        num1=num1.setScale(ALLOWED_SCALE,UP);
                    text=num1.toString();
                break;
            case "/":
                    num1=num1.divide(num2,ALLOWED_SCALE,HALF_EVEN);
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
        firstNum="";
        firstNum=firstNum.concat(text);
        secondNum="";
        mathOperator="";
        System.out.println(lastBtnWasNum);
        return text;
    }
}

