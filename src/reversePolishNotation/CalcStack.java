package src.reversePolishNotation;
public class CalcStack {

    private ListElement head;

    public void push(String var){

        ListElement s = new ListElement();
        s.next = head;          //head is added at the front
        s.value = var; //value is added at the front
        head = s;      //head is updated with the value of s
    }

    public String pop(){

        if(head == null) {
            return null;
        }
        //val saves the value so that you know which element was deleted
        String val = head.value;

        head = head.next;
        return val;
    }

        public void clear(){

        head = null;

        }
}