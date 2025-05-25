package src.reversePolishNotation;

public class Infix {
  private CalcStack<String> infixStack;
  private Operators operators;
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
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
  }


  public CalcStack<String> toPostfix(){

    int openParentheses = 0;
    
    // uses this as a sub stack to simulate parentheses
    CalcStack<String> operatorStack = new CalcStack<>();

    operatorStacks.push(operatorStack);
    // inverts the stack to read it from left to right
    if(infixStack.isLeftToRight()){
      infixStack.invert();
    }

    // goes through all the infix stack elements
    for(int i = 0; i<infixStack.size(); i++){

      // pops the first element
      String element = infixStack.pop();

      // checks if element is a number
      if(Infix.isNumber(element)){
        postfixStack.push(element);

      // checks if element is a opening parentheses
      }else if (element.equals("(")) {
        openParentheses++;
        operatorStack = new CalcStack<>();
        operatorStacks.push(operatorStack);

      // checks if element is a closing
      }else if(element.equals(")")){
        if(openParentheses>0){
          openParentheses--;
          flushStack();
        }else{
          System.err.println("Cannot close unopened parentheses. Please check your input and try again.");
          // if the while loop would run in Start instead of Parser you could throw and error and retry the input
          System.exit(0);
        }

      }else{
        operatorStack.push(element);

        // 
        if(operatorStack.firstValue() != null){

          if(operators.getWeight(operatorStack.firstValue()) < operators.getWeight(element)){

            operatorStack.push(element);

          }else{

            postfixStack.push(operatorStack.pop());
            operatorStack.push(element);

          }
        }else{

          operatorStack.push(element);

        }
      }
      flushStack();
    }

    postfixStack.invert();
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
