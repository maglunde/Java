package problems;

public class BinTre<T> {
    private static final class Node<T> {
	private T verdi;
	private Node<T> venstre, høyre;

	private Node(T verdi, Node<T> venstre, Node<T> høyre) {
	    this.verdi = verdi;
	    this.venstre = venstre;
	    this.høyre = høyre;
	}

	private Node(T verdi) {
	    this.verdi = verdi;
	}
    } // class Node<T>

    private Node<T> rot;
    private int antall;

    public BinTre() {
	this.rot = null;
	antall = 0;
    }

    public BinTre(int[] posisjon, T[] verdi) {
	if (posisjon.length > verdi.length)
	    throw new IllegalArgumentException("Verditabellen har for få elementer");

	for (int i = 0; i < posisjon.length; i++) {
	    leggInn(posisjon[i], verdi[i]);
	}
    }

    public BinTre(T[] verdi) {
	for (int i = 0; i < verdi.length; i++) {
	    leggInn(i + 1, verdi[i]);
	}
    }

    public void leggInn(int posisjon, T verdi) {
	if (posisjon < 1)
	    throw new IllegalArgumentException("Ugyldig posisjon: " + posisjon);

	Node<T> p = rot, q = null;
	int filter = Integer.highestOneBit(posisjon) >> 1;

	while (p != null && filter != 0) {
	    q = p;
	    p = (posisjon & filter) == 0 ? p.venstre : p.høyre;
	    filter >>= 1;
	}

	if (filter > 0)
	    throw new IllegalArgumentException("Posisjon " + posisjon + " mangler forelder");
	if (p != null)
	    throw new IllegalArgumentException("Posisjon " + posisjon + " finnes allerede");

	p = new Node<>(verdi);

	if (q == null)
	    rot = p;
	else if ((posisjon & 1) == 0)
	    q.venstre = p;
	else
	    q.høyre = p;

	antall++;

    }// leggInn()

    private Node<T> finnNode(int posisjon) // finner noden med gitt posisjon
    {
	if (posisjon < 1)
	    return null;

	Node<T> p = rot; // hjelpepeker
	int filter = Integer.highestOneBit(posisjon >> 1); // filter = 100...00

	for (; p != null && filter > 0; filter >>= 1)
	    p = (posisjon & filter) == 0 ? p.venstre : p.høyre;

	return p; // p blir null hvis posisjon ikke er i treet
    }

    // finnes posisjon fra før?
    public boolean finnes(int posisjon) {
	return finnNode(posisjon) != null;
    }

    // verdien i noden med gitt posisjon
    public T hent(int posisjon) {
	Node<T> node = finnNode(posisjon);
	if (node == null)
	    throw new IllegalArgumentException("Posisjon " + posisjon + " finnes ikke.");

	return node.verdi;
    }

    // ny verdi i noden med gitt posisjon
    public T oppdater(int posisjon, T verdi) {
	Node<T> node = finnNode(posisjon);
	if (node == null)
	    throw new IllegalArgumentException("Posisjon " + posisjon + " finnes ikke.");

	T gammelVerdi = node.verdi;
	node.verdi = verdi;
	return gammelVerdi;

    }

    // fjerner noden med gitt posisjon
    public T fjern(int posisjon) {

	return null;
    }

    // avgjør om verdi er i treet
    public boolean inneholder(T verdi) {
	return false;
    }

    // posisjonen til verdi
    public int posisjon(T verdi) {
	return -1;
    }

    public int antall() {
	return this.antall;
    }

    public boolean tomtTre() {
	return this.antall == 0;
    }

    public void sumVenstre() {
	Node<T> p = finnNode(1);
	if (p == null)
	    return;

	while (p.venstre != null) {
	    System.out.println(p.verdi.toString());
	    p = p.venstre;
	}
	System.out.println(p.verdi.toString());

    }

    // PASCAL TREKANT 
    public String toString() {
	String s = "";
	int høyde = 1, teller = 0;
	for (int i = 1; i <= antall; i++) {
	    if (++teller == høyde) {
		teller = 0;
		høyde++;
	    }
	}
	int nivå = 1;
	teller = 0;
	for (int i = 1; i <= antall; i++) {
	    if (teller == 0)
		for (int j = nivå; j < høyde; j++)
		    s += " ";
	    s += finnNode(i).verdi.toString().length() > 1 ? "" : "0";
	    s += finnNode(i).verdi + " ";

	    if (++teller == nivå) {
		teller = 0;
		nivå++;
		s = s + "\n";
	    }
	}

	return s;
    }
}
