package Tree;

import Special.*;

public class Cons extends Node {
    private Node car;
    private Node cdr;
    private Special form;

    public Cons(Node a, Node d) {
        car = a;
        cdr = d;
        parseList();
    }

    // Accessors for Special classes to navigate the list
    @Override
    public Node getCar() { return car; }

    @Override
    public Node getCdr() { return cdr; }

    // Logic to select the printing strategy based on the keyword [cite: 190, 197]
    void parseList() {
        if (car instanceof Ident) {
            String name = ((Ident) car).getName();
            if (name.equals("quote"))       form = new Quote();
            else if (name.equals("lambda"))  form = new Lambda();
            else if (name.equals("begin"))   form = new Begin();
            else if (name.equals("if"))      form = new If();
            else if (name.equals("let"))     form = new Let();
            else if (name.equals("cond"))    form = new Cond();
            else if (name.equals("define"))  form = new Define();
            else if (name.equals("set!"))    form = new Set();
            else                             form = new Regular();
        } else {
            form = new Regular();
        }
    }

    public void print(int n) {
        form.print(this, n, false);
    }

    public void print(int n, boolean p) {
        form.print(this, n, p);
    }
}