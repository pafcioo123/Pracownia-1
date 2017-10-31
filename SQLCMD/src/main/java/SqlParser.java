import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.String;
import java.io.IOException;
import java.io.InputStreamReader;

public final class SqlParser {
    private String[] sqlQ=new String[20];
    private int qLong =20;

    public void setLenght(int n){
        sqlQ = new String[n];
        for(int i=0;i<n;i++){
            sqlQ[i]="";
        }
        qLong=n;
    }

    public void save(String filename){
        PrintWriter out = null;
        try {
            out = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String nullString = "";
        for (int i=0;i<qLong;i++){
            if (!nullString.equals(sqlQ[i])){
                out.println((i+1)+" "+sqlQ[i]);
                //System.out.println((i+1)+" "+sqlQ[i]);
            }
        }
        out.close();
    }
    public int inQuerry(String Q,int p){
        if (p>this.qLong) {
            System.out.println("Podano zla pozycje");
            return 1;
        }
        boolean Qstate = true;
        if (Q.matches(".*[Ss][Ee][Ll][Ee][Cc][Tt].*")){
            if (Q.matches(".*[Ff][Rr][Oo][Mm].*")){
                if(Q.matches(".*[Ww][Hh][Ee][Rr][Ee].*")){
                    if(Q.matches(".*[Oo][Rr][Dd][Ee][Rr]\\s\\s*[Bb][Yy].*")){
                        if(Q.matches("\\s*[Ss][Ee][Ll][Ee][Cc][Tt]\\s.*\\s[Ff][Rr][Oo][Mm]\\s.*\\s[Ww][Hh][Ee][Rr][Ee]\\s.*\\s[Oo][Rr][Dd][Ee][Rr]\\s\\s*[Bb][Yy]\\s.*\\s*")){
                            System.out.println("ORDER BY- ok: "+Q);
                        }
                        else{
                            System.out.println("bład zapytania");
                            Qstate = false;
                        }
                    }
                    else{
                        if(Q.matches("\\s*[Ss][Ee][Ll][Ee][Cc][Tt]\\s.*\\s[Ff][Rr][Oo][Mm]\\s.*\\s[Ww][Hh][Ee][Rr][Ee]\\s.*")){
                            System.out.println("where- ok: "+Q);
                        }
                        else{
                            System.out.println("bład zapytania");
                            Qstate = false;
                        }
                    }
                }
                else{
                    if(Q.matches("\\s*[Ss][Ee][Ll][Ee][Cc][Tt]\\s.*\\s[Ff][Rr][Oo][Mm]\\s.*")){
                        System.out.println("From- ok: "+Q);
                    }
                    else{
                        System.out.println("bład zapytania");
                        Qstate = false;
                    }
                }
            }
            else {
                if(Q.matches("\\s*[Ss][Ee][Ll][Ee][Cc][Tt]\\s.*")){
                    System.out.println("Select- ok: "+Q);
                }
                else{
                    System.out.println("bład zapytania");
                    Qstate = false;
                }
            }
        }
        else{
            System.out.println("Brak SELECT");
            Qstate = false;
        }
        if (Qstate){
            sqlQ[p-1]=Q;
        }
        //System.out.println(Q.matches("\\s*[Ss][Ee][Ll][Ee][Cc][Tt]\\s+.*\\s+[Ff][Rr][Oo][Mm]\\s+.*\\s+[Ww][Hh][Ee][Rr][Ee]\\s+.*\\s+[Oo][Rr][Dd][Ee][Rr]\\s+[Bb][Yy]\\s+.*"));
        return 0;
    }

//    sqlParser(){
//        sqlQ=new String[20];
//        qLong=20;
//    }


}
