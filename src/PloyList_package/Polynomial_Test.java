package PloyList_package;

public class Polynomial_Test {

	public static void main(String[] args) {
		TermX atermx[] = {new TermX(-7,9), new TermX(2,7), new TermX(-9,4),
				new TermX(1,2), new TermX(-1,1), new TermX(2,0),};
		Polynomial apoly = new Polynomial(atermx);
		System.out.println("A=" + apoly.toString());
		Polynomial bpoly = new Polynomial("-1+x-x^2+10x^4-3x^8+5x^10+9x^11");
		System.out.println("B=" + bpoly.toString());
		Polynomial cpoly = apoly.union(bpoly);
		System.out.println("A+B=" + cpoly.toString());
	}
}
