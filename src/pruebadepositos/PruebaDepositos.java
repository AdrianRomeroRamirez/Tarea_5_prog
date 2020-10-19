/*
 * Programa de pruebas de la clase Deposito.
 */
package pruebadepositos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Programa de prueba de la clase Deposito.
 * Se crean varios objetos de la clase Deposito y 
 * se utilizan probando sus métodos para observar su comportamiento.
 * Cada vez que se trabaja con uno de estos objetos se genera un informe
 * para observar cómo ha afectado al estado del objeto en particular (atributos 
 * de objeto) y la clase en general (atributos estáticos)
 * @author profe
 */
public class PruebaDepositos {

   final static int LONG_MARGEN= 30;
   static String  margenEstadoDeposito= relleno (' ', LONG_MARGEN);
   static String justificacionAccionDeposito= "%-" + LONG_MARGEN + "s";
    
    
    public static void main(String[] args) {

        Deposito[] listaDep= {null, null, null, null, null, null};
        String[] nombreDep= {"dep0", "dep1", "dep2", "dep3", "dep4", "dep5"};
        
        LocalTime tInicio;
        LocalTime tFin;
        
        // Informes iniciales
        System.out.print (generaInformeTotalDepositos());
        
        //-------------------------------------------------------
        // PRUEBAS CON dep0
        //-------------------------------------------------------
        // Pruebas con el depósito Dep0
        System.out.println ();
        System.out.println ("PRUEBAS CON EL DEPÓSITO dep0");
        System.out.println ("----------------------------");
        System.out.print (String.format (justificacionAccionDeposito, "Fabricación dep0: "));
        try {
            listaDep[0]= new Deposito (1,5,0.1);
            System.out.println("Depósito creado sin error.");            
        } catch (IllegalArgumentException e) {
            // Error al crear el depósito con los parámetros proporcionados
            // Creamos el depósito con el constructor por defecto
            System.out.print (e.getMessage());
            System.out.println (" Se crea el depósito con los valores por defecto.");
            listaDep[0]= new Deposito ();
        } finally {
            System.out.println (margenEstadoDeposito + listaDep[0].toString());            
        }
        
        // Informe final
        System.out.print (generaInformeDeposito (listaDep[0], nombreDep[0]));
        System.out.print (generaInformeTotalDepositos());
        
        //-------------------------------------------------------
        // PRUEBAS CON dep1
        //-------------------------------------------------------
        // Pruebas con el depósito dep1
        System.out.println ();
        System.out.println ("PRUEBAS CON EL DEPÓSITO dep1");
        System.out.println ("----------------------------");
        System.out.print (String.format (justificacionAccionDeposito, "Fabricación dep1: "));
        try {
            listaDep[1]= new Deposito (1,0.25,0.1);
            System.out.println("Depósito creado sin error.");            
        } catch (IllegalArgumentException e) {
            // Error al crear el depósito con los parámetros proporcionados
            // Creamos el depósito con el constructor por defecto
            System.out.println (e.getMessage());
            System.out.println (" Se crea el depósito con los valores por defecto.");
            listaDep[1]= new Deposito ();
        } finally {
            System.out.println (margenEstadoDeposito + listaDep[1].toString());            
        }
        
        llenarDeposito (listaDep[1], 200.0);
        abrirGrifoDeposito (listaDep[1], -5);
        abrirGrifoDeposito (listaDep[1], 10);
        llenarDeposito (listaDep[1], 10.0);
        llenarDeposito (listaDep[1], 1.0);
        llenarDeposito (listaDep[1], 1.0);
                
        // Informe final
        System.out.print (generaInformeDeposito (listaDep[1], nombreDep[1]));
        System.out.print (generaInformeTotalDepositos());
        
        //-------------------------------------------------------
        // PRUEBAS CON dep2
        //-------------------------------------------------------
        // Pruebas con el depósito Dep2
        System.out.println ();
        System.out.println ("PRUEBAS CON EL DEPÓSITO dep2");
        System.out.println ("----------------------------");
        System.out.print (String.format (justificacionAccionDeposito, "Fabricación dep2: "));
        try {
            listaDep[2]= new Deposito (1,0.25,0.1);
            System.out.println("Depósito creado sin error.");            
        } catch (IllegalArgumentException e) {
            // Error al crear el depósito con los parámetros proporcionados
            // Creamos el depósito con el constructor por defecto
            System.out.println (e.getMessage());
            System.out.println (" Se crea el depósito con los valores por defecto.");
            listaDep[2]= new Deposito ();
        } finally {
            System.out.println (margenEstadoDeposito + listaDep[2].toString());            
        }
        
        abrirGrifoDeposito (listaDep[2], 50.0);
        llenarDeposito (listaDep[2], 50.0);
        vaciarDeposito(listaDep[2]);
        llenarDeposito (listaDep[2], 50.0);
        tInicio= LocalTime.parse("11:50:00");
        tFin= LocalTime.parse("12:30:00");
        abrirGrifoDeposito (listaDep[2], tInicio, tFin);

        // Informe final
        System.out.print (generaInformeDeposito (listaDep[2], nombreDep[2]));
        System.out.print (generaInformeTotalDepositos());
        
        //-------------------------------------------------------
        // PRUEBAS CON dep3
        //-------------------------------------------------------
        // Pruebas con el depósito Dep3
        System.out.println ();
        System.out.println ("PRUEBAS CON EL DEPÓSITO dep3");
        System.out.println ("----------------------------");
        System.out.print (String.format (justificacionAccionDeposito, "Fabricación dep3: "));
        try {
            listaDep[3]= new Deposito (0.4,0.2,1);
            System.out.println("Depósito creado sin error.");            
        } catch (IllegalArgumentException e) {
            // Error al crear el depósito con los parámetros proporcionados
            // Creamos el depósito con el constructor por defecto
            System.out.println (e.getMessage());
            System.out.println (" Se crea el depósito con los valores por defecto.");
            listaDep[3]= new Deposito ();
        } finally {
            System.out.println (margenEstadoDeposito + listaDep[3].toString());            
        }
        
        llenarDeposito (listaDep[3], 50.0);
        abrirGrifoDeposito (listaDep[3], 100);
        llenarDeposito (listaDep[3], 100.0);
        abrirGrifoDeposito (listaDep[3], 50);

        // Informe final
        System.out.print (generaInformeDeposito (listaDep[3], nombreDep[3]));
        System.out.print (generaInformeTotalDepositos());
        
        //-------------------------------------------------------
        // PRUEBAS CON dep4
        //-------------------------------------------------------
        // Pruebas con el depósito Dep4
        System.out.println ();
        System.out.println ("PRUEBAS CON EL DEPÓSITO dep4");
        System.out.println ("----------------------------");
        System.out.print (String.format (justificacionAccionDeposito, "Fabricación dep4: "));
        try {
            listaDep[4]= new Deposito (0.8,0.2,0.1);
            System.out.println("Depósito creado sin error.");            
        } catch (IllegalArgumentException e) {
            // Error al crear el depósito con los parámetros proporcionados
            // Creamos el depósito con el constructor por defecto
            System.out.println (e.getMessage());
            System.out.println (" Se crea el depósito con los valores por defecto.");
            listaDep[4]= new Deposito ();
        } finally {
            System.out.println (margenEstadoDeposito + listaDep[4].toString());            
        }
        
        tInicio= LocalTime.parse("13:50:00");
        tFin= LocalTime.parse("13:50:20");
        llenarDeposito (listaDep[4], 50.0);
        abrirGrifoDeposito (listaDep[4], null, tFin);        
        abrirGrifoDeposito (listaDep[4], tInicio, null);        
        abrirGrifoDeposito (listaDep[4], tFin, tInicio);
        abrirGrifoDeposito (listaDep[4], tInicio, tFin);
        abrirGrifoDeposito (listaDep[4], tInicio, tInicio);

        // Informe final
        System.out.print (generaInformeDeposito (listaDep[4], nombreDep[4]));
        System.out.print (generaInformeTotalDepositos());
        
        //-------------------------------------------------------
        // PRUEBAS CON dep5
        //-------------------------------------------------------
        // Pruebas con el depósito Dep5
        System.out.println ();
        System.out.println ("PRUEBAS CON EL DEPÓSITO dep5");
        System.out.println ("----------------------------");
        System.out.print (String.format (justificacionAccionDeposito, "Fabricación dep5: "));
        try {
            listaDep[5]= new Deposito (1,0.5);
            System.out.println("Depósito creado sin error.");            
        } catch (IllegalArgumentException e) {
            // Error al crear el depósito con los parámetros proporcionados
            // Creamos el depósito con el constructor por defecto
            System.out.println (e.getMessage());
            System.out.println (" Se crea el depósito con los valores por defecto.");
            listaDep[5]= new Deposito ();
        } finally {
            System.out.println (margenEstadoDeposito + listaDep[5].toString());            
        }
        
        vaciarDeposito(listaDep[5]);
        vaciarDeposito(listaDep[5]);
        vaciarDeposito(listaDep[5]);


        // Informe final
        System.out.print (generaInformeDeposito (listaDep[5], nombreDep[5]));
        System.out.print (generaInformeTotalDepositos());
        

    }

    
    // Método para probar la llamada al método de llenado de un depósito
    private static void llenarDeposito (Deposito dep, double litros) {
        System.out.print (String.format (justificacionAccionDeposito, "Llenar " + String.format("%5.2f litros: ", litros)));            
        try {
            dep.llenar(litros);
            System.out.println("Llenado de depósito sin error.");            
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        } finally {
            System.out.println (margenEstadoDeposito + dep.toString());
        }        
    }
    
