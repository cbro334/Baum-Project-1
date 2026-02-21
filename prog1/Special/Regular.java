// Regular -- Parse tree node stratagy for printing regular lists

package Special;

import Tree.Nil;
import Tree.Node;

public class Regular extends Special {

public void print(Node t, int n, boolean p) {
    if (!p) System.out.print("(");
    
    t.getCar().print(0); // Print car without extra leading spaces
    if (!(t.getCdr() instanceof Nil)) {
        System.out.print(" ");
        t.getCdr().print(0, true); // Continue printing list with 'p' as true
    } else {
        t.getCdr().print(0, true);
    }
}
}