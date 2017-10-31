import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ringTimer implements org.quartz.Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SQLCMD.ring.showTimeLeftBtw();
    }
}
