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

    public void push(String value){

        ListElement s = new ListElement();
        s.next = head; //Kopf wird vorne hinzugefügt
        s.value = value; //Wert wird vorne hinzugefügt
        head = s;      //head wird mit dem Wert von s aktualisiert
    }

    public String pop(){

        if(head == null) {
            return null;
        }
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