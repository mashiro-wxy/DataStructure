package sparse_matrix;

public class test {

	public static void main(String[] args) {
		Triple[] elemsa = {new Triple(0,2,11),new Triple(0,4,17),new Triple(1,1,20),new Triple(3,0,19),
				new Triple(3,2,36),new Triple(3,5,28),new Triple(4,2,50)};
		SeqMatrix mata = new SeqMatrix(6,6,elemsa);
		
		System.out.println("三元组\n" + mata.toString());
		mata.printMatrix();
		//System.out.println("转置后三元组\n" + mata.toString());
		System.out.println("转置后矩阵\n");
		SeqMatrix mata2 = new SeqMatrix(6,6,7);
		mata2 = mata.FastTranspose(mata, mata2);
		mata2.printMatrix();
	}

}
