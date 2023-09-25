/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

/**
 *
 * @author leledezma
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class CajeroAutomatico extends JFrame implements ActionListener{
    private JLabel RetiroEtiqueta,IngresoEtiqueta;
    private JTextField RetiroCampo,IngresoCampo;
    private JButton ComenzarBoton,masBoton;
    public JTextArea area,areaIzq,areaDer;
    private JScrollPane panel,panel2,panel3;
    public String resultString,areaIzqString,areaDerString;
    private Box bv,bi,bd;

    public CajeroAutomatico(){

        bv = Box.createVerticalBox();
        this.setLayout(new FlowLayout());

        bi = Box.createVerticalBox();
        this.setLayout(new FlowLayout());

        bd = Box.createVerticalBox();
        this.setLayout(new FlowLayout());

        Font font1=new Font("Verdana",Font.PLAIN,12);

        RetiroEtiqueta = new JLabel( "Programa de Cajero Automatico" );
        this.RetiroEtiqueta.setBounds(20, 20, 60, 20);
        add(RetiroEtiqueta);

        resultString="\n\t\t\n\n\n\n\n\n\n\n";
        area=new JTextArea();
        area.setEditable(false);
        area.setFont(font1);
        panel=new JScrollPane(area);
        area.setText(resultString);
        bv.setBounds(0,10,0,20);
        bv.add(panel);
        add(bv);

        areaIzqString="\n\t\n\n\n\n\n\n\n\n";
        areaIzq=new JTextArea();
        areaIzq.setEditable(false);
        areaIzq.setFont(font1);
        panel2=new JScrollPane(areaIzq);
        areaIzq.setText(areaIzqString);
        bi.setBounds(20, 40, 60, 60);
        bi.add(panel2);
        add(bi);

        areaDerString="\n\t\n\n\n\n\n\n\n\n";
        areaDer=new JTextArea();
        areaDer.setEditable(false);
        areaDer.setFont(font1);
        panel3=new JScrollPane(areaDer);
        areaDer.setText(areaDerString);
        bd.setBounds(60, 40, 60, 60);
        bd.add(panel3);
        add(bd);

        bv.setVisible(true);
        bi.setVisible(true);
        bd.setVisible(true);

        this.ComenzarBoton = new JButton("Comenzar simulacion");
        this.ComenzarBoton.setBounds(0, 120, 60, 20);
        add(ComenzarBoton);

        this.masBoton = new JButton("Consulta de Saldo");
        this.masBoton.setBounds(40, 80, 50, 10);
        add(masBoton);


        this.masBoton.addActionListener(this);
        this.ComenzarBoton.addActionListener(this);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280,450);
        setVisible(true);
    }
    
    public static void main (String []args){
       CajeroAutomatico grafico=new CajeroAutomatico();
    }

    public void actionPerformed(ActionEvent e) {
        Cajero cajita=new Cajero();
        if(e.getSource()==ComenzarBoton){
            Cajero caja=new Cajero();
            CajeroAutomatico grafico=new CajeroAutomatico();
            Cliente1 c1=new Cliente1(caja, grafico);
            Cliente2 c2=new Cliente2(caja,grafico);

            c1.start();
            c2.start();

        }
        if (e.getSource()==masBoton){
            String palabra="Tu saldo es: ";
            palabra+=cajita.RegresaCantidad();
            cajita.RegresaCantidad();
            area.setText(palabra);
        }
    }
}

