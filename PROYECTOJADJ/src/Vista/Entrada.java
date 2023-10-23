package Vista;

import java.time.LocalDate;
import java.util.Scanner;

public class Entrada {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static int leerInt(String mensaje){
        
        System.out.print( mensaje);
        return scanner.nextInt();
    }
    
    
    public static double leerDouble(String mensaje){
        
        System.out.printf( mensaje);
        return scanner.nextDouble();
        
    }
    
    public static String leerString(String mensaje){
        System.out.printf(mensaje);
        return scanner.next();
    }
    
    public static String leerLinea(String mensaje){
        
        System.out.printf(mensaje);
        scanner = new Scanner(System.in);
        return scanner.nextLine();
        
    }
     public static char leerChar(String mensaje){
        System.out.printf(mensaje);
        return scanner.next().toUpperCase().charAt(0);
    }
     public static float leerFloat(String mensaje){
         System.out.printf(mensaje);
         return scanner.nextFloat();
     }
    
    
    public static LocalDate leerFecha(String mensaje){
        System.out.printf(mensaje);
        
        int año = leerInt("Año(aaaa)");
        int mes = leerInt("Mes(1-12)");
        int dia = leerInt("Dia(1-31)");
        
        return LocalDate.of(año, mes, dia);
    }

    
    
}
