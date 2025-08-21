package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/* Modulo de conexão */
	/** The driver. */
	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "csgodorgas";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Metodo de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void atz(String tipo) {
	    String storedProcedureCall = "{call atualizar(?)}";
	    try {
	        // abrir conexão
	        Connection con = conectar();
	        
	        // preparar chamada da stored procedure
	        CallableStatement cs = con.prepareCall(storedProcedureCall);
	        cs.setString(1, tipo);
	        
	        // Executando a stored procedure
	        cs.executeUpdate();
	        
	        // ENCERRANDO CONEXAO COM O BANCO
	        con.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

	public void inserirContato(JavaBeans contato) {
		String create = "insert into trabalho (tipo,materia,descricao,data)values(?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getTipo());
			pst.setString(2, contato.getMat());
			pst.setString(3, contato.getDesc());
			pst.setDate(4, contato.getData());
			// Executando query
			pst.executeUpdate();
			// ENCERRANDO CONEXAO COM O BANCO
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from trabalho order by data ASC";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// Laço executa enqt houver cntt
			while (rs.next()) {

				String idcon = rs.getString(1);
				String tipo = rs.getString(2);
				String mat = rs.getString(3);
				String desc = rs.getString(4);
				Date data=rs.getDate(5);
				
				contatos.add(new JavaBeans(idcon, tipo, mat, desc,data));

			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public ArrayList<JavaBeans> listarMateria(String materiaId) {
	    ArrayList<JavaBeans> contatos = new ArrayList<>();
	    String tableName = ""; // defina aqui o nome da tabela baseado no materiaId
	  
	    switch (materiaId) {
	        case "1":
	            tableName = "algoritmos_e_programacao";
	            break;
	        case "2":
	            tableName = "estruturas_de_dados";
	            break;
	        case "3":
	            tableName = "banco_de_dados";
	            break;
	        case "4":
	            tableName = "engenharia_de_software";
	            break;
	        case "5":
	            tableName = "redes_de_computadores";
	            break;
	        case "6":
	            tableName = "sistemas_operacionais";
	            break;
	        case "7":
	            tableName = "inteligencia_artificial";
	            break;
	        case "8":
	            tableName = "desenvolvimento_web";
	            break;
	        case "9":
	            tableName = "seguranca_da_informacao";
	            break;
	        case "10":
	            tableName = "analise_de_sistemas";
	            break;
	        default:
	            tableName = "trabalho"; // Tabela padrão se não houver correspondência
	    }

	    String read = "SELECT * FROM " + tableName + " ORDER BY data ASC";

	    try {
	        Connection con = conectar();
	        PreparedStatement pst = con.prepareStatement(read);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            String idcon = "";
	            String tipo = rs.getString(2);
	            String mat = tableName;
	            String desc = rs.getString(3);
	            Date data = rs.getDate(4);
	            contatos.add(new JavaBeans(idcon, tipo, mat, desc, data));
	        }
	        con.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return contatos;
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from trabalho where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setTipo(rs.getString(2));
				contato.setMat(rs.getString(3));
				contato.setDesc(rs.getString(4));
				contato.setData(rs.getDate(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	// Editar contato
	public void alterarContato(JavaBeans contato) {
		String create = "update trabalho set tipo=?,materia=?,descricao=?,data=?where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getTipo());
			pst.setString(2, contato.getMat());
			pst.setString(3, contato.getDesc());
			pst.setDate(4, contato.getData());
			pst.setString(5, contato.getIdcon());
			
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {
		String delete="delete from trabalho where idcon=?";
		try {
			Connection con=conectar();
			PreparedStatement pst=con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
