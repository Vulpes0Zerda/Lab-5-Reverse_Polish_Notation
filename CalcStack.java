public class CalcStack {

    private ListElement head;

    public static void main(String[] args) {
        CalcStack stack = new CalcStack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack); 
        stack.pop();
        System.out.println(stack);
    }

    public void push(String var){

        ListElement s = new ListElement();
        s.next = head; //head is added at the front
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



    //toString() method generated with ChatGPT to test if the stacks works
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListElement current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }

}