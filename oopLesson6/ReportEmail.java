public class ReportEmail implements Report{
    public void report(User user) {
        System.out.println("Send email report for user " + user.getName());
    }
}