    // Método para probar la llamada al método de llenado de un depósito
    private static void abrirGrifoDeposito (Deposito dep, double segundos) {
        System.out.print (String.format (justificacionAccionDeposito, "Abrir grifo " + String.format("%5.2f seg: ", segundos)));            
        try {
            double litros= dep.abrirGrifo(segundos);
            System.out.println("Grifo abierto sin error. Vertidos " + String.format ("%5.2f", litros) + " litros.");            
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        } finally {
            System.out.println (margenEstadoDeposito + dep.toString());
        }        
    }
    
    // Método para probar la llamada al método de llenado de un depósito
    private static void abrirGrifoDeposito (Deposito dep, LocalTime inicio, LocalTime fin) {
        DateTimeFormatter formatoHora = DateTimeFormatter.ISO_TIME;
        System.out.print (String.format (justificacionAccionDeposito, "Abrir entre " + inicio + 
                " y " + fin + ": ") );            
        try {
            double litros= dep.abrirGrifo(inicio, fin);
            System.out.println("Grifo abierto sin error. Vertidos " + String.format ("%5.2f", litros) + " litros.");            
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        } finally {
            System.out.println (margenEstadoDeposito + dep.toString());
        }        
    }
    
    // Método para probar la llamada al método de vaciado de un depósito
    private static void vaciarDeposito (Deposito dep) {
        System.out.print (String.format (justificacionAccionDeposito, "Vaciar: "));            
        try {
            double t= dep.vaciar();
            System.out.println("Depósito vaciado sin error. Ha tardado " + String.format("%5.2f", t) + " segundos");            
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        } finally {
            System.out.println (margenEstadoDeposito + dep.toString());
        }        
    }


