package adrian.gavilan.dam.mp09.uf03.a01.domain;

import java.io.Serializable;

public class Llibre implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2780280109781283841L;

	public Llibre() {

	}

	public Llibre(String title, String autor) {
		super();
		this.title = title;
		this.autor = autor;
	}

	private String title;
	private String autor;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Llibre [title=" + title + ", autor=" + autor + "]";
	}

	
}
