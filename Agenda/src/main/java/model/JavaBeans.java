package model;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {

	/** The idcon. */
	private String idcon;
	
	/** The nome. */
	private String tipo;
	
	/** The fone. */
	private String materia;
	
	/** The email. */
	private String descricao;

	private Date data;
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
		
	}

	
	
	public JavaBeans(String idcon, String tipo, String materia, String descricao, Date data) {
		super();
		this.idcon = idcon;
		this.tipo = tipo;
		this.materia = materia;
		this.descricao = descricao;
		this.data=data;
	}


	
	public String getIdcon() {
		return idcon;
	}

	
	public void setIdcon(String idcon) {
		this.idcon = idcon;
		}
	public String getTipo() {
		return tipo;
	}

	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public String getMat() {
		return materia;
	}

	
	public void setMat(String mat) {
		this.materia = mat;
	}

	
	public String getDesc() {
		return descricao;
	}

	
	public void setDesc(String desc) {
		this.descricao = desc;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}
	
}
