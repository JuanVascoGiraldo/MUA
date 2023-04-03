
package mua;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Expression;
import static java.lang.Double.parseDouble;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.math.plot.Plot2DPanel;

public class Ventana extends JFrame{
    
    
    private static double ve1, ve2, t, a, xi, xf, tun=0.0;
    private static JPanel panel1, panel2, panel4;
    static Grafica panel3;
    private JTextField v1, v2, tiemp, acel, posi, posf;
    private JButton botn1 = new JButton();
    private JButton botn2 = new JButton();
    private JButton botn3 = new JButton();
    private JButton botn4 = new JButton();
    private JButton botn5 = new JButton();
    
    public Ventana(){
        this.setSize(1000,600);
        this.setTitle("Movimiento Uniforme Acelerado");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        iniciarcomponentes();
    }

    private void iniciarcomponentes() {
        Paneles();
        Etiquetas();
        Textfield();
        Botones();
        Listeners();
        ve1 = -10000000;
        ve2 =-10000000;
        a = -10000000;
        xi=-10000000;
        xf=-10000000;
        t=-10000000;
    }
    
    private void Paneles(){
        panel1= new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(2, 48, 71));
        panel1.setBounds(0, 0, 1000, 600);
        panel1.setVisible(true);
        this.getContentPane().add(panel1);
        
