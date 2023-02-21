import javax.swing.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        String ruta = JOptionPane.showInputDialog("Introduce la ruta del archivo");
        String tamaño= JOptionPane.showInputDialog("Introduce la cantidad de numeros que quieres introducir");
        int numero = Integer.parseInt(tamaño);
        try{
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta,true));
        DataInputStream dis = new DataInputStream(new FileInputStream(ruta));
        introducirDatos(dos,numero);
        mostrarDatos(dis);

        } catch (EOFException e) {
            System.out.println("Fin archivo");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }
    public static void introducirDatos(DataOutputStream dos, int numero) throws IOException {
        for(int i = 0; i<numero; i++){
            int numeros = rellenarAleatoriamente();
            dos.writeInt(numeros);
        }
        dos.flush();
    }
    public static void mostrarDatos(DataInputStream dis) throws IOException {
        while(true){
            System.out.println(dis.readInt());
        }
    }

    public static int rellenarAleatoriamente(){
        int numero=(int)Math.floor(Math.random()*10+1);
        return numero;
    }
}