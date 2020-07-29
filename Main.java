/**
 * * @author Hamza Guerabli - 20112229
 * @author Yuyin Ding  - 20125263
 */
public class Main {

    public static void main(String[] args) {
        BloomFilter bloom =new BloomFilter(10,0.1);
            System.out.println(bloom.numBits);
            System.out.println(bloom.numHashes);
            System.out.println(bloom.fpp());
            bloom.add(new byte[]{25 , 26 , 11});
        System.out.println(bloom.contains(new byte[]{25 , 26 , 71}));

    }
}
