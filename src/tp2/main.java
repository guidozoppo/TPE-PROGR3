package tp2;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree arbol = new Tree(5);
		arbol.insert(4);
		arbol.insert(1);
		arbol.insert(8);
		arbol.insert(2);
		arbol.insert(9);
		arbol.insert(7);
		/*
		 * 				 5
		 * 			4			8
		 * 		1			7		9
		 * 			2
		 */
		//arbol.printInorder(arbol);
		
		//System.out.println(arbol.delete(5, arbol, null));
		//arbol.printInorder(arbol);
		
		//System.out.println("");
		//System.out.println(arbol.getNMI(arbol));
		
		System.out.println(arbol.getHeight());
		
		/*Tree arbol2 = new Tree(8);
		arbol2.insert(7);
		arbol2.insert(9);*/
		//System.out.println(arbol.getPadre(arbol, 2, null));
	}

}
