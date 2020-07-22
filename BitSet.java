/**
 ** @author Hamza Guerabli - 20112229
 * @author Yuyin Ding  - 20125263
 */
public class BitSet {
    byte numSet [];
    double tailleByte = 8.0;
    int limite ;
    /**
     * Crée un ensemble de bits, d'une certaine taille. Ils sont initialisés à
     * {@code false}.
     *
     * @param nbits taille initiale de l'ensemble
     */
    public BitSet(int nbits) {
        this.limite = nbits - 1;
        this.numSet =  new byte [(int) Math.ceil(nbits/tailleByte)];
    }

    /**
     * Retourne la valeur du bit à l'index spécifié.
     *
     * @param bitIndex l'index du bit
     * @return la valeur du bit à l'index spécifié
     */
    public boolean get(int bitIndex)throws IndexOutOfBoundsException {

        if(bitIndex > limite || bitIndex <0)
             throw new IndexOutOfBoundsException("index invalid");
        
        int indiceTab = (int)(bitIndex/this.tailleByte);
        int posCase = bitIndex % (int)this.tailleByte;
        byte temp = this.numSet[indiceTab];

        temp >>= posCase;
        temp &= 1;

        return temp == 1;
    }

    /**
     * Définit le bit à l'index spécifié comme {@code true}.
     *
     * @param bitIndex l'index du bit
     */
    public void set(int bitIndex) throws IndexOutOfBoundsException{
        if(bitIndex > limite || bitIndex <0)
             throw new IndexOutOfBoundsException("index invalid");

        int indiceTab = (int)(bitIndex/this.tailleByte);
        int posCase = bitIndex % (int)this.tailleByte;
        byte temp = 1;
        temp<<=posCase;
        this.numSet[indiceTab] |= temp;
        
    }

    /**
     * Définit le bit à l'index spécifié comme {@code false}.
     *
     * @param bitIndex l'index du bit
     */
    public void clear(int bitIndex) throws IndexOutOfBoundsException {
        if(bitIndex > limite || bitIndex <0)
             throw new IndexOutOfBoundsException("index invalid");

        if(get(bitIndex)){  //vérification si bitIndex est true

            int indiceTab = (int)(bitIndex/this.tailleByte);
            int posCase = bitIndex % (int)this.tailleByte;
            byte temp = 1;
            temp<<=posCase;
            this.numSet[indiceTab] -= temp;
        }
    }

   /* public void ajouter(int position, int valeur){
        this.numSet[position]= (byte)valeur;
    }
    public byte getValeur(int index){
        return this.numSet[index];
    }*/
}
