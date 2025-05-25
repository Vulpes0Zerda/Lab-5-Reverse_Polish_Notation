package src.reversePolishNotation;

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
    String str = "";
    p.getStack().invert();
    while(0<p.getStack().size()){
      str += "["+p.getStack().pop()+"]";
    }
    System.out.println(str);
    Infix infixStack = new Infix(p.getStack());


    Postfix postfixStack = new Postfix(infixStack.toPostfix());
    System.out.println(postfixStack.evaluate());
  }
}
