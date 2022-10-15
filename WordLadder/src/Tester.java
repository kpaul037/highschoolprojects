public class Tester {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();

        a.addToFront("wow");
        a.addToFront("tow");
        a.addToFront("cow");

        System.out.println(a.size());
        System.out.println(a.removeFromFront());
        System.out.println(a.size());

        a.addToBack("bow");
        a.addToBack("show");

        System.out.println(a.size());
        System.out.println(a.removeFromFront());
        System.out.println(a.size());
    }
}
