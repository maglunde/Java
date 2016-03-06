/*
 * Copyright (c) 2016.
 */

package problems;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Created by per on 04.02.2016.
 */
public class Utility {

    public static int[] getPrimes() {
	return getPrimes(Integer.MAX_VALUE);
    }

    public static int primeAtPosSieve(int pos) {
	return -1;
    }

    // Sieve of Erasthronrlotrodeles Komopuloss
    public static int[] primeSieve1(int lim) {
	boolean[] isPrime = new boolean[lim];
	for (int i = 2; i < lim; i++)
	    isPrime[i] = true;

	for (int i = 2; i * i < lim; i++) {
	    if (isPrime[i]) {
		for (int j = i; i * j < lim; j++) {
		    isPrime[i * j] = false;

		}
	    }
	}
	int c = 0;
	for (int i = 0; i < isPrime.length; i++)
	    if (isPrime[i])
		c++;

	int[] primes = new int[c];

	for (int i = 0, k = 0; i < lim; i++)
	    if (isPrime[i])
		primes[k++] = i;

	return primes;
    }

    public static int[] getPrimes(int lim) {
	int[] primes = new int[lim];
	int c = 0;

	for (int i = 2; c < lim; i++) {
	    int j;
	    boolean isPrime = true;
	    for (j = 0; j < c; j++) {
		int p = primes[j];
		if (i % p == 0) {
		    isPrime = false;
		    break;
		}
	    }
	    if (isPrime) {
		primes[c++] = i;
	    }
	}

	return primes;

    }

    private static int[] bitsetToArr(BitSet primes) {
	int[] arr = new int[primes.cardinality()];
	int i = 0;

	for (int j = 0; j < primes.length(); j++) {
	    if (primes.get(j)) {
		arr[i++] = j;
		if (i < 10)
		    System.out.println(j);
	    }
	}
	System.out.println(Arrays.toString(arr));
	return arr;
    }

    // SLOOOW
    public static int getPrimeAtPos(int pos) {
	List<Integer> primes = new ArrayList();
	primes.add(2);

	for (int i = 2, c = 0; primes.size() < pos; i++) {

	    boolean isPrime = true;
	    for (int j = 0; j < primes.size(); j++) {

		int p = primes.get(j);
		if (i % p == 0) {
		    isPrime = false;
		    break;
		}
	    }
	    if (isPrime) {
		primes.add(i);
		c++;
	    }
	}
	return primes.get(primes.size() - 1);
    }

    public static long gcd(long a, long b) {
	while (b > 0) {
	    long temp = b;
	    b = a % b;
	    a = temp;
	}
	return a;
    }

    public static long gcd(long[] input) {
	long result = input[0];
	for (int i = 1; i < input.length; i++)
	    result = gcd(result, input[i]);
	return result;
    }

    public static long lcm(long a, long b) {
	return a * (b / gcd(a, b));
    }

    public static long lcm(long[] input) {
	long result = input[0];
	for (int i = 1; i < input.length; i++)
	    result = lcm(result, input[i]);
	return result;
    }

    public static long lcm(int a, int b, boolean range) {
	if (a > b)
	    throw new IllegalArgumentException("a > b not allowed");
	if (!range)
	    return lcm(a, b);

	long[] arr = new long[b - a];
	for (int i = 0; i < b - a; i++) {
	    arr[i] = i + a;
	}

	return lcm(arr);
    }

    public static long maxPathSum(ArrayList<Integer> verdier) {

	Integer[] arr = verdier.toArray(new Integer[0]);
	return maxPathSum(arr);

    }

    public static long maxPathSum(Integer[] verdier) {

	int høyde = trekantHøyde(verdier);

	int antallFullTrekant = (int) ((høyde + 1) * ((double) høyde / 2));
	if (verdier.length != antallFullTrekant) {
	    // Fyll ufullstendig trekant med 0-verdier
	    Integer[] verdierFull = new Integer[antallFullTrekant];
	    for (int i = 0; i < verdier.length; i++) {
		verdierFull[i] = verdier[i];
	    }
	    for (int i = verdier.length; i < verdierFull.length; i++) {
		verdierFull[i] = 0;
	    }
	    verdier = verdierFull;
	}
	// System.out.println(visTrekant(verdier));

	// Start på nest nederste linje og sett verdi += den største av de to
	// verdiene under, for hver linje til toppen
	for (int i = verdier.length - høyde; høyde > 0; i -= --høyde)
	    if (i + høyde < verdier.length)
		for (int j = i; j < i + høyde; j++) {
		    verdier[j] += Math.max(verdier[j + høyde], verdier[j + høyde + 1]);
		}

	return verdier[0];
    }

    private static int trekantHøyde(Integer[] verdier) {
	int høyde = 1, teller = 0;

	// Finn høyden på trekanten
	for (int i = 0; i < verdier.length; i++)
	    if (++teller == høyde) {
		høyde++;
		teller = 0;
	    }
	høyde -= teller == 0 ? 1 : 0;
	return høyde;
    }

    public static void skrivTrekantTilFil(Integer[] verdier, String filnavn) throws FileNotFoundException {
	StringBuilder strBuilder = new StringBuilder();
	for (int i = 0; i < verdier.length; i++) {
	    strBuilder.append(verdier[i]).append(" ");
	}
	PrintWriter out = new PrintWriter(filnavn);
	out.write(strBuilder.toString());
	out.close();
    }

    private static String visTrekant(Integer[] verdier) throws FileNotFoundException {
	StringBuilder strBuilder = new StringBuilder();
	int antall = verdier.length;
	int høyde = 1, teller = 0;
	for (int i = 1; i <= antall; i++) {
	    if (++teller == høyde) {
		teller = 0;
		høyde++;
	    }
	}
	int nivå = 1, verdi;
	teller = 0;
	for (int i = 0; i < antall; i++) {
	    if (teller == 0)
		for (int j = nivå; j < høyde; j++)
		    strBuilder.append("  ");
	    verdi = verdier[i];
	    strBuilder.append(((Integer) verdi).toString().length() > 1 ? "" : "0");
	    strBuilder.append(verdi).append("  ");

	    if (++teller == nivå) {
		teller = 0;
		nivå++;
		strBuilder.append("\n");
	    }
	}

	return strBuilder.toString();
    }

    public static int getSumAmicable(int limit) {
	int sumA,sumB,total=0;
	BitSet bitset = new BitSet(limit);
	bitset.set(0, limit-1, false);
	
	for (int n = 0; n < limit; n++) {
	    if(bitset.get(n))
		continue;
	    sumA=1;sumB=1;
	    for (int i = 2; i < Math.sqrt(n); i++) {
		if (n % i == 0) {
		    sumA += i + n / i;
		}
	    }
	    for (int i = 2; i < Math.sqrt(sumA); i++) {
		if (sumA % i == 0) {
		    sumB += i + sumA / i;
		}
	    }
	    if(n==sumB && n != sumA ) {
		total += sumA+sumB;
		bitset.set(sumA,true);
		bitset.set(sumB,true);
		System.out.println(sumA+" "+sumB);
	    }
	}

	return total;
    }
}
