package problems;

/*
 * Copyright (c) 2016.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Euler {
    public static void main(String[] args) throws IOException {
	int n = 2_000_000;
	long start, stop;

	// _1();
	// _2();
	// _3();
	// _4();
	// _5();
	// _6();
	// _7();
	// _8();
	// _9();
	// _10();
	// _11();
	// _12();
	// _14();
	// _16();
	// _17();
	// _18();
	// _19();
	// _20();
	// _21();
	// _22();
	// _23();
	// _24();
	// _25();
	// _26();
	_27();

	// _67();
	// bigTriangle();

    }
    
    private static void _27() {
	// Considering n² + an + b, where |a| < 1000 and |b| < 1000
	// Find the product of the coefficients, a and b, for the quadratic expression 
	// that produces the maximum number of primes for consecutive values of n, starting with n = 0.
	
	int lim = 1000;
	
	int a=lim*-1, b=lim*-1, n =0, prod, count=0, maxPrimes=0, maxA=-1, maxB=-1;
	int[] primeArray = Utility.primeSieve1(100000);
	
	BitSet bitset = new BitSet(primeArray.length+1);
	bitset.set(0, primeArray.length+1, false);
	for(int p : primeArray)
	    bitset.set(p, true);
	
	while(a++<lim) {
	    while(b++<lim) {
		if(!(b>0 && bitset.get(b))) 
		    continue;
		prod = n*n+a*n+b;
		while(prod > 0 && bitset.get(prod)) {
		    n++;
		    count++;
		    prod = n*n+a*n+b;
		}
		if(count > maxPrimes) {
		    maxPrimes = count;
		    maxA = a; 
		    maxB=b;
		}
		n=0;
		count=0;
	    }
	    b=0;
	}
	System.out.println("Problem 27:\t" +maxA*maxB);
    }
    
    
    private static void _26() {
	// Find the value of d < 1000 for which 1/d contains the longest
	// recurring cycle in its decimal fraction part.
	int limit = 1000;
	
	int max = 0, maxIdx=-1, order;
	for (int i = 2; i < limit; i++) {
	    order = Utility.reccurringLength(i);
	    if(max < order) {
		max = Math.max(max, order);
		maxIdx=i;
	    }
	}
	
	System.out.println("Problem 26:\t" + maxIdx);
	

    }

    private static void _25() {
	// What is the index of the first term in the Fibonacci sequence to
	// contain 1000 digits?
	BigInteger a, b, c;
	a = new BigInteger("1");
	b = new BigInteger("1");
	c = new BigInteger("1");

	int i = 2;

	while (c.toString().length() < 1000) {
	    c = c.add(a);
	    a = b;
	    b = c;
	    i++;
	}
	System.out.println("Problem 25:\t" + i);

    }

    private static void _24() {
	// What is the millionth lexicographic permutation of the digits 0, 1,
	// 2, 3, 4, 5, 6, 7, 8 and 9?

	final String str = "0123456789";
	StringBuilder sb = new StringBuilder(str);
	StringBuilder sb2 = new StringBuilder();

	int k = 1000000, r, q, n, nf;
	for (int i = str.length() - 1; i > 0; i--) {
	    q = 0;
	    nf = Utility.factorial(i);
	    do {
		q++;
		r = k - q * nf;
	    } while (r > nf);

	    char c = sb.toString().charAt(q);
	    sb.deleteCharAt(q);
	    sb2.append(c);
	    k = r;
	}
	sb2.append(sb.toString());
	System.out.println(sb2.toString());

    }

    private static void _23() {
	// Find the sum of all the positive integers which cannot be written as
	// the sum of two abundant numbers.
	int limit = 28123, sum = 0;

	long start = System.currentTimeMillis();
	ArrayList<Integer> abundantNumbers = Utility.getAbundantNums(limit);
	System.out.println("get abundants: " + (System.currentTimeMillis() - start) + "ms");

	start = System.currentTimeMillis();
	ArrayList<Integer> notSumOfTwoAbundants = Utility.getNotSumOfTwoAbundants(abundantNumbers, limit);
	System.out.println("get notsums: " + (System.currentTimeMillis() - start) + "ms");

	for (Integer i : notSumOfTwoAbundants) {
	    sum += i;
	}

	System.out.println("Problem 23:\t" + sum);

    }

    private static void _22() {
	URL url;
	ArrayList<String> names = new ArrayList<>();
	try {
	    url = new URL("http://projecteuler.net/project/resources/p022_names.txt");
	    Scanner fileScanner = new Scanner(url.openStream());
	    fileScanner.useDelimiter(",");
	    String str;

	    while (fileScanner.hasNext()) {
		str = fileScanner.next().replaceAll("\"", "");
		names.add(str);
	    }
	    fileScanner.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	names.sort(new StringComparator());

	long nameScores = 0;
	long a = System.currentTimeMillis();
	// for (int i=0;i<names.size();i++) {
	// nameScores+= Utility.nameScore(names.get(i)) * (i+1);
	// };

	System.out.println("Problem 22:\t" + nameScores + "\t" + (System.currentTimeMillis() - a) + "ms");

    }

    private static void _21() {
	// Evaluate the sum of all the amicable numbers under 10000.
	int N = 10_000;
	int sum = Utility.getSumAmicable(N);

	System.out.println("Problem 21: " + sum);
    }

    private static void _20() {
	BigInteger bi = new BigInteger("100");
	for (int i = 99; i > 0; i--) {
	    bi = bi.multiply(BigInteger.valueOf(i));
	}

	String str = bi.toString();

	int sum = 0;
	for (int i = 0; i < str.length(); i++) {
	    sum += str.charAt(i) - '0';
	}

	System.out.println("Problem 20:\t" + sum);

    }

    private static void _19() {
	// How many Sundays fell on the first of the month during the twentieth
	// century (1 Jan 1901 to 31 Dec 2000)?

	Calendar cal = Calendar.getInstance();
	int numSundays = 0;

	cal.set(1901, 0, 1);
	for (; cal.get(Calendar.YEAR) < 2001; cal.add(Calendar.DAY_OF_MONTH, 1)) {

	    numSundays += cal.get(Calendar.DAY_OF_WEEK) == 1 && cal.get(Calendar.DAY_OF_MONTH) == 1 ? 1 : 0;
	}
	System.out.println("Problem 19:\t" + numSundays);

    }

    public static void bigTriangle() throws IOException {

	/*
	 * Uncomment to generate bigtriangle.txt
	 * 
	 * Random r = new Random(); ArrayList<Integer> list = new ArrayList<>();
	 * for (int i = 0; i < 5_000_000; i++) { list.add(r.nextInt(100)); }
	 * Integer[] verdier = list.toArray(new Integer[0]);
	 * Utility.skrivTrekantTilFil(verdier, "bigtriangle.txt");
	 */
	System.out.print(".");
	File file = new File("bigtriangle.txt");
	System.out.print(".");
	BufferedReader br;
	String line;
	ArrayList<Integer> list2 = new ArrayList<>();
	try {
	    br = new BufferedReader(new FileReader(file));
	    System.out.print(".");
	    while ((line = br.readLine()) != null) {
		System.out.print(".");
		String[] arr = line.split("\\s+");
		for (int i = 0; i < arr.length; i++) {
		    list2.add(Integer.parseInt(arr[i]));
		    if (i % 1_000_000 == 0)
			System.out.print(".");

		}
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	long start = System.currentTimeMillis();
	System.out.println("\nBigTriangle:\t" + Utility.maxPathSum(list2));
	long stop = System.currentTimeMillis();
	System.out.println(stop - start + "ms");
    }

    private static void _67() {
	// Read from local file
	File file = new File("p067_triangle.txt");
	BufferedReader br;
	String line;
	ArrayList<Integer> list = new ArrayList<>();
	try {
	    br = new BufferedReader(new FileReader(file));
	    while ((line = br.readLine()) != null) {
		String[] arr = line.split("\\s+");
		for (int i = 0; i < arr.length; i++) {
		    list.add(Integer.parseInt(arr[i]));
		}
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	System.out.println("Problem 67:\t" + Utility.maxPathSum(list));

	// Read from web
	URL url;
	ArrayList<Integer> list2 = new ArrayList<>();
	try {

	    url = new URL("https://projecteuler.net/project/resources/p067_triangle.txt");
	    Scanner fileScanner = new Scanner(url.openStream());

	    while (fileScanner.hasNext()) {
		list2.add(Integer.parseInt(fileScanner.next()));
	    }

	    fileScanner.close();

	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	System.out.println("Problem 67:\t" + Utility.maxPathSum(list2));

    }

    private static void _18() {
	Integer[] verdier = { 75, 95, 64, 17, 47, 82, 18, 35, 87, 10, 20, 04, 82, 47, 65, 19, 01, 23, 75, 03, 34, 88,
		02, 77, 73, 07, 63, 67, 99, 65, 04, 28, 06, 16, 70, 92, 41, 41, 26, 56, 83, 40, 80, 70, 33, 41, 48, 72,
		33, 47, 32, 37, 16, 94, 29, 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14, 70, 11, 33, 28, 77, 73, 17, 78,
		39, 68, 17, 57, 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48, 63, 66, 04, 68, 89, 53, 67, 30, 73,
		16, 69, 87, 40, 31, 04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23 };

	System.out.println("Problem 18:\t" + Utility.maxPathSum(verdier));

    }

    private static void _17() {
	String str = "";

	for (int i = 1; i <= 1000; i++)
	    str += writtenNumber(i);

	str = str.replace(" ", "");
	System.out.println("Problem 17:\t" + str.length());
    }

    private static String writtenNumber(int n) {
	String str = "";
	int d;

	if (n == 1000) {
	    return "one thousand";

	} else if (n >= 100) {
	    d = n / 100;
	    str += writtenDigit(d);
	    str += " hundred";
	    n %= 100;
	}
	if (n >= 20) {
	    d = n / 10;
	    str += str.equals("") ? "" : " and ";
	    switch (d) {
	    case 2:
		str += "twenty";
		break;
	    case 3:
		str += "thirty";
		break;
	    case 4:
		str += "forty";
		break;
	    case 5:
		str += "fifty";
		break;
	    case 6:
		str += "sixty";
		break;
	    case 7:
		str += "seventy";
		break;
	    case 8:
		str += "eighty";
		break;
	    case 9:
		str += "ninety";
		break;
	    }
	    d = n % 10;
	    str += writtenDigit(d);

	    n = 0;
	} else if (n >= 10) {
	    str += str.equals("") ? "" : " and ";
	    switch (n) {
	    case 10:
		str += "ten";
		break;
	    case 11:
		str += "eleven";
		break;
	    case 12:
		str += "twelve";
		break;
	    case 13:
		str += "thirteen";
		break;
	    case 14:
		str += "fourteen";
		break;
	    case 15:
		str += "fifteen";
		break;
	    case 16:
		str += "sixteen";
		break;
	    case 17:
		str += "seventeen";
		break;
	    case 18:
		str += "eighteen";
		break;
	    case 19:
		str += "nineteen";
		break;

	    }
	    n = 0;
	}
	if (n > 0) {
	    str += str.equals("") ? "" : " and ";
	    str += writtenDigit(n);

	}

	return str;
    }

    private static String writtenDigit(int d) {
	String str = "";
	switch (d) {
	case 1:
	    str = "one";
	    break;
	case 2:
	    str = "two";
	    break;
	case 3:
	    str = "three";
	    break;
	case 4:
	    str = "four";
	    break;
	case 5:
	    str = "five";
	    break;
	case 6:
	    str = "six";
	    break;
	case 7:
	    str = "seven";
	    break;
	case 8:
	    str = "eight";
	    break;
	case 9:
	    str = "nine";
	    break;
	}
	return str;
    }

    private static void _16() {
	BigInteger two = new BigInteger("2");
	int sum = 0;

	String s = two.pow(1000).toString();
	for (int i = 0; i < s.length(); i++) {
	    sum += s.charAt(i) - 48;
	}
	System.out.println("Problem 16:\t" + sum);

    }

    private static void _14() {
	int N = 1_000_000, max = 0, maxIdx = 0, len = 0;
	for (int i = 1; i < N; i++) {
	    len = CollatzLen(i);
	    if (len > max) {
		max = len;
		maxIdx = i;
	    }
	}
	//
	System.out.println("Problem 14:\tindex: " + maxIdx + ", length: " + max);

    }

    private static int CollatzLen(long n) {
	int len = 1;
	while (n > 1) {
	    // System.out.print(n+" ");
	    len++;
	    if (n % 2 == 0)
		n /= 2;
	    else
		n = 3 * n + 1;
	}
	// System.out.println(n);
	return len;
    }

    private static void _12() {
	String[] arr = { "37107287533902102798797998220837590246510135740250",
		"46376937677490009712648124896970078050417018260538",
		"74324986199524741059474233309513058123726617309629",
		"91942213363574161572522430563301811072406154908250",
		"23067588207539346171171980310421047513778063246676",
		"89261670696623633820136378418383684178734361726757",
		"28112879812849979408065481931592621691275889832738",
		"44274228917432520321923589422876796487670272189318",
		"47451445736001306439091167216856844588711603153276",
		"70386486105843025439939619828917593665686757934951",
		"62176457141856560629502157223196586755079324193331",
		"64906352462741904929101432445813822663347944758178",
		"92575867718337217661963751590579239728245598838407",
		"58203565325359399008402633568948830189458628227828",
		"80181199384826282014278194139940567587151170094390",
		"35398664372827112653829987240784473053190104293586",
		"86515506006295864861532075273371959191420517255829",
		"71693888707715466499115593487603532921714970056938",
		"54370070576826684624621495650076471787294438377604",
		"53282654108756828443191190634694037855217779295145",
		"36123272525000296071075082563815656710885258350721",
		"45876576172410976447339110607218265236877223636045",
		"17423706905851860660448207621209813287860733969412",
		"81142660418086830619328460811191061556940512689692",
		"51934325451728388641918047049293215058642563049483",
		"62467221648435076201727918039944693004732956340691",
		"15732444386908125794514089057706229429197107928209",
		"55037687525678773091862540744969844508330393682126",
		"18336384825330154686196124348767681297534375946515",
		"80386287592878490201521685554828717201219257766954",
		"78182833757993103614740356856449095527097864797581",
		"16726320100436897842553539920931837441497806860984",
		"48403098129077791799088218795327364475675590848030",
		"87086987551392711854517078544161852424320693150332",
		"59959406895756536782107074926966537676326235447210",
		"69793950679652694742597709739166693763042633987085",
		"41052684708299085211399427365734116182760315001271",
		"65378607361501080857009149939512557028198746004375",
		"35829035317434717326932123578154982629742552737307",
		"94953759765105305946966067683156574377167401875275",
		"88902802571733229619176668713819931811048770190271",
		"25267680276078003013678680992525463401061632866526",
		"36270218540497705585629946580636237993140746255962",
		"24074486908231174977792365466257246923322810917141",
		"91430288197103288597806669760892938638285025333403",
		"34413065578016127815921815005561868836468420090470",
		"23053081172816430487623791969842487255036638784583",
		"11487696932154902810424020138335124462181441773470",
		"63783299490636259666498587618221225225512486764533",
		"67720186971698544312419572409913959008952310058822",
		"95548255300263520781532296796249481641953868218774",
		"76085327132285723110424803456124867697064507995236",
		"37774242535411291684276865538926205024910326572967",
		"23701913275725675285653248258265463092207058596522",
		"29798860272258331913126375147341994889534765745501",
		"18495701454879288984856827726077713721403798879715",
		"38298203783031473527721580348144513491373226651381",
		"34829543829199918180278916522431027392251122869539",
		"40957953066405232632538044100059654939159879593635",
		"29746152185502371307642255121183693803580388584903",
		"41698116222072977186158236678424689157993532961922",
		"62467957194401269043877107275048102390895523597457",
		"23189706772547915061505504953922979530901129967519",
		"86188088225875314529584099251203829009407770775672",
		"11306739708304724483816533873502340845647058077308",
		"82959174767140363198008187129011875491310547126581",
		"97623331044818386269515456334926366572897563400500",
		"42846280183517070527831839425882145521227251250327",
		"55121603546981200581762165212827652751691296897789",
		"32238195734329339946437501907836945765883352399886",
		"75506164965184775180738168837861091527357929701337",
		"62177842752192623401942399639168044983993173312731",
		"32924185707147349566916674687634660915035914677504",
		"99518671430235219628894890102423325116913619626622",
		"73267460800591547471830798392868535206946944540724",
		"76841822524674417161514036427982273348055556214818",
		"97142617910342598647204516893989422179826088076852",
		"87783646182799346313767754307809363333018982642090",
		"10848802521674670883215120185883543223812876952786",
		"71329612474782464538636993009049310363619763878039",
		"62184073572399794223406235393808339651327408011116",
		"66627891981488087797941876876144230030984490851411",
		"60661826293682836764744779239180335110989069790714",
		"85786944089552990653640447425576083659976645795096",
		"66024396409905389607120198219976047599490197230297",
		"64913982680032973156037120041377903785566085089252",
		"16730939319872750275468906903707539413042652315011",
		"94809377245048795150954100921645863754710598436791",
		"78639167021187492431995700641917969777599028300699",
		"15368713711936614952811305876380278410754449733078",
		"40789923115535562561142322423255033685442488917353",
		"44889911501440648020369068063960672322193204149535",
		"41503128880339536053299340368006977710650566631954",
		"81234880673210146739058568557934581403627822703280",
		"82616570773948327592232845941706525094512325230608",
		"22918802058777319719839450180888072429661980811197",
		"77158542502016545090413245809786882778948721859617",
		"72107838435069186155435662884062257473692284509516",
		"20849603980134001723930671666823555245252804609722",
		"53503534226472524250874054075591789781264330331690" };

	BigInteger[] bigs = new BigInteger[arr.length];
	BigInteger sum = new BigInteger(String.valueOf(0));

	for (int i = 0; i < arr.length; i++) {
	    bigs[i] = new BigInteger(arr[i]);
	    sum = sum.add(bigs[i]);
	}

	System.out.println("Problem 12:\t" + sum.toString().substring(0, 10));

    }

    private static void _11() {
	String str = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 "
		+ "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 "
		+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 "
		+ "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 "
		+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 "
		+ "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 "
		+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 "
		+ "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 "
		+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 "
		+ "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 "
		+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 "
		+ "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 "
		+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 "
		+ "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 "
		+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 "
		+ "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 "
		+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 "
		+ "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 "
		+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 "
		+ "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";

	String[] strArr = str.split(" ");
	int[][] arr = new int[20][20];

	int strIdx = 0;
	for (int i = 0; i < 20; i++) {
	    for (int j = 0; j < 20; j++) {
		arr[i][j] = Integer.parseInt(strArr[strIdx++]);
	    }
	}
	int prod = largestProd(arr, 20, 20);

	System.out.println("Problem 11:\t" + prod);

    }

    // greatest product of four adjacent numbers in the same direction (up,
    // down, left, right, or diagonally)
    private static int largestProd(int[][] arr, int m, int n) {
	int max = 0, prod = 1, a, b, c, d, x1 = 0, x2 = 0, y1 = 0, y2 = 0;

	for (int i = 0; i < m; i++) {
	    a = b = c = d = 0;
	    for (int j = 0; j < n; j++) {
		a = arr[i][j];
		if (j < 17) {
		    // Left to right horizontally
		    b = arr[i][j + 1];
		    c = arr[i][j + 2];
		    d = arr[i][j + 3];
		    prod = a * b * c * d;
		    if (max < prod) {
			max = prod;
			// Coords start/stop
			x1 = i;
			y1 = j;
			x2 = i + 3;
			y2 = j;
		    }
		    if (i < 17) {
			// Left to right down diagonally
			b = arr[i + 1][j + 1];
			c = arr[i + 2][j + 2];
			d = arr[i + 3][j + 3];
			prod = a * b * c * d;
			if (max < prod) {
			    max = prod;
			    // Coords start/stop
			    x1 = i;
			    y1 = j;
			    x2 = i + 3;
			    y2 = j + 3;
			}
		    }
		}

		if (i < 17) {
		    // down
		    b = arr[i + 1][j];
		    c = arr[i + 2][j];
		    d = arr[i + 3][j];
		    prod = a * b * c * d;
		    if (max < prod) {
			max = prod;
			// Coords start/stop
			x1 = i;
			y1 = j;
			x2 = i;
			y2 = j + 3;
		    }
		    if (j > 3) {
			// Right to left down diagonally
			b = arr[i + 1][j - 1];
			c = arr[i + 2][j - 2];
			d = arr[i + 3][j - 3];
			prod = a * b * c * d;
			if (max < prod) {
			    max = prod;
			    // Coords start/stop
			    x1 = i;
			    y1 = j;
			    x2 = i;
			    y2 = j + 3;
			}
		    }
		}

	    }
	}

	// System.out.println("\nRESULT : " + max + " (" + x1 + "," + y1 + ")" +
	// " (" + x2 + "," + y2 + ")");
	return prod;
    }

    private static void _10() {
	_10(1_000_000);
    }

    private static void _10(int n) {

	int[] primes = Utility.primeSieve1(n);
	long sum = 0;
	for (int i = 0; i < primes.length; i++)
	    sum += primes[i];

	System.out.println("Problem 10:\t" + sum);
    }

    private static void _9() {
	// There exists exactly one Pythagorean triplet for which a + b + c =
	// 1000. Find the product abc.

	int lim = 1000;
	for (int i = 1; i < lim; i++) {
	    for (int j = i; j < lim; j++) {
		for (int k = 1; k < lim; k++) {
		    if (i * i + j * j == k * k)
			if (i + j + k == 1000)
			    System.out.println("Problem 9:\t" + i * j * k);
		}

	    }
	}
    }

    private static void _8() {
	// Find the thirteen adjacent digits in the 1000-digit number that have
	// the greatest product. What is the value of this product?
	String str = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843"
		+ "8586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557"
		+ // 200
		"6689664895044524452316173185640309871112172238311362229893423380308135336276614282806444486645238749"
		+ "3035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776"
		+ // 400
		"6572733300105336788122023542180975125454059475224352584907711670556013604839586446706324415722155397"
		+ "5369781797784617406495514929086256932197846862248283972241375657056057490261407972968652414535100474"
		+ // 600
		"8216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586"
		+ "1786645835912456652947654568284891288314260769004224219022671055626321111109370544217506941658960408"
		+ // 800
		"0719840385096245544436298123098787992724428490918884580156166097919133875499200524063689912560717606"
		+ "0588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"; // 1000

	int[] arr = new int[str.length()];

	for (int i = 0; i < arr.length; i++) {
	    arr[i] = (int) (str.charAt(i)) - 48;
	}

	int n = 13, start = -1;
	long biggest = -1, prod;
	for (int i = 0; i < arr.length - n; i++) {
	    prod = 1;
	    for (int j = i; j < i + n; j++) {
		if (j == 0)
		    break;
		prod *= arr[j];
	    }
	    if (prod > biggest) {
		biggest = prod;
		start = i;
	    }

	}

	System.out.println("Problem 8:\t" + biggest);
    }

    private static void _7(int n) {

	System.out.println("Problem 7:\t" + Utility.getPrimeAtPos(n));

    }

    private static void _7() {
	_7(10001);
    }

    private static void _6() {
	// Find the difference between the sum of the squares of the first one
	// hundred natural numbers and the square of the sum.
	int lim = 100;
	long sumSq = 0, sqSum = 0;
	for (int i = 1; i <= lim; i++) {
	    sumSq += Math.pow(i, 2);
	    sqSum += i;
	}
	sqSum = (long) Math.pow(sqSum, 2);
	System.out.println("Problem 6:\t" + (Math.max(sqSum, sumSq) - Math.min(sqSum, sumSq)));
    }

    private static void _5() {
	// What is the smallest positive number that is evenly divisible by all
	// of the numbers from 1 to 20?
	Map<Integer, Integer> result = new HashMap<>();
	Map<Integer, Integer> temp = new HashMap<>();
	List<Integer> factors;

	int n = 20;

	for (int i = 2; i < n; i++) {
	    factors = factorize(i);
	    // System.out.println(i+" : "+factors.toString());
	    temp.clear();
	    for (int k : factors) {
		if (temp.containsKey(k)) {
		    temp.put(k, temp.get(k) + 1);
		} else {
		    temp.put(k, 1);
		}
	    }
	    for (int k : temp.keySet()) {
		int tempV = temp.get(k);
		int resultV = result.containsKey(k) ? result.get(k) : 0;
		result.put(k, Math.max(tempV, resultV));
	    }
	}
	int prod = 1;
	for (int f : result.keySet()) {
	    prod *= Math.pow(f, result.get(f));
	}

	System.out.println("Problem 5:\t" + prod);

    }

    private static List<Integer> factorize(int n) {
	List<Integer> factors = new ArrayList();
	int[] primes = Utility.primeSieve1(n + 1);
	// System.out.println(Arrays.toString(primes));

	while (n > 1) {
	    for (int p : primes) {
		if (n % p == 0) {
		    n /= p;
		    factors.add(p);
		    break;
		}
	    }
	}
	return factors;
    }

    private static void _4() {
	// Largest palindrome product

	int prod, biggest = -1;
	for (int i = 999; i >= 100; i--) {
	    for (int j = i; j >= 100; j--) {
		prod = i * j;
		if (prod > biggest) {
		    if (isPalindrome(prod)) {
			biggest = prod;
		    }
		}
	    }
	}
	System.out.println("Problem 4:\t" + biggest);

    }

    private static boolean isPalindrome(int prod) {
	String str = ((Integer) prod).toString();
	String str2 = new StringBuilder(str).reverse().toString();
	return str.equals(str2);

    }

    private static void _3() {
	// What is the largest prime factor of the number 600851475143 ?
	long n = 600851475143L;
	int nSq = (int) Math.floor(Math.sqrt(n));

	int[] primes = Utility.primeSieve1(nSq);
	int p = -1;
	for (int i = primes.length - 1; i >= 0; i--) {
	    p = primes[i];
	    if (n % p == 0)
		break;
	}
	System.out.println("Problem 3:\t" + p);

    }

    private static void _2() {
	// By considering the terms in the Fibonacci sequence whose values do
	// not exceed four million, find the sum of the even-valued terms.
	int a = 1, b = 2, c = a + b, lim = 4_000_000, sum = 0;

	sum += a % 2 == 0 ? a : 0;
	for (int i = 0; b < lim; i++) {
	    c = a + b;
	    a = b;
	    b = c;
	    sum += a % 2 == 0 ? a : 0;
	}
	System.out.println("Problem 2:\t" + sum);

    }

    private static void _1() {
	// Find the sum of all the multiples of 3 or 5 below 1000.
	int lim = 1000, sum = 0;

	for (int i = 0; i < lim; i++) {
	    if (i % 3 == 0 && i % 5 != 0) {
		sum += i;
		continue;
	    }
	    if (i % 5 == 0 && i % 3 != 0) {
		sum += i;
		continue;
	    }
	    if (i % (3 * 5) == 0) {
		sum += i;
	    }
	}

	System.out.println("Problem 1:\t" + sum);

    }
}
