
package mua;

public class Timeout extends Thread{

    double acc, t;
    public Timeout(double acc, double t) {
        this.acc = acc;
        this.t = t;
    }
    
    @Override
    public void run(){
        try{
            if(acc <= t){
                Thread.sleep(100);
                Ventana.hacerfuncion();
            }else{
                Ventana.ocultar();
            }
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
    
}
