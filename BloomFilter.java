/**
 * * @author Hamza Guerabli - 20112229
 * @author Yuyin Ding  - 20125263
 */
public class BloomFilter {
    /**
     * Crée un filtre de Bloom basé sur la taille de l'ensemble de bits et du
     * nombre de fonctions de hachage.
     * @param numBits taille de l'ensemble de bits
     * @param numHashes nombre de fonctions de hachage
     */
    private int numElems ;
    private   double falsePosProb ;
    public int numBits;
    public int numHashes;
    public  int nombreKeyajouter;
    private BitSet bitSet;

    public BloomFilter(int numBits, int numHashes) {
        this.numHashes = numHashes ;
        this.numBits = numBits;
        this.bitSet = new BitSet(this.numBits);
        this.nombreKeyajouter = 0;
    }

    /**
     * Crée un filtre de Bloom basé sur le nombre d'éléments attendus et de la
     * probabilité de faux positifs désirée.
     *
     * @param numElems nombre d'éléments à insérer
     * @param falsePosProb probabilité de faux positifs
     */
    public BloomFilter(int numElems, double falsePosProb) {

        this.numElems = numElems;
        this.falsePosProb = falsePosProb;
        this.numBits = (int) (Math.ceil(-this.numElems * Math.log(this.falsePosProb))/Math.pow(Math.log(2),2));
        this.numHashes = (int)(Math.ceil((this.numBits*Math.log(2))/numElems));
        this.bitSet = new BitSet(this.numBits);
        this.nombreKeyajouter = 0;

    }

    /**
     * Ajoute un élément au filtre de Bloom.
     *
     * @param key l'élément à insérer
     */
    public void add(byte[] key) {

        int resultas [] = bloomHash(key,this.numHashes);
        for (int i = 0; i < this.numHashes ; i++) {
            this.bitSet.set(resultas[i]);
        }
        this.nombreKeyajouter++;
    }

    /**
     * Cherche pour l'élément dans le filtre de Bloom.
     *
     * @param key l'élément à trouver
     * @return si l'élément est possiblement dans le filtre
     */
    public boolean contains(byte[] key) {
        return false; // TODO À compléter
    }

    /**
     * Remet à zéro le filtre de Bloom.
     */
    public void reset() {
        this.bitSet.clearBitSet();
       this.nombreKeyajouter = 0;
    }

    /**
     * Retourne le nombre de bits du filtre de Bloom.
     *
     * @return nombre de bits
     */
    public int size() {
        return this.numBits;
    }

    /**
     * Retourne le nombre d'éléments insérés dans le filtre de Bloom.
     *
     * @return nombre d'éléments insérés
     */
    public int count() {
        return this.nombreKeyajouter;
    }

    /**
     * Retourne la probabilité actuelle de faux positifs.
     *
     * @return probabilité de faux positifs
     */
    public double fpp() {
        return 0.0; // TODO À compléter
    }
     public int [] bloomHash(byte [] donnés ,int hashes){
        return new int[hashes] ;
     }

}
