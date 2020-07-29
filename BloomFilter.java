/**
 * * @author Hamza Guerabli - 20112229
 * @author Yuyin Ding  - 20125263
 *
 * méthode hash ===> La figure 5.4 du Weiss
 * inspération pour les formules prob , numBits ,numHashs sur wikipedia
 * ==> https://en.wikipedia.org/wiki/Bloom_filter#Examples
 */

public class BloomFilter {
    /**
     * Crée un filtre de Bloom basé sur la taille de l'ensemble de bits et du
     * nombre de fonctions de hachage.
     * @param numBits taille de l'ensemble de bits
     * @param numHashes nombre de fonctions de hachage
     */
    public int numElems ;
    public   double falsePosProb ;
    public int numBits;
    public int numHashes;
    public  int nombreKeyajouter;
    public BitSet bitSet;

    public BloomFilter(int numBits, int numHashes) {
        this.numHashes = numHashes ;
        this.numBits = numBits;
        this.numElems = (int) ((int)(this.numBits / this.numHashes) * Math.log(2));
        this.bitSet = new BitSet(this.numBits);
        this.nombreKeyajouter = 0;
        this.falsePosProb = fpp();
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
        this.numHashes = (int)(Math.ceil(-(Math.log(this.falsePosProb)/Math.log(2)))) ;
        this.bitSet = new BitSet(this.numBits);
        this.nombreKeyajouter = 0;

    }

    /**
     * Ajoute un élément au filtre de Bloom.
     *
     * @param key l'élément à insérer
     */
    public void add(byte[] key) {

        int [] result = bloomHash(key,this.numHashes);
        for (int i = 0; i < this.numHashes ; i++) {
            this.bitSet.set(result[i]);
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
        int [] resultat = bloomHash(key,this.numHashes);
        boolean existe = true;
        for (int i = 0; i <resultat.length && existe; i++) {
            existe  = existe && bitSet.get(resultat[i]);
        }
        return existe;
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
        return Math.pow(1-Math.exp(-this.numHashes * (double)this.nombreKeyajouter /(double) this.numBits),this.numHashes);
    }

    /**
     *
     * @param key
     * @param hashes
     * @return
     */
     public int [] bloomHash(byte [] key ,int hashes){
         int [] resultat = new int[hashes];

         for (int i = 0; i < hashes ; i++) {
             resultat [i] = hash(key , i ) ;
         }
        return resultat ;
     }


    /**
     *
     * @param key
     * @param indice
     * @return
     */
     public int hash(byte [] key, int indice){
         int x = 37 * indice ;
         int hashVal = 0 ;
         for( int i = 0; i < key.length; i++ ) {
             hashVal = x * hashVal + key[i];
             hashVal %= numBits;

             if (hashVal < 0)
                 hashVal += numBits;
         }
         return hashVal;
     }

}
