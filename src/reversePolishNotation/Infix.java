package src.reversePolishNotation;

public class Infix {
  private CalcStack<String> infixStack;
  private CalcStack<CalcStack<String>> operatorStacks;
  private CalcStack<String> postfixStack;


  public Infix(CalcStack<String> calcStack){
    this.infixStack = calcStack;
    this.postfixStack = new CalcStack<>();
    this.operatorStacks = new CalcStack<>();
  }

  public static boolean isNumber(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException e) {
        return false;
    }
    return true;
  }


public CalcStack<String> toPostfix() {
    CalcStack<String> operatorStack = new CalcStack<>();
    
    if (infixStack.isLeftToRight()) {
        infixStack.invert();
    }

    while (infixStack.size() > 0) {
        String token = infixStack.pop();

        if (isNumber(token)) {
            postfixStack.push(token);

        } else if (token.equals("(")) {
            operatorStack.push(token);

        } else if (token.equals(")")) {
            while (operatorStack.size() > 0 && !operatorStack.firstValue().equals("(")) {
                postfixStack.push(operatorStack.pop());
            }
            if (operatorStack.size() == 0) {
                System.err.println("Mismatched parentheses.");
                System.exit(0);
            } else {
                operatorStack.pop(); // discard the "("
            }

        } else { // operator
            while (
                operatorStack.size() > 0 &&
                !operatorStack.firstValue().equals("(") &&
                Operators.getWeight(operatorStack.firstValue()) >= Operators.getWeight(token)
            ) {
                postfixStack.push(operatorStack.pop());
            }
            operatorStack.push(token);
        }
    }

    // Drain remaining operators
    while (operatorStack.size() > 0) {
        String op = operatorStack.pop();
        if (op.equals("(") || op.equals(")")) {
            System.err.println("Mismatched parentheses.");
            System.exit(0);
        }
        postfixStack.push(op);
    }

    return postfixStack;
}

  private void flushStack(){
    if(0<operatorStacks.size()){
      CalcStack<String> stackToFlush = operatorStacks.pop();
      while(0<stackToFlush.size()){
        postfixStack.push(stackToFlush.pop());
      }
    }

  }

  public CalcStack getCalcStack(){
    return infixStack;
  }
}
