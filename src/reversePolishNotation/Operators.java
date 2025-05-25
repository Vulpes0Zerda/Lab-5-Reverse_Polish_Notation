package src.reversePolishNotation;

public enum Operators {
  ADD("+", 11),
  SUBTRACT("-", 11),
  MULTIPLY("*", 12),
  DIVIDE("/", 12),
  POWER("^", 13);

  private final String operator;
  private final int weight;

  Operators(String operator, int weight) {
    this.operator = operator;
    this.weight = weight;
  }

  public Integer getWeight(String operator) {
    for (Operators op : values()) {
      if(op.operator.equals(operator)){
        return op.weight;
      }
    }
    return null;
  }
  
}
