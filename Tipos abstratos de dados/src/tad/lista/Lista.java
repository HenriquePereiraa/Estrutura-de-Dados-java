package tad.lista;

public interface Lista<Tipo> {
	
	public void inserir(Tipo novo);
	public boolean remover(Tipo elemento);
	public Tipo consultar(int index);
	public void print();
	public int indexOf(Tipo elemento);

}
