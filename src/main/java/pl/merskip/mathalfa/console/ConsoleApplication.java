package pl.merskip.mathalfa.console;

import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.operation.CalculateOperation;
import pl.merskip.mathalfa.base.shared.SharedPostfixParser;

import java.util.Scanner;

public class ConsoleApplication {
    
    public static void main(String[] args) {
        new ConsoleApplication().start();
    }
    
    private void start() {
        System.out.print("Input: ");
        
        String plainText = new Scanner(System.in).nextLine();
        Symbol rootSymbol = new SharedPostfixParser().parseAndGetRootSymbol(plainText);
        Symbol result = new CalculateOperation().executeForResult(rootSymbol);
        
        System.out.println("Result: " + result.toPlainText());
    }
    
}
