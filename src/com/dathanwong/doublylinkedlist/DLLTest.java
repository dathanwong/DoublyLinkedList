package com.dathanwong.doublylinkedlist;

public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        dll.printValuesForward();
        System.out.println("Starting print backward");
        dll.printValuesBackward();
        System.out.println("Pop node: " + dll.pop().value);//Should return 100
        dll.printValuesForward();
        System.out.println(dll.contains(100)); //Should return false
        System.out.println(dll.contains(10)); //Should return true
        System.out.println(dll.size()); //Should return 5
        dll.insertAt(new Node(9999), 3);
        dll.printValuesForward();
        dll.insertAt(new Node(2222), 10);//Should print error
        dll.removeAt(3);
        dll.printValuesForward();
        dll.removeAt(-1);
        System.out.println(dll.isPalindrome()); //Should return false
        DLL palindrome = new DLL();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(1);
        palindrome.push(a);
        palindrome.push(b);
        palindrome.push(c);
        palindrome.push(d);
        System.out.println(palindrome.isPalindrome()); //Should return true
    }
}