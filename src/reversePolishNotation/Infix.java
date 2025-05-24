package reversePolishNotation;

public class Infix {
  private CalcStack calcStack;
  public Infix(CalcStack calcStack){
    this.calcStack = calcStack;
  }
  public static CalcStack toPostfix(CalcStack calcStack){
    // not useable yet
    return calcStack;
  }

  public CalcStack<Object> toPostfix(){
    // not useable yet
    CalcStack<Character> operatorStack = new CalcStack<>();
    CalcStack<Float> number = new CalcStack<>();
    return calcStack;
    
  }

  public CalcStack getCalcStack(){
    return calcStack;
  }
}
