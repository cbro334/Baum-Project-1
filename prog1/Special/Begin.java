// Begin -- Parse tree node strategy for printing the special form begin

package Special;

import Tree.Nil;
import Tree.Node;

public class Begin extends Special {
 
public void print(Node t, int n, boolean p) {
    for (int i = 0; i < n; i++) System.out.print(" ");
    System.out.print("(begin");
    
    Node remainder = t.getCdr();
    while (!(remainder instanceof Nil)) {
        System.out.println();
        remainder.getCar().print(n + 2); // Indent by 2 spaces
        remainder = remainder.getCdr();
    }
    System.out.println();
    for (int i = 0; i < n; i++) System.out.print(" ");
    System.out.print(")");
}
}