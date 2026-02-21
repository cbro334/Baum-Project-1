// If -- Parse tree node strategy for printing the special form if

package Special;

import Tree.Nil;
import Tree.Node;

public class If extends Special {
 
public void print(Node t, int n, boolean p) {
    for (int i = 0; i < n; i++) System.out.print(" ");
    System.out.print("(if ");
    
    Node args = t.getCdr();
    if (!(args instanceof Nil)) {
        args.getCar().print(0); // Print condition on same line
        Node rest = args.getCdr();
        while (!(rest instanceof Nil)) {
            System.out.println();
            rest.getCar().print(n + 2); // Indent then-part and else-part
            rest = rest.getCdr();
        }
    }
    System.out.println();
    for (int i = 0; i < n; i++) System.out.print(" ");
    System.out.print(")");
}
}