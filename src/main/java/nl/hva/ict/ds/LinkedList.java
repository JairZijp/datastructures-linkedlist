package nl.hva.ict.ds;

/**
 * A linked list that adds elements to the end of the list and that retrieves elements from the end of the list as fast
 * as from the head of the list.
 * For example if a list contains 1000 elements the time needed to retrieve element at index 999 should be (almost) the
 * same as is needed for retrieving element at index 0. Retrieving element at index 800 should take (almost) the same
 * time as retrieving element at index 199.
 * When deleting an element all elements with the same value are deleted. So when deleting "don't" from a list that
 * contains<br/>
 * {"I", "don't", "like", "Datastructures", "as", "much", "as", "I", "don't", "like", "Sorting", "and", "Searching"}
 * this should result in a list containing:<br/>
 * {"I", "like", "Datastructures", "as", "much", "as", "I", "like", "Sorting", "and", "Searching"}
 *
 * @param <T> defines the type (class) that is stored in this list.
 */
public class LinkedList<T> {
    private class Node {
        private T value;
        private Node next;

        private Node(T value, Node next) {
            this.value = value;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
   

    /**
     * Adds a new element to the end of this list. The performance of this method is guaranteed to be constant, in other
     * words, the number of elements already stored in the list should have no influence on the time needed to add a new
     * element.
     * @param element the element that is added to the list.
     */
    public void add(T element) {
        
        // Make new node
        Node newNode = new Node(element, head);
        
        // If list is empty make the new node the head & tail.
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // if the list isn't empty add the new node to the end
            // and make it the tail.
            tail.next = newNode;
            tail = tail.next;
        }
        
    }

    /**
     * Returns an element from the list. If the index is negative or the element does not exists
     * an IllegalArgumentException is throw containing the reason in the message.
     * @param index the index, counted from the first element, of the element that must be returned.
     */
    public T get(int index) {
        
        // if the index is out of bounds throw an exception
        if(index < 0 || index+1 > size()){
            throw new IllegalArgumentException("Index is out of bounds");
        }
        
        Node node = head;
        
        // while the index minus 1 is greater than 0, keep looping and get 
        // the next node. if the index minus 1 isnt greater than 0 anymore. it reached
        // the correct node.
        while (index-- > 0) {
            node = node.next;
        }
        
        return node.value;
        
    }

    /**
     * Deletes the element (if it exists) from the list. In case of multiple occurrences all the occurrences are
     * deleted.
     * @param element the element to delete.
     */
   public void delete(T element) {
 
        // if head is null, the list is empty, then just return.
        if (head == null) {
            return;
        }
        
        // if the value of the next node is equal to the parameter, remove the link to the next node
        if (head.next != null && head.next.value.equals(element)) {
            head.next = null;
        }
        
        // if the value of the node is equal to the parameter, delete the node and make a new node the next
        if (head.value.equals(element)) {
            head = head.next;
        
            // recursive call
            delete(element);
        }
        
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in the list.
     */
    public int size() {
        
        Node currentNode = head;
        int size = 0;
        
        // while the current node is not null keep pointing to the next node 
        // and adding 1 to the size
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        
        return size;
    }

}
