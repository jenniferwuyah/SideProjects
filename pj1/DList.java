/* DList.java */

/**
 *  A DList is a mutable doubly-linked list.  (No sentinel, not
 *  circularly linked.)
 */

public class DList {

  /**
   *  head references the first node.
   *  tail references the last node.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode head;
  protected DListNode tail;
  protected long size;
  public int width;
  public int height;

  /* DList invariants:
   *  1)  head.prev == null.
   *  2)  tail.next == null.
   *  3)  For any DListNode x in a DList, if x.next == y and x.next != null,
   *      then y.prev == x.
   *  4)  For any DListNode x in a DList, if x.prev == y and x.prev != null,
   *      then y.next == x.
   *  5)  The tail can be accessed from the head by a sequence of "next"
   *      references.
   *  6)  size is the number of DListNodes that can be accessed from the
   *      head by a sequence of "next" references.
   */

  /**
   *  DList() constructor for an empty DList.
   */
  public DList(int w, int h) {
    head = null;
    tail = null;
    width = w;
    height = h;
    size = 0;
  }
  
  /**
   *  DList() constructor for a one-node DList.
   */
  public DList(int w, int h, int[] a, int length) {
    head = new DListNode();
    tail = head;
    head.item = a;
    head.runLength = length;
    size = 1;
    width = w;
    height = h;
  }

  /**
   *  insertFront() inserts an item at the front of a DList.
   */
  public void insertFront(int[] i, int length) {
    DListNode node = new DListNode(i, length);
    if (size == 0){
      head = node;
      tail = node;
    } else{
      node.next = head;
      head.prev = node;
      head = node;
    }
    size++;
  }

  /**
   *  insertAfter() inserts an item after the orig node of a DList.
   */
  public void insertAfter(DListNode orig, int[] i, int length) {
    DListNode node = new DListNode(i, length);
    node.prev = orig;
    node.next = orig.next;
    if (orig == tail){
      tail = node;
    } 
    else{
      orig.next.prev = node;
    }
    orig.next = node;
    size++;
  }

  /**
   *  insertEnd() inserts an item at the end of a DList.
   */
  public void insertEnd(int[] i, int length) {
    if(head == null){
      DListNode node = new DListNode(i, length);
      head = node;
      tail = head;
    }
    else{
      this.insertAfter(tail, i, length);
    }
    size++;
  }

  public void remove(DListNode node){
    if(node == head){
      head = node.next;
    } else {
      node.prev.next = node.next;
    }
    if (node == tail) {
      tail = node.prev;
    } else {
      node.next.prev = node.prev;
    }
    size--;
  }

  /**
   *  getEndColors() returns the item at the end of a DList.
   */
  public int[] getEndColors() {
    return tail.item;
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   */
  public String toString() {
    String result = "[  ";
    DListNode current = head;
    while (current != null) {
      int[] i=current.item;
      result = result + i[0]+" "+i[1]+" "+i[2] + "  \n";
      current = current.next;
    }
    return result + "]";
  }

  public static void main(String[] args) {
    // DO NOT CHANGE THE FOLLOWING CODE.
  }

}
