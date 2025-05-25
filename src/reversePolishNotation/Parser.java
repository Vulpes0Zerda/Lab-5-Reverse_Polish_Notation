package src.reversePolishNotation;
/*
 If the string contains a number, then a varibale should continue and check whether the next digit is a number again.
 If yes, then the varibale should continue again.
 If no, the varibale should save the value and then separate it.
 The parts are then each saved in an ArrayList.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Parser {

  private Scanner scanner;
  private ArrayList<String> split;
  private CalcStack<String> stack;

  private String paString;
  private String currentString = "";
  
  public Parser(){
    scanner = new Scanner(System.in);
    split = new ArrayList<String>();
  }

    public static void main(String[] args) {
      Parser p = new Parser();

        p.printWelcome();
        p.splitTerm();

    
    for (String teil : p.split) {
        System.out.println("["+teil+"]");
    }
        p.createStack();
        p.getStack();

      }

  private void printWelcome(){
      System.out.println("Please enter a term to split it into chars:");
      System.out.println("Ignore whitspaces!");
      System.out.println("Example: 32*2");
  }

  public void splitTerm(){
      boolean validInput = false;

      while(!validInput){
        try {
          paString = scanner.nextLine();
          validInput = checkString();

        } catch (NumberFormatException e) {
          System.err.println("Your input is not valid.");
          System.err.println(e.getStackTrace());
          System.out.println();
        }
      }
    }

    public boolean checkString(){
      char x;
      split.clear(); //Clear the ArrayList to avoid duplicates
      currentString = ""; // Reset currentString for each new input

       //Iterate through String that was entered
            for(int i = 0; i < paString.length(); i++){
             x = paString.charAt(i);
             
             if(Character.isLetter(x)){
              System.out.println("You term has letters in it. Try again without it.");
                return false;
             }
        
            //If the input is a number, save this value in currentString
            //A number with a minus sign is added to the number
             if(Character.isDigit(x) || x == '.'){
              currentString += x;
             }
          
             
              //When the input contains a character that is not a number... 
              else if(!Character.isDigit(x) && currentString.length() > 0 || x == '(' || x == ')' || x == '-' ) {
                // add currentString if its not empty
                if (!currentString.isEmpty()) split.add(currentString);
                split.add(String.valueOf(x));
              }
              
            }
            
          //Last character/number is saved by Parser
          if (currentString.length() > 0) {
          split.add(currentString);
          }

          return true;    

    }
    

    public void createStack(){
      stack = new CalcStack<String>();

      for (String part : split) {
      stack.push(part);
      }
      
    }

    public CalcStack getStack(){
      return stack;
    }
  }


