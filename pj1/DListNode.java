/* DListNode.java */

/**
 *  A DListNode is a node in a DList1 (doubly-linked list).
 */

public class DListNode {

  /**
   *  item references the item stored in the current node.
   *  prev references the previous node in the DList.
   *  next references the next node in the DList.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  public int[] item = new int[3]; //item[0]=red, item[1]=green, item[2]=blue
  public int runLength;
  public DListNode prev;
  public DListNode next;

  /**
   *  DListNode() constructor.
   *  item[0]: red
   */
  DListNode() {
    item[0] = 0;
    item[1] = 0;
    item[2] = 0;
    prev = null;
    next = null;
  }

  DListNode(int[] i, int length) {
    item = i;
    runLength = length;
    prev = null;
    next = null;
  }
}
