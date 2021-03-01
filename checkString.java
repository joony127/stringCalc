/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixtest;

/**
 *
 * @author joony
 */
public class checkString {
    
        public boolean isOperator = false;
        private String stringVal;
        Operator opVal;
        
        checkString( String input )
        {
            if( input == null) stringVal= null;
            stringVal= input;
            for (Operator value : Operator.values()) {
                if (value.toString() == null ? input == null : value.toString().equals(input)) 
                {
                    opVal = value;
                    isOperator = true;
                }
            }
        }       
         public String getValue()
         { return stringVal; }    
}