public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  /*
  stack is when you take and pull out from the top of the stack.
  queue is when you take out the one that was done the least recently.
  deque it is using whateverO.
  */

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] e = (E[])new Object[10];
    data = e;
    size = data.length;
    start = 0;
  }

  public MyDeque(int initialCapacity) {
    @SuppressWarnings("unchecked")
      E[] e = (E[])new Object[initialCapacity];
    data = e;
    size = data.length;
    end = initialCapacity;
    start = 0;
  }

  public int size(){
    return size;
  }


  //toString O(n) - format:  {a b c d }  / {}  /   {VALUE_VALUE2_VALUE3_}  (space after each value)

  public String toString(){
    String result = "{";
    for (int i = 0; i < data.length; i++) {
      result += data[i] + " ";
    }
    result += "}";
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

// {3, 4, 2, 1, 6} if I wanted to add. Increase size.
//make a new array and copy it over. I multiplied the size by 2 but dk if it's right. I then add.
  public void addLast(E element){
    E[] temp = new E[size * 2];
    for (int i = 0; i < data.length; i++){
      temp[i] = data[i];
    }
    temp[data.length] = element;
  }

  public E removeFirst(){
    E temp = data[start];
    E[] newdata = new E[size - 1];
    for (int i = 1; i < data.length + 1; i++){
      newdata[i - 1] = data[i];
      data[i - 1] = newdata[i - 1];
    }

    return temp;
  }

  public E removeLast(){
    E temp = data[end];
    for (int i = 0; i < data.length; i++){
      E[] newdata = new E[size * 2];
    }
    return temp;
  }

//{e1, e2, e3, e4}, returns e
  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

public static void main(String[] args) {


}






}
