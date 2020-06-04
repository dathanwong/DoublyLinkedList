package com.dathanwong.doublylinkedlist;

public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
    
    public void printValuesBackward() {
    	Node current = this.tail;
    	while(current != null) {
    		System.out.println(current.value);
    		current = current.previous;
    	}
    }
    
    //Remove last node and return it
    public Node pop() {
    	Node last = this.tail;
    	Node newLast = last.previous;
    	newLast.next = null;
    	last.previous = null;
    	return last;
    }
    
    //Return true if value is in list
    public Boolean contains(int value) {
    	Node current = this.head;
    	while(current != null) {
    		if(current.value == value) return true;
    		current = current.next;
    	}
    	return false;
    }
    
    //Get size of the list
    public int size() {
    	int count = 0;
    	Node current = this.head;
    	while(current != null) {
    		count++;
    		current = current.next;
    	}
    	return count;
    }
    
    //Insert node at index
    public void insertAt(Node newNode, int index) {
    	if(index > this.size() || index < 0) {
    		System.out.println("Unable to insert node, index out of bounds");
    		return;
    	}
    	int count = 0;
    	Node current = this.head;
    	while(count != index) {
    		current = current.next;
    		count++;
    	}
    	//Do the insert
    	Node prev = current.previous;
    	prev.next = newNode;
    	newNode.previous = prev;
    	newNode.next = current;
    	current.previous = newNode;
    	return;
    }
    
    //Remove node at the index
    public void removeAt(int index) {
    	if(index > this.size() || index < 0) {
    		System.out.println("Unable to remove node, index out of bounds");
    		return;
    	}
    	int count = 0;
    	Node current = this.head;
    	while(count != index) {
    		current = current.next;
    		count++;
    	}
    	//Do the removal
    	Node prev = current.previous;
    	Node next = current.next;
    	prev.next = next;
    	next.previous = prev;
    	current.previous = null;
    	current.next = null;
    	return;
    }
    
    //Check if list is a palindrome
    public boolean isPalindrome() {
    	if(this.head == null) return false;
    	Node start = this.head;
    	Node end = this.tail;
    	while(start != end) {
    		if(start.value != end.value) return false;
    		start = start.next;
    		end = end.previous;
    	}
    	return true;
    }
}