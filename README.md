# Baum-Project-1
The group members for this project are:
-Christopher Brown
-Richard Cooper

Parse Folder:
-Parser.java:
Notable Variables:
scanner: scanner access
Token t: holds the value of the next token

Notable Methods:
-parseExp(): unless t.getType() == TokenType.LPAREN, the method returns a new instance (QUOTE,BOOL), or an new object (INT, STRING, IDENT)
              if t.getType() == TokenType.LPAREN, the method parseRest() is called
-parseRest(): Token t looks ahead to the next token immediately
              if t.getType() == TokenType.RPAREN, an instance of null is returned, indicating the ending of cdr, ")", has been found
              if t.getType() == TokenType.DOT, constructs the rest of the expression by calling parseExp() for car and calling getNextToken() for it's cdr
              scanner.pushBackToken(t) is called to place the token back off the stack so it can be read by parseExp()
              A new Cons node is constructed with new car and cdr nodes

-Scanner.java:
Notable Variables:
PushbackInputStream in: used to read bytes and then returned to the input stream (Test Cases)
Token lookaheadToken: used for look ahead
BUFSIZE and byte[] buf: used to store values so they can be scanned into new Tokens

Notable Methods:
isInitial():    compares ch to all ASCII values in this way: [a-z] || [A-Z] || other identifiers
isSubsequent(): compares ch to ASCII values to determine if ch follows another value
getNextToken(): used for look ahead
                first while loop skips white space and discards comments
                returns null on end of file
                if (ch == \, (, ), ., #) a new token of that type (QUOTE, LPAREN, RPAREN, DOT, TRUE, FALSE) is returned
                if (ch == '"') the string constants are stored into the buf aray from the first index and a new StrToken is created and returned
                if (ch >= '0' && ch <= '9') the ints in the input stream are converted into ASCII variables and a new IntToken is returned
                if ch is an identifier, the isInitial method is used to compare and a new IdentToken is made in the same way a StrToken is


Special folder:
-Begin.java, Cond.java, Define.java, If.java, Lambda.java, Let.java, and Set.java parses the input stream in similar ways
-Quote.java: replaces 'quote' with a "'"
-Special.java: //TODO

Tokens folder:
-TokenType.java: contains all possible token types
-all other classes extend Token, contain a constructor, contain a getter method, and contain a private variable of thier own classes type

Tree folder:
-all classes other than Node and Cons contain a private variable of their classes type, an optional getter method, a constructor, and a print method custom to the classes needs
-Cons(): contains two Node objects (car and cdr) and a Special object (form), a constructor mehtod w/a call to parseList(), two getter methods, and two print methods
         parseList(): checks car for identifier type and assigns a new type of object to form according to the type stored in car
-Node(): contains a list of helper functions that either test node type or act as getter methods
         Node Type: isBoolean(), isNumber(), isString(), isSymbol(), isNil(), isPair()
         Getter Method: getCar(), getCdr()
         Setter Method: setCar(), setCdr()


