public class Main {
    public static void main(String[] args) {
        BitSet zebi = new BitSet(16);
        zebi.ajouter(0, 5);
        zebi.ajouter(1,  42);
       /* System.out.println(zebi.get(2));
        zebi.clear(2);
        System.out.println(zebi.get(2));
        zebi.set(2);
        System.out.println(zebi.get(2));*/
        System.out.println(zebi.get(5));
        zebi.set(5);
        System.out.println(zebi.get(5));
        zebi.set(5);
        System.out.println(zebi.get(5));
        zebi.clear(5);
        System.out.println(zebi.get(5));

    }
}
