/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixtest;
import java.util.*;

/**
 *
 * @author psimath
 */
enum Operator {    
    PLUS("+"),    
    MINUS("-"),    
    MULTIPLY("*"),    
    DIVIDE("/"),
    LPAREN("("),
    RPAREN(")");
    private final String opVal;    
    Operator(String opVal)    {       this.opVal = opVal;    }  
   
   @Override
   public String toString()    {       return opVal;    }   
   public int getRank( Operator opVal)
   {
    if(( opVal == PLUS)|| (opVal == MINUS )) return 10;  
    if(( opVal == MULTIPLY)||(opVal == DIVIDE ))return 20;  
    return 30;
   }
} 
public class makePostfix {
    
    ArrayList<String> inputExpression;
    Stack<checkString> opStack;
    ArrayList<String> resultList;
    
    public makePostfix()
    {
       initList();
    }
    
    public makePostfix( String[] inputString )
    {
      initList();
      for( String input : inputString )
            inputExpression.add(input);
    }
    
    public makePostfix( String inputString )
    {
      initList();
      for( int i = 0; i<inputString.length();i++ )
         inputExpression.add(Character.toString(inputString.charAt(i)));
    }
    
    private void initList()
    {
       inputExpression = new ArrayList();
       resultList = new ArrayList();
       opStack = new Stack(); 
    }
    
    private void appendInteger( )
    {
        for( int i = 1; i<inputExpression.size();i++)
            if( Character.isDigit(inputExpression.get(i).charAt(0))) 
            {
                if(Character.isDigit(inputExpression.get(i-1).charAt(0)))
                {
                    String combineNumber = inputExpression.get(i-1).concat(inputExpression.get(i));
                    inputExpression.remove(i);  inputExpression.remove(i-1);
                    inputExpression.add(i-1,combineNumber);
                    i--;
                }               
            }
    }
    
    public void processList()
    {
        checkString check;
        appendInteger();
        for( String input : inputExpression)
        {
            check = new checkString(input);
            if(check.isOperator==false) resultList.add(check.getValue());
            else processOp(check);
        }
        while(!opStack.empty())
        {
           resultList.add(opStack.pop().getValue()); 
        }
    }
    private void processOp(checkString check)
    {   
        int r1=0; 
        Operator isLParen = Operator.RPAREN;
        if(!opStack.empty())
           r1=peekopStack().opVal.getRank(opStack.peek().opVal);
        int r2 =check.opVal.getRank(check.opVal);
        if(opStack.empty()) opStack.push(check);
        
        else if((check.opVal==Operator.RPAREN)  ) 
        {      
        while( (isLParen != Operator.LPAREN)&&(!opStack.empty()))
            {
               resultList.add(opStack.pop().getValue()); 
               isLParen = peekopStack().opVal;
            } 
         if( isLParen == Operator.LPAREN) opStack.pop();
        }
       
        else 
        {
            while ((r1 >= r2) &&(!opStack.empty()))
            {  
                 r1 =peekopStack().opVal.getRank(opStack.peek().opVal);
                 if( r1 == 30 ) break;
                 resultList.add(opStack.pop().getValue());  
            } 
            opStack.push(check);
        }
    }
    private checkString peekopStack()
    {
        if(!opStack.isEmpty()) return  opStack.peek();
        else return null;
    }
    public void checkResult()
    {    for( String result : resultList )
         System.out.println(result);
    }
    
}