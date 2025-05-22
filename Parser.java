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

  private String paString;
  private String currentString = "";
  
  public Parser(){
    scanner = new Scanner(System.in);
    split = new ArrayList<String>();
  }

  public static void main(String[] args) {
    Parser p = new Parser();

      p.splitTerm();
      //p.getInput();
    }


  public void splitTerm(){
      boolean validInput = false;

      System.out.println("Please enter a term to split it into chars:");
      System.out.println("Ignore whitspaces!");
      System.out.println("Example: 32*2");
      
      char x;

      while(!validInput){
        try {
          paString = scanner.nextLine();
          validInput = !validInput;
        
            //Iterate through String that was entered
            for(int i = 0; i < paString.length(); i++){
             x = paString.charAt(i);
             
             
            //If the input is a number, save this value in currentString
            //A number with a minus sign is added to the number
             if(Character.isDigit(x) || x == '-'){
              currentString += x;
             }
             
              //When the input contains a character that is not a number 
              else if(!Character.isDigit(x) && currentString.length() > 0 ) {
            
                  split.add(currentString);
                  split.add(String.valueOf(x));
                
                //Sets currentString on default
                currentString = "";
                
              }
            }
          
          //Last character/number is saved by Parser
          if (currentString.length() > 0) {
          split.add(currentString);
          }

          System.out.println(split);

        } catch (NumberFormatException e) {
          System.err.println("Your input is not valid.");
          System.err.println(e.getStackTrace());
          System.out.println();
        }
      }
    }

    /*public String getInput(){
    return paString;
    }*/
  }
    

