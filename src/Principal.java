

public class Principal {

	public static void main(String[] args) throws Exception {
		Autenticador a = new Autenticador();
		String nome = a.autenticar("joao", "123");
		System.out.println(nome);
	}

}