    // Método para generar un informe sobre un depósito
    private static String generaInformeDeposito (Deposito deposito, String nombreDeposito) {
        StringBuilder informe= new StringBuilder();
        String cabecera= "INFORME DEL DEPÓSITO " + nombreDeposito;
        
        informe.append("\n").append(cabecera).append ("\n");
        informe.append (relleno('-', cabecera.length()));
        if (deposito!=null) {
            informe.append ("\nCapacidad del depósito: ");
            informe.append (String.format ("%5.2f litros", deposito.getCapacidad()));
            informe.append ("\nCaudal del depósito: ");
            informe.append (String.format ("%5.2f litros/seg", deposito.getCaudalSalida()));
            informe.append ("\nNivel del depósito: ");
            informe.append (String.format ("%5.2f litros", deposito.getNivelActual()));            
            informe.append ("\nVolumen total almacenado por el depósito desde su fabricación: ");
            informe.append (String.format ("%5.2f litros", deposito.getVolumenIntroducidoDesdeCreacion()));
            informe.append ("\nVolumen total vertido por el depósito desde su fabricación: ");
            informe.append (String.format ("%5.2f litros", deposito.getVolumenVertidoDesdeCreacion()));
            informe.append ("\nDepósito lleno: ").append (deposito.estaLleno());
            informe.append ("\nDepósito vacío: ").append (deposito.estaVacio());
        }
        else {
            informe.append("\nEl depósito ").append(nombreDeposito).append (" aún no existe.");
        }
        informe.append ("\n\n");
        return informe.toString();
    }
    
    
    // Método para generar un informe sobre todo el conjunto de depósitos
    private static String generaInformeTotalDepositos () {
        StringBuilder informe= new StringBuilder();
        String cabecera= "INFORME GLOBAL DE TODOS LOS DEPÓSITOS";
                
        informe.append(cabecera).append ("\n");
        informe.append (relleno('-', cabecera.length()));
        informe.append ("\nVolumen total almacenado por todos los depósitos en este instante: ");
        informe.append (String.format ("%5.2f", Deposito.getVolumenGlobalActual()));
        informe.append ("\nVolumen global almacenado por todos los depósitos: ");
        informe.append (String.format ("%5.2f", Deposito.getVolumenGlobalIntroducido()) );
        informe.append ("\nVolumen global vertido por todos los depósitos: ");
        informe.append (String.format ("%5.2f", Deposito.getVolumenGlobalVertido()) );
        informe.append ("\nNúmero de depósitos completamente llenos: ");
        informe.append (Deposito.getNumDepositosLlenos());
        informe.append ("\nNúmero de depósitos completamente vacíos: ");
        informe.append (Deposito.getNumDepositosVacios());
        informe.append ("\n\n");

        return informe.toString();
    }

    // Método para generar una cadena rellena con un caracter
    private static String relleno (char caracter, int longitud)  {
        StringBuilder resultado= new StringBuilder (longitud);
        for (int i = 0; i < longitud; i++){
           resultado.append(caracter);
        }
        return resultado.toString();
    }    
}
