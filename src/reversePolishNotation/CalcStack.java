package reversePolishNotation;
public class CalcStack <Type> {

    private ListElement<Type> top;
    private ListElement<Type> bottom;
    private int size;

    public void push(Type value){

        ListElement<Type> e = new ListElement<>();
        if(top == null){
            bottom = e;
        }
        e.next = top; //last element is linked to the new element
        e.value = value; //value is added to the new element
        this.top = e; //top is updated with the new list element
        this.size++;
    }

    public Type pop(){

        if(top == null) {
            return null;
        }
        //val saves the value so that you know which element was deleted
        Type val = top.value;
        
        if(top == bottom){
            bottom = null;
        }
        this.size--;
        top = top.next;
        return val;
    }

    public Type firstValue(){
        return top.value;
    }

    public Type lastValue(){
        return bottom.value;
    }

    public ListElement<Type> getFirst(){
        return top;
    }

    public void clear(){
        top = null;
    }
}