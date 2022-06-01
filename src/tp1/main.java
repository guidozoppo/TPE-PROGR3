package tp1;

import java.util.Iterator;

public class main {

	public static <T> void main(String[] args) {
		MySimpleLinkedList lista1 = new MySimpleLinkedList();
		MySimpleLinkedList lista2 = new MySimpleLinkedList();
		
		lista1.insertFront(6);
		lista1.insertFront(2);
		lista1.insertFront(9);
		lista1.insertFront(4);
		lista1.insertFront(5);
		
		lista2.insertFront(1);
		lista2.insertFront(5);
		lista2.insertFront(4);
		lista2.insertFront(9);
		lista2.insertFront(8);

		
		Iterator<Integer> iterator = lista1.iterator();
		
		//System.out.println(lista1.buscarComun(lista1, lista2));
		//System.out.println(lista1.primeraSiSegundaNo(lista2, lista1));
		
		MyDoubleLinkedList listaDoble = new MyDoubleLinkedList();
		listaDoble.insertFront(0);
		listaDoble.insertFront(1);
		listaDoble.insertFront(2);
		
		Iterator<Integer> iteratorDoble = listaDoble.iterator();
		//System.out.println(listaDoble.size());
		
		/*while (iteratorDoble.hasNext()) {
			System.out.println(iteratorDoble.next());
		}*/
		
		String cadena = new String("anana");
		
		int i, j;
		boolean s = true;
		//while(s) {
			for (i=0; i < cadena.length()/2; i++) {
				//System.out.println("i " + cadena.charAt(i));
				for (j = cadena.length()-1; j > cadena.length()/2; j--) {
					
					//System.out.println("j " + cadena.charAt(j));
					if(cadena.charAt(i) == cadena.charAt(j)) {
						System.out.println(cadena.charAt(i) + " - " + cadena.charAt(j) + " son iguales");
					}
					i++;
				}
			}
			
		//	s = false;
		//}
		
		
		
		
		
		
	}

}
