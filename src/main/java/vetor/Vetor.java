package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = 0;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(Object o) {
		if (indice >= tamanho)
			throw new IllegalArgumentException("ARRAY CHEIO");
		arrayInterno[indice] = o;
		indice++;
	}

	// Remove um objeto do vetor
	public void remover(Object o) {
		int ind = -1;
		int i= 0;
		while (i < tamanho && ind == -1) {
			if (arrayInterno[i] != null && arrayInterno[i] == o)
				ind = i;
			i++;
		}
		if (ind == -1)
			throw new IllegalArgumentException("OBJECT INVÁLIDO");
		for (int j = ind; j < indice-1; j++) {
			Object temp = arrayInterno[j];
			arrayInterno[j] = arrayInterno[j+1];
			arrayInterno[j+1] = temp;
		}
		arrayInterno[indice] = null;
		indice--;
	}

	// Procura um elemento no vetor
	public Object procurar(Object o) {
		Object obj = null;
		int i = 0;
		while (obj ==  null && i < tamanho) {
			if (arrayInterno[i] == o)
				obj = o;
			i++;
		}
		return obj;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		boolean isNull = true;
		int i = 0;
		while (isNull == true && i < tamanho) {
			if (arrayInterno[i] != null)
				isNull = false;
			i++;
		}
		return isNull;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		boolean taChei = false;
		if (indice == tamanho)
			taChei = true;
		return taChei;
	}

}
