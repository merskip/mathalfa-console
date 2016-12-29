package pl.merskip.mathalfa.console;

import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.core.fragment.FragmentsSplitter;
import pl.merskip.mathalfa.base.infixparser.PostfixConverter;
import pl.merskip.mathalfa.base.infixparser.PostfixParser;
import pl.merskip.mathalfa.base.operation.CalculateOperation;
import pl.merskip.mathalfa.base.shared.SharedFragmentsRegister;

import java.util.Scanner;

public class ConsoleApplication {
    
    private FragmentsSplitter splitter;
    private PostfixConverter converter;
    private PostfixParser parser;
    
    private Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        new ConsoleApplication().start();
    }
    
    private ConsoleApplication() {
        splitter = new FragmentsSplitter(SharedFragmentsRegister.getInstance());
        converter = new PostfixConverter(splitter);
        parser = new PostfixParser(converter);
    }
    
    private void start() {
        
        System.out.println("Enter expression to calculate:");
        System.out.println();
        
        while (true) {
            System.out.print(" >> ");
            String plainText = input.nextLine();
            
            if (plainText.equals("q") || plainText.equals("quit")) {
                System.out.println("Thanks for your attentions");
                break;
            }
            
            Symbol rootSymbol = parser.parseAndGetRootSymbol(plainText);
            Symbol result = new CalculateOperation().executeForResult(rootSymbol);
    
            System.out.println("Result: " + result.toPlainText());
            System.out.println();
        }
    }
    
}
