public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  /*
  stack is when you take and pull out from the top of the stack.
  queue is when you take out the one that was done the least recently.
  deque it is using whateverO.
  */

  public MyDeque(){
    E[] e = (E[])new Object[10];
    data = e;
    size = data.length;
    start = 0;
  }

  public MyDeque(int initialCapacity) {
    E[] e = new Object[initialCapacity];
    data = e;
    size = data.length;
    end = initialCapacity;
    start = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String result = "{";
    for (int i = 0; i < data.length; i++) {
      result += data[i] + " }";
    }
    return result;
  }

  public void addFirst(E element){
    if (start < end) {
      for (int i = 1; i < data.length - 1; i++) {
        data[i + start] = data[start];
        data[start] = element;
      }
    }
  }

  public void addLast(E element){
    data[end - 1] = element;
  }

  public E removeFirst(){
    for (int i = data.length - 1; i > 0; i--){
      if (i > start) {
        data[i - 1] = data[i];
      }
      else {
        return data[i];
      }
    }
  }

  public E removeLast(){

  }
  
  public E getFirst(){

  }
  public E getLast(){

  }

public static void main(String[] args) {

}






}
