
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
     //"10 2.0 +"
     //returns '10' '2.0' '+'
    public static double eval(String s){
      String[] data = s.split(" ");
      /*for (int i = 0; i < data.length; i++){
        System.out.println(data[i]);
      }
      */
       MyDeque<Double> deque = new MyDeque<Double>();
      for (int i = 0; i < data.length; i++) {
        if (data[i].equals("+")){
          Double one = deque.removeLast();
          Double two = deque.removeLast();
          deque.addLast(one + two);
        }
        else if (data[i].equals("-")){
          Double one = deque.removeLast();
          Double two = deque.removeLast();
          deque.addLast(two - one);
        }
        else if (data[i].equals("*")){
          Double one = deque.removeLast();
          Double two = deque.removeLast();
          deque.addLast(one * two);
        }
        else if (data[i].equals("/")){
          Double one = deque.removeLast();
          Double two = deque.removeLast();
          deque.addLast(two / one);
        }
        else if (data[i].equals("%")){
          Double one = deque.removeLast();
          Double two = deque.removeLast();
          deque.addLast(two / one);
        }
        else {
        deque.addLast(Double.parseDouble(data[i]));
      }
    }
    return deque;

  }
  public static void main(String[] args) {
    eval("10 2.0 +");// is 12.0
    eval("11 3 - 4 + 2.5 *");// is 30.0
    eval("8 2 + 99 9 - * 2 + 9 -");// is 893.0
    eval("1 2 3 4 5 + * - -");// is 26.0

  }

}
