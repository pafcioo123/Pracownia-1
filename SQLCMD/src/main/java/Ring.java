import java.util.Date;

public class Ring {
    private Godzina[] godziny;
    Ring(){
        godziny = new Godzina[12];
        godziny[0]= new Godzina(8,15);
        godziny[1]= new Godzina(9,45);
        godziny[2]= new Godzina(10,0);
        godziny[3]= new Godzina(11,30);
        godziny[4]= new Godzina(11,45);
        godziny[5]= new Godzina(13,15);
        godziny[6]= new Godzina(13,45);
        godziny[7]= new Godzina(15,15);
        godziny[8]= new Godzina(15,30);
        godziny[9]= new Godzina(17,0);
        godziny[10]= new Godzina(17,15);
        godziny[11]= new Godzina(18,45);
    }
    public void showTimeLeft(){
        Date current= new Date();
        int i=0;
        while((((current.getHours()*60)+current.getMinutes())>=((godziny[i].h*60)+godziny[i].m))&& i<12){
            i++;
        }
        if(i==12){
            System.out.println("Na dzisiaj koniec");
        }
        else{
            String komunikat= " minut do konca ";
            int t=((godziny[i].h*60)+godziny[i].m)-((current.getHours()*60)+current.getMinutes());
            if((i % 2)==0){
                System.out.println(t + komunikat + "przerwy");
            }
            else{
                System.out.println(t + komunikat + "zajec");
            }
        }
    }
    public void showTimeLeftBtw(){
        Date current= new Date();
        if ((((current.getHours()*60)+current.getMinutes())>=495) && (((current.getHours()*60)+current.getMinutes())<= 1125 ) ){
            this.showTimeLeft();
        }
    }
}
class Godzina{
    public int h;
    public int m;
    Godzina(int h,int m){
        this.h=h;
        this.m=m;
    }
}