        panel2= new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(2, 48, 71));
        panel2.setBounds(0, 0, 400, 600);
        panel2.setVisible(false);
        this.getContentPane().add(panel2);
        
        
    }
    
    private void Etiquetas(){
        JLabel titulo = new JLabel("Programa que describe el MUA",  SwingConstants.CENTER);
        titulo.setBounds(0, 20, 1000, 35);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        panel1.add(titulo);
        
        //v inicial, v final, tiempo final, posicion inicial, posicion final, aceleracion
        
        JLabel label1 = new JLabel("Velocidad inicial (m/s)",  SwingConstants.CENTER);
        label1.setBounds(0, 60, 1000, 40);
        label1.setFont(new Font("Arial", Font.BOLD, 22));
        label1.setForeground(Color.white);
        panel1.add(label1);
        
        JLabel label2 = new JLabel("Velocidad Final (m/s)",  SwingConstants.CENTER);
        label2.setBounds(0, 130, 1000, 40);
        label2.setFont(new Font("Arial", Font.BOLD, 22));
        label2.setForeground(Color.white);
        panel1.add(label2);
        
        JLabel label3 = new JLabel("Posicion inicial (m)",  SwingConstants.CENTER);
        label3.setBounds(0, 200, 1000, 40);
        label3.setFont(new Font("Arial",Font.BOLD, 22));
        label3.setForeground(Color.white);
        panel1.add(label3);
        
        JLabel label4 = new JLabel("Posicion Final (m)",  SwingConstants.CENTER);
        label4.setBounds(0, 270, 1000, 40);
        label4.setFont(new Font("Arial", Font.BOLD, 22));
        label4.setForeground(Color.white);
        panel1.add(label4);
        
        JLabel label5 = new JLabel("Aceleracion (m/s^2)",  SwingConstants.CENTER);
        label5.setBounds(0, 340, 1000, 40);
        label5.setFont(new Font("Arial", Font.BOLD, 22));
        label5.setForeground(Color.white);
        panel1.add(label5);
        
        JLabel label6 = new JLabel("Tiempo (s)",  SwingConstants.CENTER);
        label6.setBounds(0, 410, 1000, 40);
        label6.setFont(new Font("Arial", Font.BOLD, 22));
        label6.setForeground(Color.white);
        panel1.add(label6);
        
        //Segundo panel
        
        JLabel label7 = new JLabel("Datos del Moviento",  SwingConstants.CENTER);
        label7.setBounds(0, 10, 400, 30);
        label7.setFont(new Font("Arial", Font.BOLD, 22));
        label7.setForeground(Color.white);
        panel2.add(label7);
        
        JLabel label12 = new JLabel("Velocidad inicial (m/s)",  SwingConstants.CENTER);
        label12.setBounds(0, 60, 400, 40);
        label12.setFont(new Font("Arial", Font.BOLD, 18));
        label12.setForeground(Color.white);
        panel2.add(label12);
        
        JLabel label22 = new JLabel("Velocidad Final (m/s)",  SwingConstants.CENTER);
        label22.setBounds(0, 130, 400, 40);
        label22.setFont(new Font("Arial", Font.BOLD, 18));
        label22.setForeground(Color.white);
        panel2.add(label22);
        
        JLabel label32 = new JLabel("Posicion inicial (m)",  SwingConstants.CENTER);
        label32.setBounds(0, 200, 400, 40);
        label32.setFont(new Font("Arial",Font.BOLD, 18));
        label32.setForeground(Color.white);
        panel2.add(label32);
        
        JLabel label42 = new JLabel("Posicion Final (m)",  SwingConstants.CENTER);
        label42.setBounds(0, 270, 400, 40);
        label42.setFont(new Font("Arial", Font.BOLD, 18));
        label42.setForeground(Color.white);
        panel2.add(label42);
        
        JLabel label52 = new JLabel("Aceleracion (m/s^2)",  SwingConstants.CENTER);
        label52.setBounds(0, 340, 400, 40);
        label52.setFont(new Font("Arial", Font.BOLD, 18));
        label52.setForeground(Color.white);
        panel2.add(label52);
        
        JLabel label62 = new JLabel("Tiempo (s)",  SwingConstants.CENTER);
        label62.setBounds(0, 410, 400, 40);
        label62.setFont(new Font("Arial", Font.BOLD, 18));
        label62.setForeground(Color.white);
        panel2.add(label62);
        
    }
    
    private void Textfield(){
        v1= new JTextField();
        v1.setBounds(400, 100, 200, 20);
        panel1.add(v1);
    
        v2= new JTextField();
        v2.setBounds(400, 170, 200, 20);
        panel1.add(v2);
        
        posi = new JTextField();
        posi.setBounds(400, 240, 200, 20);
        panel1.add(posi);
        
        posf =new JTextField();
        posf.setBounds(400, 310, 200, 20);
        panel1.add(posf);
        
        acel = new JTextField();
        acel.setBounds(400, 380, 200, 20);
        panel1.add(acel);
        
        tiemp =new JTextField();
        tiemp.setBounds(400, 450, 200, 20);
        panel1.add(tiemp);
    }
    
    private void Botones(){
        ImageIcon img1= new ImageIcon("button_calcular.png");
        botn1.setBounds(435, 490, 130, 44);
        botn1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(botn1.getWidth(), botn1.getHeight(), Image.SCALE_SMOOTH)));
        botn1.setBackground(new Color(5, 137, 158));
        botn1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel1.add(botn1);
        
        ImageIcon img2= new ImageIcon("button_movimiento.png");
        botn2.setBounds(91, 490, 122, 33);
        botn2.setIcon(new ImageIcon(img2.getImage().getScaledInstance(botn2.getWidth(), botn2.getHeight(), Image.SCALE_SMOOTH)));
        botn2.setBackground(new Color(5, 137, 158));
        botn2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel2.add(botn2);
        
        ImageIcon img3= new ImageIcon("button_a-t.png");
        botn3.setBounds(280, 490, 62, 33);
        botn3.setIcon(new ImageIcon(img3.getImage().getScaledInstance(botn3.getWidth(), botn3.getHeight(), Image.SCALE_SMOOTH)));
        botn3.setBackground(new Color(5, 137, 158));
        botn3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel2.add(botn3);
        
        ImageIcon img4= new ImageIcon("button_v-t.png");
        botn4.setBounds(120, 530, 62, 33);
        botn4.setIcon(new ImageIcon(img4.getImage().getScaledInstance(botn4.getWidth(), botn4.getHeight(), Image.SCALE_SMOOTH)));
        botn4.setBackground(new Color(5, 137, 158));
        botn4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel2.add(botn4);
        
        ImageIcon img5= new ImageIcon("button_x-t.png");
        botn5.setBounds(280, 530, 62, 33);
        botn5.setIcon(new ImageIcon(img5.getImage().getScaledInstance(botn5.getWidth(), botn5.getHeight(), Image.SCALE_SMOOTH)));
        botn5.setBackground(new Color(5, 137, 158));
        botn5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel2.add(botn5);
    }
    
    private void Listeners(){
        MouseListener oyentederaton= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==botn1){
                    Calcular();
                }
                if(e.getSource()==botn2){
                    panel3.setVisible(true);
                    tun =0.0;
                    hacerfuncion();
                }
                if(e.getSource()==botn3){
                    graficarFuncion(3, "Aceleracion - Tiempo");
                }
                if(e.getSource()==botn4){
                    graficarFuncion(2, "Velocidad - Tiempo");
                }
                if(e.getSource()==botn5){
                    graficarFuncion(1, "Posicion - Tiempo");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        
         KeyListener oyentedeteclado= new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getSource()==v1 || e.getSource()==v2||e.getSource()==acel
                        ||e.getSource()==posi||e.getSource()==posf){
                    char c = e.getKeyChar();
                    if( (c<'0'|| c>'9')&& c!='-'&& c!='.')e.consume();
                }
                if(e.getSource()==tiemp){
                    char c = e.getKeyChar();
                    if( (c<'0'|| c>'9')&& c!='.' )e.consume();
                }
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        };
        
        botn1.addMouseListener(oyentederaton);
        botn2.addMouseListener(oyentederaton);
        botn3.addMouseListener(oyentederaton);
        botn4.addMouseListener(oyentederaton);
        botn5.addMouseListener(oyentederaton);
        v1.addKeyListener(oyentedeteclado);
        v2.addKeyListener(oyentedeteclado);
        tiemp.addKeyListener(oyentedeteclado);
        posi.addKeyListener(oyentedeteclado);
        posf.addKeyListener(oyentedeteclado);
        acel.addKeyListener(oyentedeteclado);
    }
    
    private void Calcular(){
        try{
            String vel1, vel2, acelt, tiemt, posin, pofin;
            vel1= v1.getText();
            vel2 = v2.getText();
            acelt = acel.getText();
            tiemt = tiemp.getText();
            posin = posi.getText();
            pofin = posf.getText();
            
            if(!vel1.equals("")){
                ve1 = parseDouble(vel1);
            }
            if(!vel2.equals("")){
                ve2 = parseDouble(vel2);
            }
            if(!tiemt.equals("")){
                t = parseDouble(tiemt);
            }
            if(!acelt.equals("")){
                a = parseDouble(acelt);
            }
            if(!posin.equals("")){
               xi = parseDouble(posin);
            }
            if(!pofin.equals("")){
               xf = parseDouble(pofin);
            }
            int i =0, bandera=0;
            
            if(a>0&& ve1>0 &&xf<xi){
                JOptionPane.showMessageDialog(null,"Nunca se podra llegar a la posicion final debido a que "
                        + "tenemos una velocidad y aceleracion positiva, y teniendo una posicion inicial "
                        + "mayor a la final, la distancia solo aumentara"
            , "Error",  JOptionPane.WARNING_MESSAGE);
            }else{
                while(i<7){

                    if(!CalcularT()){
                        bandera=0;
                    }else{ bandera=1;}
                    if(!Calculara()){
                        bandera=0;
                    }else{bandera=1;}
                    if(!Calcularv1()){
                        bandera=0;
                    }else{ bandera=1;}
                    if(!Calcularv2()){
                        bandera=0;
                    }else{bandera=1;}
                    if(!Calcularxi()){
                        bandera=0;
                    }else{bandera=1;}
                    if(!Calcularxf()){
                        bandera=0;
                    }else{bandera=1;}
                    i++;
                }

                if(bandera !=0){
                    MostralPanel2();

                }else{
                    JOptionPane.showMessageDialog(null,"Ingresa mas datos para poder realizar seguir con el programa"
                , "Error",  JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Se ha introducido un valor no Permitido"
            , "Error",  JOptionPane.ERROR_MESSAGE);
            ve1 = -10000000;
            ve2 =-10000000;
            a = -10000000;
            xi=-10000000;
            xf=-10000000;
            t=-10000000;
        }
    }
    
    private boolean CalcularT(){
        if(t==-10000000){
            if(ve1!= -10000000 && a!= -10000000 && xi!= -10000000 && xf!= -10000000){//xf= xi+vi t + 1/2 a t^2
                try{
                    double raiz = Math.pow(ve1,2)-2*a*(xi-xf);
                    if(raiz>=0){
                        t=(-ve1+Math.pow(raiz,0.5 ))/a;
                        if(t<=0){
                            t=(-ve1-Math.pow(raiz,0.5 ))/a;
                            if(t>0){
                                return true;
                            }else{
                                t=-10000000;
                            }
                        }else{
                            return true;
                        }
                    }else{
                        return false;
                    }
                }catch(Exception ex){

                }
            }
            if(ve1!= -10000000 && a!= -10000000 && ve2!= -10000000){//Vf = vi+at
                t= (ve2-ve1)/a;
                return true;
            }
            if(ve1!= -10000000 && ve2!= -10000000 && xi!= -10000000 && xf!= -10000000){ //xf=xi+(vf+vi)/2 *t
                t=(2*(xf-xi))/(ve1+ve2);
                return true;
            }
            return false;
        }
        return true;
    }
    
    private boolean Calcularv1(){
        if(ve1==-10000000){
            if(t!= -10000000 && a!= -10000000 && ve2!= -10000000){//Vf = vi+at
                ve1= ve2-a*t;
                return true;
            }
            if(t!= -10000000 && ve2!= -10000000 && xi!= -10000000 && xf!= -10000000){ //xf=xi+(vf+vi)/2 *t
                ve1 = ((2*(xf-xi))/t) -ve2;
                return true;
            }
            if(t!= -10000000 && a!= -10000000 && xi!= -10000000 && xf!= -10000000){ //xf= xi+ v1*t + 1/2 * a * t^2
                ve1 = (xf-xi-0.5*a*t*t)/t;
                return true;
            }
            return false;
        }
        return true;
    }
    
    private boolean Calcularv2(){
        if(ve2==-10000000){
            if(t!= -10000000 && a!= -10000000 && ve1!= -10000000){//Vf = vi+at
                ve2= ve1+a*t;
                return true;
            }
            if(t!= -10000000 && ve1!= -10000000 && xi!= -10000000 && xf!= -10000000){ //xf=xi+(vf+vi)/2 *t
                ve2 = ((2*(xf-xi))/t) -ve1;
                return true;
            }
            return false;
        }
        return true;
    }
    
    private boolean Calculara(){
        if(a==-10000000){
            if(t!= -10000000 && ve1!= -10000000 && ve2!= -10000000){//Vf = vi+at
                a=(ve2-ve1)/t;
                return true;
            }
            if(t!= -10000000 && ve1!= -10000000 && xi!= -10000000 && xf!= -10000000){ //xf= xi+ v1*t + 1/2 * a * t^2
                a= 2*(xf-xi-ve1*t)/(Math.pow(t,2));
                return true;
            }
            if(ve2!= -10000000 && ve1!= -10000000 && xi!= -10000000 && xf!= -10000000){ //vf^2=v1^2+2a(xf-xi)
                a=(Math.pow(ve2,2) -Math.pow(ve1,2))/2*(xf-xi);
                return true;
            }
            return false;}
        return true;
    
    }
    
    private boolean Calcularxi(){
        if(xi==-10000000){
            if(t!= -10000000 && ve1!= -10000000 && xf!= -10000000 && a!= -10000000){ //xf= xi+ v1*t + 1/2 * a * t^2
                xi=xf-ve1*t-0.5*a*(Math.pow(t,2));
                return true;
            }
            if(ve2!= -10000000 && ve1!= -10000000 && xf!= -10000000 && a!= -10000000){ //vf^2=v1^2+2a(xf-xi)
                xi=-((Math.pow(ve2,2) -Math.pow(ve1,2))/2*a)+xf;
                return true;
            }
             if(t!= -10000000 && ve1!= -10000000 && xf!= -10000000 && t!= -10000000){ //xf= xi+ ((v1+v2)/2)t
                xi=xf-((ve2+ve1)/2)*t;
                return true;
            }
            return false;
        }
        return true;
    }
    
    private boolean Calcularxf(){
        if(xf==-10000000){
            if(t!= -10000000 && ve1!= -10000000 && xi!= -10000000 && a!= -10000000){ //xf= xi+ v1*t + 1/2 * a * t^2
                xf=xi+ve1*t+0.5*a*(Math.pow(t,2));
                return true;
            }
            if(ve2!= -10000000 && ve1!= -10000000 && xi!= -10000000 && a!= -10000000){ //vf^2=v1^2+2a(xf-xi)
                xf=((Math.pow(ve2,2) -Math.pow(ve1,2))/2*a)+xi;
                return true;
            }
             if(t!= -10000000 && ve1!= -10000000 && xi!= -10000000 && t!= -10000000){ //xf= xi+ ((v1+v2)/2)t
                xf=xi+((ve2+ve1)/2)*t;
                return true;
            }
            return false;
        }
        return true;
    }
    
    private void MostralPanel2(){
        panel1.setVisible(false);
        panel2.setVisible(true);
        
        panel3= new Grafica(ve1, xi, a, 600, 600, 400, xf, t);
        panel3.setBackground(new Color(244, 172 ,183));
        panel3.setBounds(400, 0, 600, 600);
        panel3.setVisible(true);
        this.getContentPane().add(panel3);
        
        
        JLabel label13 = new JLabel( String.valueOf(ve1),  SwingConstants.CENTER);
        label13.setBounds(0, 90, 400, 40);
        label13.setFont(new Font("Arial", Font.BOLD, 16));
        label13.setForeground(Color.white);
        panel2.add(label13);
        
        JLabel label23 = new JLabel( String.valueOf(ve2),  SwingConstants.CENTER);
        label23.setBounds(0, 160, 400, 40);
        label23.setFont(new Font("Arial", Font.BOLD, 16));
        label23.setForeground(Color.white);
        panel2.add(label23);
        
        JLabel label33 = new JLabel( String.valueOf(xi),  SwingConstants.CENTER);
        label33.setBounds(0, 230, 400, 40);
        label33.setFont(new Font("Arial",Font.BOLD, 16));
        label33.setForeground(Color.white);
        panel2.add(label33);
        
        JLabel label43 = new JLabel( String.valueOf(xf),  SwingConstants.CENTER);
        label43.setBounds(0, 300, 400, 40);
        label43.setFont(new Font("Arial", Font.BOLD, 16));
        label43.setForeground(Color.white);
        panel2.add(label43);
        
        JLabel label53 = new JLabel( String.valueOf(a),  SwingConstants.CENTER);
        label53.setBounds(0, 370, 400, 40);
        label53.setFont(new Font("Arial", Font.BOLD, 16));
        label53.setForeground(Color.white);
        panel2.add(label53);
        
        JLabel label63 = new JLabel( String.valueOf(t),  SwingConstants.CENTER);
        label63.setBounds(0, 440, 400, 40);
        label63.setFont(new Font("Arial", Font.BOLD, 16));
        label63.setForeground(Color.white);
        panel2.add(label63);
    }
    
    public void graficarFuncion(int funcion, String Grafico) {
        Plot2DPanel plot = new Plot2DPanel();
        // Crear el panel donde se mostrará el gráfico
        plot.setMinimumSize(new java.awt.Dimension(600, 600));
        plot.setMaximumSize(new java.awt.Dimension(600, 600));
        
        // Definir el intervalo en x que se evaluará
        double[] x = new double[1000];
        for (int i = 0; i < x.length; i++) {
            x[i] = 10 * i / (double) (x.length - 1);
        }
        
        // Evaluar la función para cada valor de x
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = evaluarFuncion(funcion, x[i]);
        }
        
        // Agregar la curva al gráfico
        plot.addLinePlot("Función", x, y);
        JFrame frame = new JFrame(Grafico);
        frame.setSize(600, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }
    
    private double evaluarFuncion(int funcion, double x) {
        double y=0.0;
        if(funcion==1){ //posicion contra tiempo xf= xi+vi*t+0.5a t^2
            y= xi+ve1*x+0.5*a*Math.pow(x, 2);
        }
        if(funcion==2){ //velocidad contra tiempo vf= vi+at
            y= ve1+a*x;
        }
        if(funcion==3){ //a contra tiempo, la aceleracion siempre es constante
            y= a;
        }
        
        
        return y;
    }
    
    
    public static void hacerfuncion(){
        double y;
        y= xi+ve1*tun+0.5*a*Math.pow(tun, 2);
        if((int)Math.floor(y)>300){
            tun = t+1;
            JOptionPane.showMessageDialog(null,"Perdon el valor se sale del grafico de la pantalla"
            , "Error",  JOptionPane.ERROR_MESSAGE);
        }else{
            panel3.setXpos((int)Math.floor(y));
            panel3.repaint();
        }
        
        tun+=0.1;
        Timeout u = new Timeout(tun, t);
        u.start();
    }
    
    public static void ocultar(){
        panel2.setVisible(true);
        panel3.setVisible(false);
    }
}
