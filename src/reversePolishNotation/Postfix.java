package reversePolishNotation;

public class Postfix {

  private CalcStack<String> postfixStack;

  public Postfix(CalcStack<String> postfixStack){
    this.postfixStack = postfixStack;
  }
  
  public double evaluate(){
    CalcStack<Double> numberStack = new CalcStack<>();
    double result = 0;
    if(postfixStack.isLeftToRight()){
      postfixStack.invert();
    }
    while(0<postfixStack.size()){
      String e = postfixStack.pop();
      if(Infix.isNumber(e)){
        numberStack.push(Double.parseDouble(e));
      }else{
        double b = numberStack.pop();
        double a = numberStack.pop();
        switch (e) {
            case "+":
              numberStack.push(a+b);
              break;
            case "-":
              numberStack.push(a-b);
              break;
            case "*":
              numberStack.push(a*b);
              break;
            case "/":
              numberStack.push(a/b);
              break;
            case "^":
              numberStack.push(Math.pow(a, b));
              break;
            default:
                throw new AssertionError();
        }
      }
    }
    return numberStack.lastValue();
  }
}
