import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.String;
import java.io.BufferedReader;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;



import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;
public class SQLCMD {

    public static SqlParser sqlparser= new SqlParser();
    public static Ring ring = new Ring();
    public static void main(String [ ] args) throws IOException {
        sqlparser.setLenght(20);
        Scheduler scheduler = null;
        try {
            // Grab the Scheduler instance from the Factory
            scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(saveQuerry.class)
                    .withIdentity("job1", "group1")
                    .build();
            JobDetail job2=newJob(ringTimer.class)
                    .withIdentity("job2", "group2")
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            CronTrigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(cronSchedule("0,30 * * ? * * *"))
                    .build();
            CronTrigger trigger2 = newTrigger()
                    .withIdentity("trigger2", "group2")
                    .withSchedule(cronSchedule("0 * 8-19 ? * MON,TUE,WED,THU,FRI *"))
                    .build();


            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
            scheduler.scheduleJob(job2, trigger2);

            // and start it off
            scheduler.start();


        } catch (SchedulerException se) {
            se.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exitStr ="exit";
        int n= 0;
        do{
            String input=null;
            while(true){
                input = br.readLine();
                if(input.equals(exitStr)) break;
                try{
                    n=Integer.parseInt(input);
                    break;
                }catch(NumberFormatException ne){
                    System.out.println("Podana wartosc nie jest liczba");
                }
            }
            if(input.equals(exitStr)) break;
            input=br.readLine();
            if(input.equals(exitStr)) break;
            sqlparser.inQuerry(input, n);
        }while(true);

        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }

}