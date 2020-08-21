//Fichier de tests pour le devoir 3
//En général, quand ça output true, c'est bon, quand ça output false ou crash, ça ne l'est pas.

public class test{
    public static void main(String[] args){

		long startTime = System.nanoTime();

		
		System.out.println("================== Test de BitSet ==================");
		System.out.println("\tTaille mémoire");
		try{
			Runtime rt = Runtime.getRuntime();
			long avant = rt.freeMemory();
			BitSet bs = new BitSet(8000000);
			long apres = rt.freeMemory();
			long diff = (avant - apres) - (1000000 + 48576);
			if(Math.abs(diff) > 0){
				p("false : " + diff);
			}
			else{
				p("true : " + diff);
			}
		}
		catch(Throwable e){
			p("crash");
		}



		System.out.println("\tget-set");

		try{
			BitSet bs = new BitSet(32);
			boolean toutVide = true;
			for(int i = 0; i < 32; ++i){
				if(bs.get(i)){
					toutVide = false;
					break;
				}
			}
			p("(32)initialement vide : " + toutVide);
		}
		catch(Throwable e){
			p("(32)initialement vide : crash");
		}

		try{
			BitSet bs = new BitSet(32);
			bs.set(4);
			p("(32)test set 1 element (1/2) : " + bs.get(4));
		}
		catch(Throwable e){
			p("(32)test set 1 element (1/2) : crash");
		}

		try{
			BitSet bs = new BitSet(32);
			bs.set(4);
			boolean toutVide = true;
			for(int i = 0; i < 32; ++i){
				if(bs.get(i) && i != 4){
					toutVide = false;
					break;
				}
			}
			p("(32)test set 1 element (2/2) : " + toutVide);
		}
		catch(Throwable e){
			p("(32)test set 1 element (2/2) : crash");
		}

		try{
			BitSet bs = new BitSet(32);
			for(int i = 0; i % 3 == 0; ++i){
				bs.set(i);
			}
			boolean check = true;
			for(int i = 0; i % 3 == 0; ++i){
				if(!bs.get(i)){
					check = false;
					break;
				}
			}
			p("(32)test set une coupe d'elements (1/2) : " + check);
		}
		catch(Throwable e){
			p("(32)test set une coupe d'elements (1/2) : crash");
		}

		try{
			BitSet bs = new BitSet(32);
			for(int i = 0; i % 3 == 0; ++i){
				bs.set(i);
			}
			boolean check = true;
			for(int i = 0; i % 3 != 0; ++i){
				if(bs.get(i)){
					check = false;
					break;
				}
			}
			p("(32)test set une coupe d'elements (2/2) : " + check);
		}
		catch(Throwable e){
			p("(32)test set une coupe d'elements (2/2) : crash");
		}


		try{
			BitSet bs = new BitSet(32);
			for(int i = 0; i < 32; ++i){
				bs.set(i);
			}
			boolean check = true;
			for(int i = 0; i < 32; ++i){
				if(!bs.get(i)){
					check = false;
					break;
				}
			}
			p("(32)test set tous les elements : " + check);
		}
		catch(Throwable e){
			p("(32)test set tous les elements : crash");
		}




		try{
			BitSet bs = new BitSet(150);
			boolean toutVide = true;
			for(int i = 0; i < 150; ++i){
				if(bs.get(i)){
					toutVide = false;
					break;
				}
			}
			p("(150)initialement vide : " + toutVide);
		}
		catch(Throwable e){
			p("(150)initialement vide : crash");
		}

		try{
			BitSet bs = new BitSet(150);
			bs.set(4);
			p("(150)test set 1 element (1/2) : " + bs.get(4));
		}
		catch(Throwable e){
			p("(150)test set 1 element (1/2) : crash");
		}

		try{
			BitSet bs = new BitSet(150);
			bs.set(4);
			boolean toutVide = true;
			for(int i = 0; i < 150; ++i){
				if(bs.get(i) && i != 4){
					toutVide = false;
					break;
				}
			}
			p("(150)test set 1 element (2/2) : " + toutVide);
		}
		catch(Throwable e){
			p("(150)test set 1 element (2/2) : crash");
		}

		try{
			BitSet bs = new BitSet(150);
			for(int i = 0; i % 3 == 0; ++i){
				bs.set(i);
			}
			boolean check = true;
			for(int i = 0; i % 3 == 0; ++i){
				if(!bs.get(i)){
					check = false;
					break;
				}
			}
			p("(150)test set une coupe d'elements (1/2) : " + check);
		}
		catch(Throwable e){
			p("(150)test set une coupe d'elements (1/2) : crash");
		}

		try{
			BitSet bs = new BitSet(150);
			for(int i = 0; i % 3 == 0; ++i){
				bs.set(i);
			}
			boolean check = true;
			for(int i = 0; i % 3 != 0; ++i){
				if(bs.get(i)){
					check = false;
					break;
				}
			}
			p("(150)test set une coupe d'elements (2/2) : " + check);
		}
		catch(Throwable e){
			p("(150)test set une coupe d'elements (2/2) : crash");
		}


		try{
			BitSet bs = new BitSet(150);
			for(int i = 0; i < 150; ++i){
				bs.set(i);
			}
			boolean check = true;
			for(int i = 0; i < 150; ++i){
				if(!bs.get(i)){
					check = false;
					break;
				}
			}
			p("(150)test set une tous les elements : " + check);
		}
		catch(Throwable e){
			p("(150)test set une tous les elements : crash");
		}

		try{
			BitSet bs = new BitSet(32);
			bs.set(4);
			bs.set(4);
			bs.set(4);
			bs.set(4);
			p("test set plusieurs fois le meme element : " + bs.get(4));
		}
		catch(Throwable e){
			p("test set plusieurs fois le meme element : crash");
		}

		try{
			BitSet bs = new BitSet(32);
			bs.set(-5);
			p("test set elements outofbound (1/2) : " + !bs.get(-5));
		}
		catch(Throwable e){
			p("test set elements outofbound (1/2) : true");
		}

		try{
			BitSet bs = new BitSet(32);
			bs.set(852);
			p("test set elements outofbound (2/2) : " + !bs.get(852));
		}
		catch(Throwable e){
			p("test set elements outofbound (2/2) : true");
		}


		try{
			BitSet bs = new BitSet(32);
			bs.set(4);
			bs.clear(4);
			p("test clear un element : " + !bs.get(4));
		}
		catch(Throwable e){
			p("test clear un element : crash");
		}

		try{
			BitSet bs = new BitSet(32);
			for(int i = 0; i < 32; ++i){
				bs.set(i);
			}
			for(int i = 0; i < 32; ++i){
				bs.clear(i);
			}
			boolean toutVide = true;
			for(int i = 0; i < 32; ++i){
				if(bs.get(i)){
					toutVide = false;
					break;
				}
			}
			p("test tout clear : " + toutVide);
		}
		catch(Throwable e){
			p("test tout clear : crash");
		}

		try{
			BitSet bs = new BitSet(32);
			bs.clear(-5);
			p("test clear elements outofbound (1/2) : " + !bs.get(-5));
		}
		catch(Throwable e){
			p("test clear elements outofbound (1/2) : true");
		}

		try{
			BitSet bs = new BitSet(32);
			bs.clear(852);
			p("test clear elements outofbound (2/2) : " + !bs.get(852));
		}
		catch(Throwable e){
			p("test clear elements outofbound (2/2) : true");
		}



		System.out.println("\n\n================== Test de BloomFilter ==================");
		System.out.println("\tConstructeur #1");

		try{
			BloomFilter bf = new BloomFilter(32, 1);
			p("test size : " + (bf.size() == 32));
		}
		catch(Throwable e){
			p("test size : crash");
		}
		try{
			BloomFilter bf = new BloomFilter(32, 1);
			p("test count : " + (bf.count() == 0));
		}
		catch(Throwable e){
			p("test count : crash");
		}
		try{
			BloomFilter bf = new BloomFilter(32, 1);
			p("test fpp : " + (bf.fpp() == 0.0 ? "true" : ("false, fpp = " + bf.fpp())));
		}
		catch(Throwable e){
			p("test fpp : crash");
		}

		System.out.println("\tConstructeur #2");

		try{
			BloomFilter bf = new BloomFilter(50, 0.5);
			p("test size (73): " + (bf.size() == 73 ? "true" : ("false, size = " + bf.size())));
		}
		catch(Throwable e){
			p("test size (73): crash");
		}
		try{
			BloomFilter bf = new BloomFilter(50, 0.5);
			p("test count : " + (bf.count() == 0));
		}
		catch(Throwable e){
			p("test count : crash");
		}
		try{
			BloomFilter bf = new BloomFilter(50, 0.5);
			p("test fpp : " + (bf.fpp() == 0.0 ? "true" : ("false, fpp = " + bf.fpp())));
		}
		catch(Throwable e){
			p("test fpp : crash");
		}





		System.out.println("\tCount");
		try{
			BloomFilter bf = new BloomFilter(256, 1);
			for(int i = 0; i < 5; ++i){
				bf.add(("Simone Saint-Laurent" + i).getBytes("US-ASCII"));
			}
			p("test count (1/3) : " + (bf.count() == 5));
		}
		catch(Throwable e){
			p("test count (1/3) : crash");
		}
		try{
			BloomFilter bf = new BloomFilter(256, 2);
			for(int i = 0; i < 5; ++i){
				bf.add(("Claude Cayer" + i).getBytes("US-ASCII"));
			}
			p("test count (2/3) : " + (bf.count() == 5));
		}
		catch(Throwable e){
			p("test count (2/3) : crash");
		}
		try{
			BloomFilter bf = new BloomFilter(256, 2);
			for(int i = 0; i < 7490; ++i){
				bf.add(("Zoe Cayer" + i).getBytes("US-ASCII"));
			}
			p("test count (3/3) : " + (bf.count() == 7490));
		}
		catch(Throwable e){
			p("test count (3/3) : crash");
		}





		System.out.println("\tfpp");
		try{
			BloomFilter bf = new BloomFilter(5000, 0.2);
			double debut = bf.fpp();
			for(int i = 0; i < 5000; ++i){
				bf.add(("Le p'tit Jeremy" + i).getBytes("US-ASCII"));
			}
			double fin = bf.fpp();
			p("test fpp (1/3): " + (debut == 0.0));
			p("test fpp (2/3): " + ((Math.abs(fin - 0.2) <= 0.05) ? true : ("false , fpp : " + fin)));;
		}
		catch(Throwable e){
			p("test fpp : crash");
		}
		try{
			BloomFilter bf = new BloomFilter(20, 0.2);
			for(int i = 0; i < 100000; ++i){
				bf.add(("Mike Ward" + i).getBytes("US-ASCII"));
			}
			double fin = bf.fpp();
			p("test fpp (3/3): " + ((Math.abs(fin - 1) <= 0.01) ? true : ("false , fpp : " + fin)));;
		}
		catch(Throwable e){
			p("test fpp : crash");
		}




		System.out.println("\tadd-contains (1 fonction)");
		try{
			BloomFilter bf = new BloomFilter(32, 1);
			bf.add(("Bobby Hill").getBytes("US-ASCII"));

			p("test contains simple (1/2) : " + (bf.contains(("Bobby Hill").getBytes("US-ASCII"))));
		}
		catch(Throwable e){
			p("test contains simple(1/2) : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(32000, 1);
			bf.add(("Henri Hill").getBytes("US-ASCII"));
			int nombre = bf.contains(("Dan Grenier").getBytes("US-ASCII")) ? 1 : 0;
			nombre += bf.contains(("Boule Goyette").getBytes("US-ASCII")) ? 1 : 0;
			nombre += bf.contains(("Papineau").getBytes("US-ASCII")) ? 1 : 0;

			p("test contains simple(2/2) : " + (nombre <= 1)); //ce test va échouer avec un probabilité assez faible
		}
		catch(Throwable e){
			p("test contains simple(2/2) : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(32, 1);

			p("test contains sans add : " + !(bf.contains(("John Sept-Grains").getBytes("US-ASCII"))));
		}
		catch(Throwable e){
			p("test contains sans add : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(32, 1);
			String paulette = "Paulette Hill";
			for(int i = 0; i < 25; ++i){
				paulette = paulette + paulette;
			}
			p("test contains gros element : " + !(bf.contains((paulette).getBytes("US-ASCII"))));
		}
		catch(Throwable e){
			p("test contains gros element : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(3200, 1);
			for(int i = 0; i < 500; ++i){
				bf.add(("Kahn Souphanousinphone" + i).getBytes("US-ASCII"));
			}

			int quantite = 500;
			for(int i = 0; i < 500; ++i){
				if(!bf.contains(("Kahn Souphanousinphone" + i).getBytes("US-ASCII"))){
					--quantite;
				}
			}

			p("test contains complexe : " + ((quantite == 500) ? "true" : ("false, " + quantite + "/500 de reussis")));
		}
		catch(Throwable e){
			p("test contains complexe : crash");
		}






		System.out.println("\tadd-contains (plusieurs fonction)");
		try{
			BloomFilter bf = new BloomFilter(3200, 32);
			bf.add(("Bobby Hill").getBytes("US-ASCII"));

			p("test contains simple(1/2) : " + (bf.contains(("Bobby Hill").getBytes("US-ASCII"))));
		}
		catch(Throwable e){
			p("test contains simple(1/2) : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(32000, 32);
			bf.add(("Henri Hill").getBytes("US-ASCII"));
			int nombre = bf.contains(("Dan Grenier").getBytes("US-ASCII")) ? 1 : 0;
			nombre += bf.contains(("Boule Goyette").getBytes("US-ASCII")) ? 1 : 0;
			nombre += bf.contains(("Papineau").getBytes("US-ASCII")) ? 1 : 0;

			p("test contains simple(2/2) : " + (nombre <= 1)); //ce test va échouer avec un probabilité assez faible
		}
		catch(Throwable e){
			p("test contains simple(2/2) : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(3200, 32);

			p("test contains sans add : " + !(bf.contains(("John Sept-Grains").getBytes("US-ASCII"))));
		}
		catch(Throwable e){
			p("test contains sans add : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(3200, 5);
			String paulette = "Paulette Hill";
			for(int i = 0; i < 25; ++i){
				paulette = paulette + paulette;
			}
			p("test contains gros element : " + !(bf.contains((paulette).getBytes("US-ASCII"))));
		}
		catch(Throwable e){
			p("test contains gros element : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(32000, 32);
			for(int i = 0; i < 500; ++i){
				bf.add(("Kahn Souphanousinphone" + i).getBytes("US-ASCII"));
			}

			int quantite = 500;
			for(int i = 0; i < 500; ++i){
				if(!bf.contains(("Kahn Souphanousinphone" + i).getBytes("US-ASCII"))){
					--quantite;
				}
			}

			p("test contains complexe : " + ((quantite == 500) ? "true" : ("false, " + quantite + "/500 de reussis")));
		}
		catch(Throwable e){
			p("test contains complexe : crash");
		}




		System.out.println("\tReset");
		try{
			BloomFilter bf = new BloomFilter(3200, 1);
			for(int i = 0; i < 500; ++i){
				bf.add(("Gérard D. Laflaque" + i).getBytes("US-ASCII"));
			}

			bf.reset();
			boolean reponse = true;
			for(int i = 0; i < 500; ++i){
				if(bf.contains(("Gérard D. Laflaque" + i).getBytes("US-ASCII"))){
					reponse = false;
				}
			}

			p("test reset (contains) : " + reponse);
			p("test reset (count) : " + (bf.count() == 0));
			p("test reset (size) : " + (bf.size() == 3200));
			p("test reset (fpp) : " + (bf.fpp() == 0.0));
		}
		catch(Throwable e){
			p("test reset : crash");
		}





		System.out.println("\n\n================== Test de Hashing ==================");
		System.out.println("\tPermutations");
		try{
			BloomFilter bf = new BloomFilter(16, 1);
			byte[] elements = ("abcdefghi").getBytes("US-ASCII");
			bf.add(elements);
			int matches = 0;
			int n = elements.length;

			//L'algo pour generer les permutations est inspiré de https://www.baeldung.com/java-array-permutations

			int[] indexes = new int[n];
			for (int i = 0; i < n; i++) {
				indexes[i] = 0;
			}

			int i = 0;
			while (i < n) {
				if (indexes[i] < i) {
					swap(elements, i % 2 == 0 ?  0: indexes[i], i);

					//===============
					if(bf.contains(elements)){
						++matches;
					}
					//================

					indexes[i]++;
					i = 0;
				}
				else {
					indexes[i] = 0;
					i++;
				}
			}

			double ecart = (1.0/16) - (matches / 362879.0);
			boolean result = (Math.abs(ecart) <= 0.008);
			p(result + ", ecart de " + ecart);

		}
		catch(Throwable e){
			p("crash");
		}



		System.out.println("\tMeme debut");
		try{
			BloomFilter bf = new BloomFilter(16, 1);
			byte[] elements = ("Lumbridge").getBytes("US-ASCII");
			bf.add(elements);
			int matches = 0;

			byte[] elementsPlus1 = new byte[elements.length + 1];
			byte[] elementsPlus2 = new byte[elements.length + 2];
			for(int i = 0; i < elements.length; ++i){
				elementsPlus1[i] = elements[i];
				elementsPlus2[i] = elements[i];
			}

			for(int i = 0; i < 256; ++i){
				elementsPlus1[elementsPlus1.length-1] = (byte)i;
				elementsPlus2[elementsPlus1.length-2] = (byte)i;
				if(bf.contains(elementsPlus1)){
						++matches;
				}
				for(int j = 0; j < 256; ++j){
					elementsPlus2[elementsPlus2.length-1] = (byte)j;
					if(bf.contains(elementsPlus2)){
						++matches;
					}
				}
			}



			double ecart = (1.0/16) - (matches / 65792.0);
			boolean result = (Math.abs(ecart) <= 0.012);
			p("(1/2) : " + result + ", ecart de " + ecart);

		}
		catch(Throwable e){
			p("(1/2) : crash");
		}

		try{
			BloomFilter bf = new BloomFilter(16, 1);
			byte[] elements = ("Varrock").getBytes("US-ASCII");
			bf.add(elements);
			int matches = 0;

			for(int i = 1; i <= 20000; ++i){
				byte[] elementsAvecDesZeros = new byte[elements.length + i];
				for(int j = 0; j < elements.length; ++j){
					elementsAvecDesZeros[j] = elements[j];
				}

				if(bf.contains(elementsAvecDesZeros)){
						++matches;
				}
			}

			double ecart = (1.0/16) - (matches / 20000.0);
			boolean result = (Math.abs(ecart) <= 0.015);
			p("(2/2) : " + result + ", ecart de " + ecart);

		}
		catch(Throwable e){
			p("(2/2) : crash");
		}


		System.out.println("\tBcp de choses (1 fonction)");
		try{
			BloomFilter bf = new BloomFilter(16, 1);
			byte[] elements = ("Ardougne").getBytes("US-ASCII");
			bf.add(elements);
			int matches = 0;

			for(int i = 0; i < 500000 ; ++i){
				if(bf.contains(("" + i).getBytes("US-ASCII"))){
						++matches;
				}
			}

			double ecart = (1.0/16) - (matches / 500000.0);
			boolean result = (Math.abs(ecart) <= 0.005);
			p(result + ", ecart de " + ecart);

		}
		catch(Throwable e){
			p("crash");
		}

		System.out.println("\tBcp de choses (plusieurs fonctions)");
		try{
			double moyenne = 0;
			for(int k = 0; k < 10; ++k){
				BloomFilter bf = new BloomFilter(256, 16);
				byte[] elements = ("Falador").getBytes("US-ASCII");
				bf.add(elements);
				int matches = 0;

				for(int i = 0; i < 50000 ; ++i){
					if(bf.contains(("" + i).getBytes("US-ASCII"))){
						++matches;
					}
				}

				moyenne += (matches / 50000.0);
			}
			moyenne /= 10;
			boolean result = (moyenne <= 0.00005);
			p(result + ", ecart de " + moyenne);


		}
		catch(Throwable e){
			p("crash");
		}


		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / 1000000000.0;

		System.out.println("\n\nTemps total d'execution des tests : " + duration + " secondes");




	}



	public static void p(String s){
		System.out.println("\t\t" + s);
	}

	private static void swap(byte[] input, int a, int b) {
		byte tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

	private static void printArray(byte[] input) {
		System.out.print('\n');
		for(int i = 0; i < input.length; i++) {
			System.out.print((char)input[i]);
		}
}
}
