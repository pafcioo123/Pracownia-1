import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.lang.Thread;
public class saveQuerry implements org.quartz.Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        SQLCMD.sqlparser.save("odp.txt");
    }
}
