package tad.hash;

public class TabelaEndAberto<T> implements TabelaHash<T> {
	
	private T[] elementos;
	
	public TabelaEndAberto(int n) {
		elementos = (T[]) new Object[n];
	}

	@Override
	public void add(T elemento) {
		
		
	}

	@Override
	public void remove(T elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean procurar(T elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
