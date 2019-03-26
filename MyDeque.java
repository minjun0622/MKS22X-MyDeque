import java.util.*;
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
    end = 0;
    size = 10;
    start = 0;
  }

  public MyDeque(int initialCapacity) {
    @SuppressWarnings("unchecked")
      E[] e = (E[])new Object[initialCapacity];
    data = e;
    size = initialCapacity;
    end = 0;
    start = 0;
  }

//can't just return. make sure it is within the start to end of array.
  public int size(){
    if (end >= start) {
      return end - start;
    }
    return (size - start) + end - 1;
  }

  //toString O(n) - format:  {a b c d }  / {}  /   {VALUE_VALUE2_VALUE3_}  (space after each value)

  public String toString(){
    String result = "{";
    if (start == end){
      return "{}";
    }
    //from start to end.
    if (end > start){
      for (int i = start; i < end; i++){
        result += data[i] + " ";
      }
    }
    else {
      //if start is greater than end.
      for (int i = start; i < size; i++){
        result += data[i] + " ";
      }
      for (int i=0; i < end; i++){
        result += data[i] + " ";
      }
    }
    result += "}";
    return result;
  }

//when the array gets too big.
  private void resize(){
   @SuppressWarnings("unchecked")
   E[] newData = (E[])new Object[size * 2];
   int count = 0;
   if (end >= start){
     for (int i = start; i < end; i++){
       newData[count] = data[i];
       count++;
     }
   } else {
     for (int i=start; i<size; i++){
       newData[count] = data[i];
       count++;
     }
     for (int i=0; i<end; i++){
       newData[count] = data[i];
       count++;
     }
   }
   start = 0;
   end = size();
   size = size * 2;
   data = newData;
}
  //add the element given to the very beginning.
  public void addFirst(E element){
    if (element == null){
     throw new NullPointerException();
   }
    if (size() == 0){
      end++;
      data[end-1] = element;
    }
    else {
      if (end == size || end == start){
        resize();
      }
      if (start == 0){
        for (int i=end; i>=1; i--){
          data[i] = data[i-1];
        }
        data[0] = null;
        start++;
        end++;
      }
      start--;
      data[start] = element;
    }
  }

// {3, 4, 2, 1, 6} if I wanted to add. Increase size.
//make a new array and copy it over. I multiplied the size by 2 but dk if it's right. I then add.
  public void addLast(E element){
    if (element == null){
     throw new NullPointerException();
   }
    if (size() == size) {
      resize();
    }
    if (end == size){
    data[0] = element;
    end = 1;
  } else {
    data[end] = element;
    end++;
  }
}
//removes the first element and returns it
  public E removeFirst(){
    if (size() == 0){
    throw new NoSuchElementException();
  }
    E temp = data[start];
    data[start] = null;
    if (start == end - 1){
      start = 0;
      end = 0;
      return temp;
    }
    if (start < size - 1){
      start++;
    }
    else {
      start = 0;
    }
    return temp;
  }
  //removes the last element and also returns it.
  public E removeLast(){
    if (size() == 0){
    throw new NoSuchElementException();
  }
    E temp = data[end - 1];
    end--;
    return temp;
  }

//{e1, e2, e3, e4}, returns e1
  public E getFirst(){
    if (start == end){
    throw new NoSuchElementException();
  }
    return data[start];
  }
//returns the last element in the array.
  public E getLast(){
    if (start == end){
     throw new NoSuchElementException();
   }
    return data[end - 1];
  }

public static void main(String[] args) {


}






}
