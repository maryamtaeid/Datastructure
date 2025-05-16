package at.fhj.msd;
vpublic class Main {
    public static void main(String[] args) {
        System.out.println("Testing MyStackArray:");
        MyStackArray<Integer> stackArray = new MyStackArray<>();
        stackArray.push(5);
        stackArray.push(10);
        System.out.println("Pop: " + stackArray.pop()); // 10
        System.out.println("Is empty? " + stackArray.isEmpty()); // false
        System.out.println("Size: " + stackArray.size()); // 1

        System.out.println("\nTesting MyStackList:");
        MyStackList<String> stackList = new MyStackList<>();
        stackList.push("A");
        stackList.push("B");
        System.out.println("Pop: " + stackList.pop()); // B
        System.out.println("Is empty? " + stackList.isEmpty()); // false
        System.out.println("Size: " + stackList.size()); // 1
    }
}
