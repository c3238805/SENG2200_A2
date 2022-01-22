/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 2 (100 marks, 15%) - Due 9/05, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedList<T extends PlanarShape > implements Iterable<T>  {
  private int modCount;       //count
    private Node<T> sentinel;
    private int size;

    public Iterator<T> iterator() {
        return  new thisiterator();
    }

    public LinkedList() {
      sentinel = new Node<T>();
      size = 0;
      modCount = 0;
    }
    // get the size of the list
    public int getSize() {
      return size;
    }

    public void add(T new_data) {
      Node<T> x = new Node<T>(new_data); // allocate a new element
      Node<T> current = sentinel;
      while (current.getNext()!=null) {
        current = current.getNext();      
      }
      // Splice in the new element.
      x.setNext(current.getNext());
      x.setPrev(current);
  
      current.getNext().setPrev(x);
      current.setNext(x);
  
      size++;
    }

    public void append(T o) {
      Node<T> add = new Node<T>(o);
      Node<T> n = sentinel;
      while (n.getNext()!=null) {
        n = n.getNext();
      
      }
      n.setNext(add);
      add.setPrev(n);
      size++;
      modCount++; // incread modCount
    }

    public void prepend(T o) {
      Node<T> n = new Node<T>(o);

      n.setNext(sentinel.getNext());
      n.setPrev(sentinel);
      sentinel.setNext(n);
      n.getNext().setPrev(n);

      size++;
      modCount++; // incread modCount
    }

    public T removeHead() throws IndexOutOfBoundsException {
      if (size<=0){
      throw new IndexOutOfBoundsException(
      "Cannot remove from empty list");
    
      }
      Node<T> n = sentinel.getNext();   //get the node after the sentinel
      sentinel.setNext(n.getNext());
      sentinel.getNext().setPrev(sentinel);
      size--;
      modCount++; // incread modCount
      return n.getData();
    
    }
    // for removing the tail node
    public T removeTail() throws IndexOutOfBoundsException {
      if (size<=1) {
      return removeHead();
      }
      Node<T> n = sentinel;
      while (n.getNext().getNext()!=null) {
      n = n.getNext();
      }
      Node<T> o = n.getNext();
      n.setNext(null);
      size--;
      modCount++; // incread modCount
      return o.getData();
    }

    public void insertBefore(T before,T obj) {
      Node<T> b = new Node<T>(before);  // insert before Node <T> before 

      Node<T> n = new Node<T>(obj); // create a new node for input data
      Node<T> current = sentinel;   // set current the sentinel node 
      while (current.getNext()!=null) {
        current = current.getNext();
        if(current.getData() == b.getData() ){
          break;  // stop the lood if reached the before node.
        }
      }
      // add link to the node together .
      n.setPrev(current.getPrev()); 
      current.getPrev().setNext(n);
      n.setNext(current);
      current.setPrev(n);
           
      size++;
      modCount++;   
    }
    public void insertInOrder(T new_data) {
      Node<T> current = sentinel;   // set current to the last node of the list
      
    if (size == 0) {
      append(new_data);
      return;
    }
    else{
        while (current.getNext()!=null) { // loop form the node after sentinel
            current = current.getNext();
            if (current.getData().compareTo(new_data) == 1) {
              insertBefore(current.getData(),new_data);
              break;
            } 
            else if (current.getData().compareTo(new_data) == -1 && current.getNext() == null) {
              append(new_data);
              break;
            }

        }
      }  
    }

  //===============================================
  private class thisiterator implements Iterator<T>{
    private int expectedModCount;       //count

    private Node<T> current;
    // construtor 
    private thisiterator(){
        this.current = sentinel;
        expectedModCount = modCount;
    }
    // search if the Iterator have next()
    public T next() {
     if(expectedModCount != modCount)throw new 
        ConcurrentModificationException("Cannot mutate in context of iterator");
      
        this.current = current.getNext();
        return current.getData();
    }
    // if getNext() == null, the iterator reach till the end of the list
    public boolean hasNext(){         
        return this.current.getNext() != null;      //true         
    }
  }


}
