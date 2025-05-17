package at.fhj.msd;

public class Main {
    public static void main(String[] args) {
        // === Test MyStackArray ===
        System.out.println("Testing MyStackArray:");
        MyStackArray<Integer> stackArray = new MyStackArray<>();
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        System.out.println("Pop: " + stackArray.pop());         // 3
        System.out.println("Size: " + stackArray.size());       // 2
        System.out.println("Is empty? " + stackArray.isEmpty()); // false

        // === Test MyStackList ===
        System.out.println("\nTesting MyStackList:");
        MyStackList<String> stackList = new MyStackList<>();
        stackList.push("A");
        stackList.push("B");
        System.out.println("Pop: " + stackList.pop());          // B
        System.out.println("Size: " + stackList.size());        // 1
        System.out.println("Is empty? " + stackList.isEmpty()); // false

        // // === Test MyQueueArray ===
        // System.out.println("\nTesting MyQueueArray:");
        // MyQueueArray<Double> queueArray = new MyQueueArray<>();
        // queueArray.put(1.1);
        // queueArray.put(2.2);
        // queueArray.put(3.3);
        // System.out.println("Get: " + queueArray.get());         // 1.1
        // System.out.println("Size: " + queueArray.size());       // 2
        // System.out.println("Is empty? " + queueArray.isEmpty()); // false

        // // === Test MyQueueList ===
        // System.out.println("\nTesting MyQueueList:");
        // MyQueueList<Character> queueList = new MyQueueList<>();
        // queueList.put('X');
        // queueList.put('Y');
        // System.out.println("Get: " + queueList.get());          // X
        // System.out.println("Size: " + queueList.size());        // 1
        // System.out.println("Is empty? " + queueList.isEmpty()); // false
    }
}
