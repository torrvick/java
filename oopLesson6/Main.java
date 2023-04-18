public class Main{
	public static void main(String[] args){
		User user = new User("Bob");

		Persister PersisterDB = new PerstisterDB();
		Persister persisterFile = new PersisterFile();
		persisterFile.save(user);
		PersisterDB.save(user);

		Report reportEmail = new ReportEmail();
		Report reportPrinter = new ReportPrinter();
		reportEmail.report(user);
		reportPrinter.report(user);
	}
}