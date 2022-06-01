package tp2;

import java.util.ArrayList;

/*
List getLongestBranch(), 
List getFrontera(),  
List getElemAtLevel(int)
 
 */
public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;
	private int altura;

	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Integer getRoot() {
		return value;
	}
	
	public void setValue(Integer v) {
		value = v;
	}
	
	public void setLeft(Tree l) {
		left = l;
	}
	
	public void setRight(Tree r) {
		right = r;
	}
	
	public Tree getLeft() {
		return left;
	}
	
	public Tree getRight() {
		return right;
	}
	
	public boolean hasElem(Integer v) {
		return this.hasElemRecursive(this, v);
	}
	
	private boolean hasElemRecursive(Tree a, Integer v) {
		if (a.getRoot() == null) {
			return false;
		}
		if (a.getRoot() == v) {
			return true;
		}
		if (a.getRoot() < v) {
			if(a.right != null) 
				return hasElemRecursive(a.right, v);
			else
				return false;
		}
		if(a.getRoot() > v) {
			if(a.left != null) 
				return hasElemRecursive(a.left, v);
			else
				return false;
		}
		return false;
	}

	public Tree getPadre(Tree a, Integer v, Tree padre) { //arbol general a buscar y valor a buscar
		if(a.hasElem(v)) {
			//Tree padre = new Tree(null);
			if(a.getRoot() == v) {
				return padre;
			}
			if(a.getRoot() > v) {
				if(a.getLeft() != null) {
					
					return getPadre(a.getLeft(), v, a);
				}
			}
			if(a.getRoot() < v) {
				return getPadre(a.getRight(), v, a);
			}
		}
		return null;
	}
	
	public void insert(Integer newValue) {
		if (this.value == null)
			this.value = newValue;
		else {
			if (this.value > newValue) {
				if (this.left == null)
					this.left = new Tree(newValue);
				else
					this.left.insert(newValue);
			} else if (this.value < newValue) {
				if (this.right == null)
					this.right = new Tree(newValue);
				else
					this.right.insert(newValue);
			}
		}
	}
	
	public void printPreorder(Tree node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	public void printPostorder(Tree node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.value + " ");
	} 
	
	public void printInorder(Tree node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.value + " ");
		printInorder(node.right);
	} 

	public boolean isEmpty() {
		if (this.getRoot() != null) {
			return false;
		}
		return true;
	}

	
	@Override
	public String toString() {
		return value + "";
	}

	public boolean delete(Integer v, Tree a, Tree padre) {
		if (a.hasElem(v)) { //si existe v en a
			if(a.getRoot() == v) { //cuando encuentra el valor a eliminar:
				
				if(a.getLeft() == null && a.getRight() == null) { //CASO 1: si es una hoja
					if(padre.getLeft() == null) {
						padre.setRight(null);
					} else {
						padre.setLeft(null);
					}
					return true;
				}
				else if ( (a.getLeft() == null && a.getRight() != null) || 
													(a.getLeft() != null && a.getRight() == null)) { //CASO 2: si el nodo tiene solo un hijo
					Tree p = a.getPadre(this, v, a);
					if(p.getRoot() < v) { //Si v es mayor, cuando elimino v le cambio el right al padre
						if(a.getLeft() == null) {
							p.setRight(a.getRight());
						} else {
							p.setRight(a.getLeft());
						}
					} else { //Si v es menor, cuando elimino v le cambio el left al padre
						if(a.getLeft() == null) {
							p.setLeft(a.getRight());
						} else {
							p.setLeft(a.getLeft());
						}
					}
				}
				else if (a.getLeft() != null && a.getRight() != null) { //CASO 3: si el nodo tiene los dos hijos
					int value = a.getNMI(a.getRight());
					a.delete(7, a, null);
					a.setValue(value);
				}
			return true;
			}
			else if (a.getRoot() < v) {
				return delete(v, a.getRight(), a.getPadre(this, v, a));
			}
			else if (a.getRoot() > v) {
				return delete(v, a.getLeft(), a.getPadre(this, v, a));
			}
		} else {
			return false;
		}
		return false;
	}
	
	private int getNMI(Tree arbol) {
		int valorMinimo = arbol.getLeft().getRoot();
		return valorMinimo;
	}

	public int getHeight() {
		altura = 0;
		return retornarAltura(this, 1);
	}
	
	private int retornarAltura(Tree r, int nivel) {
		if(r != null) {
			retornarAltura(r.getLeft(), nivel+1);
			if(nivel > altura) {
				altura = nivel;
			}
			retornarAltura(r.getRight(), nivel+1);
		}
		return altura;
	}
	
	public int getMaxElem() {
		Integer max = this.getRoot();
		Tree arbol = this;
		while(arbol.tieneRight(arbol)) {
			max = arbol.getRight().getRoot();
			arbol = arbol.getRight();
		}
		return max;
	}

	private boolean tieneRight(Tree arbol) {
		return arbol.getRight() != null;
	}

	public ArrayList<Integer> getElementsAtLevel(int level){
		ArrayList<Integer> elements = new ArrayList<>();
		int lvl = 0;
		
		return elements;
	}

}
