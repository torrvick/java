public class ReportPrinter implements Report{
    public void report(User user) {
        System.out.println("Print report for user " + user.getName());
    }
}
