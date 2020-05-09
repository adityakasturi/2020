public class LinkedList {
  Node head = null;

  public void add(int value){
    if (head == null){
      head = new Node(value);
    }
    else {
      Node temp = this.head;
      while (temp.next != null){
          temp = temp.next;
      }
      Node newNode = new Node(value);
      newNode.prev = temp;
      temp.next = newNode;
    }
  }

  public void printAll(){
      Node printNode = this.head;
      while(printNode != null)
        System.out.println(+printNode.value)
  }
}
