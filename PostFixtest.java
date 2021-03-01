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
public class PostFixtest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //String inputString[] = {"2","-","(","9","-","6","-","9",")","*","7","+","45"};
       String input = "3-(456-76*15+61)/6+89";
       makePostfix test= new makePostfix( input );
       test.processList();
       test.checkResult();
       rpcCalc result = new rpcCalc( test.resultList );
       System.out.println(result.calcResult());
    }
    
}
