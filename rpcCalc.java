/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixtest;

import java.util.Stack;
import java.util.ArrayList;
import java.math.*;

/**
 *
 * @author joony
 */
public class rpcCalc {
    
    private Stack<BigDecimal> numberStack;
    public ArrayList<String> expressionList;
    public rpcCalc()
    {
        numberStack = new Stack<BigDecimal>();
        expressionList = new ArrayList<String>();
    }
    public rpcCalc(String[] s)
    {
        numberStack = new Stack<BigDecimal>();
        expressionList = new ArrayList<String>();
        for( String inputs : s)
            expressionList.add(inputs);
    }
    
    public rpcCalc(ArrayList<String> s)
    {
        numberStack = new Stack<BigDecimal>();
        expressionList = s;
    }
    private void addInt( String S )
    {
        BigDecimal inputNum = new BigDecimal(S);
        numberStack.push(inputNum);
    }
    
    private void addInt(BigDecimal i)
    {
        numberStack.push(i);
    }
    
    private Boolean isOperator( String S )
    {
        return (( "+".equals(S))||( "*".equals(S))||( "-".equals(S))||( "/".equals(S)));
    }
    
    public BigDecimal calcResult()
    {
        expressionList.forEach((in) -> {
            if( isOperator(in) == false) addInt(in);
            else addInt(operateNum (numberStack.pop(), numberStack.pop(), in));
        });
        return numberStack.pop();
    }   
    public BigDecimal operateNum (BigDecimal i, BigDecimal j, String Operator)
    {
        switch(Operator)
        {
            case "+": return j.add(i);
            case "*": return j.multiply(i);
            case "-": return j.subtract(i);
            case "/": return j.divide(i,10,6);
        }
        return null;
    }
}
