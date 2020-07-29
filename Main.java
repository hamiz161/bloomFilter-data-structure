/**
 * * @author Hamza Guerabli - 20112229
 * @author Yuyin Ding  - 20125263
 */
public class Main {

    public static void main(String[] args) {
        BloomFilter bloom =new BloomFilter(555,1.0);
            System.out.println(bloom.numBits);
            System.out.println(bloom.numHashes);
            System.out.println(bloom.fpp());
          bloom.add(new byte[]{1 , 26 , 11});
         System.out.println(bloom.fpp());
         bloom.add(new byte[]{88 , 2 , 44});
           System.out.println(bloom.fpp());

           System.out.println(bloom.fpp());

    }
}
