/**
 * * @author Hamza Guerabli - 20112229
 * @author Yuyin Ding  - 20125263
 */
public class Main {

    public static void main(String[] args) {
     BloomFilter bloom =new BloomFilter(10000 ,0.5);
    
        System.out.println(bloom.numBits);
        System.out.println(bloom.numHashes);
    }
}
