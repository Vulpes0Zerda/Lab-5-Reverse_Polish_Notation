package reversePolishNotation;

public class Start {
  public static void main(String[] args) {
    new Start();
  }

  public Start(){
    startSequence();
  }

  public void startSequence(){
    Parser p = new Parser();
    p.printWelcome();
    p.splitTerm();
    p.createStack();
    CalcStack<String> stack = p.getStack();

    Infix infixStack = new Infix(stack);

    Postfix postfixStack = new Postfix(infixStack.toPostfix());
    System.out.println(postfixStack.evaluate());
  }
}
