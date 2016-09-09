import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.logging.Level;
//
//import com.sun.istack.internal.logging.Logger;

public class Autenticador {
	//private static String CFN = "org.postgresql.Driver";
//	private static String URL = "jdbc:postgresql://localhost/usuarios";
//	private static String USR = "gressler";
//	private static String PWD = "4d$kaj981A,,%uSDf-9sdfa.!23";
	
	static{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String autenticar(String login, String senha) throws Exception{
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/usuarios","gressler","4d$kaj981A,,%uSDf-9sdfa.!23")){
			PreparedStatement ps = c.prepareStatement("SELECT nome FROM usuario WHERE login = ? and senha = ?");
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("nome");
			}else{
				throw new Exception("Não foi possível autenticar o usuário");
			}
		}
		
	}
}















