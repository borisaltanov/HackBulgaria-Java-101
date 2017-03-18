package mysqlhelp;

public class MainTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client kamen = new Client("Kamen", 22);
		
		MySQLHelper db = new MySQLHelper("//localhost", "root", "bla");
		db.insertInto("Clients", kamen);
		db.deleteFrom("Client", kamen.id);
		db.update("Client", kamen);
		db.selectFrom("Clients", "");
	}

}
