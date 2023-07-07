package uz.friday;

public class Main {
    public static void main(String[] args) {
        var dls = new DoublyLinkedList<String>();
        dls.add("Java");
        dls.add("Scala");
        dls.add("Go");
        dls.add("Python");
        dls.add("C++");

        System.out.println(dls);
    }
}