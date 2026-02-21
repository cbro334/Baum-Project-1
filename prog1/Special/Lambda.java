// Lambda -- Parse tree node strategy for printing the special form lambda

package Special;

import Tree.Node;
import Tree.Nil;

public class Lambda extends Special {

    public void print(Node t, int n, boolean p) {
        // According to the rule: lambda and the first two list elements 
        // are on the same line.
        
        // 1. Print indentation and opening parenthesis
        if (!p) {
            for (int i = 0; i < n; i++) System.out.print(" ");
            System.out.print("(lambda ");
        }

        Node cdr = t.getCdr();
        
        // 2. Print the parameter list (the second element of the lambda form)
        if (cdr != null && !cdr.isNil()) {
            Node params = cdr.getCar();
            // Parameters are printed on the same line as 'lambda' 
            params.print(0, false); 
            
            // 3. Print the body expressions
            Node body = cdr.getCdr();
            while (body != null && !body.isNil()) {
                System.out.println();
                // Subsequent lines are indented by two spaces 
                body.getCar().print(n + 2, false);
                body = body.getCdr();
            }
        }

        // 4. Print closing parenthesis [cite: 234]
        System.out.print(")");
        if (!p) {
            System.out.println();
        }
    }
}