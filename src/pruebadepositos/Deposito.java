package pruebadepositos;

import java.time.temporal.ChronoUnit;

/**
 * Clase que representa un depósito.
 * 
 * Los atributos que pueden almacenar los objetos son:
 *  -Altura del depósito.
 *  -Radio de la base del depósito.
 *  -Caudal de salida del grifo del depósito.
 *  -Nivel actual del depósito.
 *  -Volumen total que ha almacenado el depósito desde que se creó.
 *  -Volumen total que ha vertido el depósito desde que se creó.
 * 
 * La clase también tiene atributos independientes de los objetos.
 * Estos son:
 *  -Volumen total que han almacenado todos los depósitos hasta el momento.
 *  -Volumen total que han vertido todos los depósitos hasta el momento.
 *  -Número de depósitos totalmente vacíos en el momento actual.
 *  -Número de depósitos totalmente llenos en el momento actual.
 *  -Número total de depósitos existentes en el momento actual.
 * 
 * @author Adrián Romero
 */
public class Deposito {
    
    // Atributos de objeto
    
    private final double ALTURA;  // Altura del depósito en metros
    private final double RADIO;  // Radio del depósito en metros
    private final double CAUDAL;  // Caudal de salida del grifo del depósito en litros/segundos
    
    private double nivelActual;  // Nivel actual del depósito en litros
    private double totalLitrosAlmacenados;  // Cantidad total de litros almacenados en litros
    private double totalLitrosVertidos;  // Cantidad total de litros vertidos en litros
    
    // Atributos de la clase
    
    private static double totalLitrosAlmacenadosDepositos;  // Total de litros almacenados en todos los depósitos en este momento en litros
    private static double totalLitrosIntroducidosDepositos;  // Total de litros introducidos en todos los depósitos en litros
    private static double totalLitrosVertidosDepositos;  // Total de litros vertidos en todos los depósitos en litros
    private static long depositosLlenos;  // Número de depósitos llenos
    private static long depositosVacios;  // Número de depósitos vacios
    
    /**
     * ALTURA_MINIMA: Es la altura mínima que debe tener el depósito (0.20 metros).
     */
    public static final double ALTURA_MINIMA = 0.20;  // En metros
    /**
     * ALTURA_MAXIMA: Es la altura máxima que debe tener el deposito (20 metros).
     */
    public static final double ALTURA_MAXIMA = 20;  // En metros
    /**
     * RADIO_MINIMO: Es el radio mínimo que debe tener la base del depósito (0.20 metros).
     */
    public static final double RADIO_MINIMO = 0.20;  // En metros
    /**
     * RADIO_MAXIMO: Es el radio máximo que debe tener la base del depósito (10 metros).
     */
    public static final double RADIO_MAXIMO = 10;  // En metros
    /**
     * RELACION_MAXIMA: Es la relación máxima que puede haber entre altura y radio (0.5).
     */
    public static final double RELACION_MAXIMA = 0.5;  
    /**
     * CAUDAL_MINIMO: Es el caudal mínimo que puede tener el depósito (0.001 lotros/segundos).
     */
    public static final double CAUDAL_MINIMO = 0.001;  // En litros/segundos
    /**
     * CAUDAL_MAXIMO: Es el caudal máximo que puede tener el depósito (1.0 lotros/segundos).
     */
    public static final double CAUDAL_MAXIMO = 1.0;  // En litros/segundos
    /**
     * ALTURA_DEFECTO: Es la altura por defecto que tendra el depósito (1 metro).
     */
    public static final double ALTURA_DEFECTO = 1;  // En metros
    /**
     * RADIO_DEFECTO: Es el radio que tendra el depósito por defecto (0.5 metros).
     */
    public static final double RADIO_DEFECTO = 0.5;  // En metros
    /**
     * CAUDAL_DEFECTO: Es el caudal por defecto que tendra el depósito (0.100 litros/segundos).
     */
    public static final double CAUDAL_DEFECTO = 0.100;  // En litros/segundos
    
    // Constructores
    
    /**
     * Constructor por defecto con los atributos por defecto declarados arriba.
     */

    public Deposito() {
        this(ALTURA_DEFECTO, RADIO_DEFECTO, CAUDAL_DEFECTO);
    }
    
    /**
     * Constructor con altura y radio como parámetros y caudal por defecto
     * @param ALTURA Altura del depósito en metros
     * @param RADIO  Radio del depósito en metros
     */
    public Deposito(double ALTURA, double RADIO){
        this(ALTURA, RADIO, CAUDAL_DEFECTO);
    }
    
    /**
     * Constructor con altura, radio y caudal como parámetros.
     * @param ALTURA Altura del depósito en metros
     * @param RADIO Radio del depósito en metros
     * @param CAUDAL Caudal de salida del grifo en litros/segundos
     * @throws IllegalArgumentException Por si alguno de los parámetros estuviera fuera de los limites
     */

    public Deposito(double ALTURA, double RADIO, double CAUDAL) throws IllegalArgumentException {
        if(ALTURA<ALTURA_MINIMA || ALTURA>ALTURA_MAXIMA || RADIO<RADIO_MINIMO
                || RADIO>RADIO_MAXIMO || ALTURA/RADIO<RELACION_MAXIMA 
                ||CAUDAL<CAUDAL_MINIMO || CAUDAL>CAUDAL_MAXIMO){
            throw new IllegalArgumentException(" Error: Parámetros de creación del depósito inválidos. No cumplen los requisitos de geometría.");
        }else{
            this.ALTURA = ALTURA;
            this.RADIO = RADIO;
            this.CAUDAL = CAUDAL;
        }
    }
    
    // Métodos consultores (getters)
    
    /**
     * Obtiene la capacidad del depósito (en litros).
     * @return Capacidad del depósito (en litros)
     */
    public double getCapacidad(){
        double capacidad, volumen;
        volumen = Math.PI*RADIO*RADIO*ALTURA;
        capacidad = volumen*1000;
        return capacidad;
    }
    
    /**
     * Obtiene el caudal de salida del grifo del depósito (en litros/segundo).
     * @return caudal de salida del grifo del depósito (en litros/segundo)
     */
    public double getCaudalSalida(){
        return CAUDAL;
    }
    
     /**
      * Indica si el depósito está completamente vacío.
      * @return true si el depósito está completamente vacío
      */
    public boolean estaVacio(){
        boolean vacio;
        vacio = nivelActual==0;
        if(vacio){
            depositosVacios++; // Cada vez que devuelva true, sumara uno en el total de depósitos vacios
        }
        return vacio;
    }
    
    /**
     * Indica si el depósito está completamente lleno.
     * @return true si el depósito está completamente lleno
     */
    public boolean estaLleno(){
        boolean lleno;
        lleno = nivelActual==getCapacidad();
        if(lleno){
            depositosLlenos++; // Cada vez que devuelva true, sumara uno en el total de depósitos llenos
        }
        return lleno;
    }
    
    /**
     * Obtiene el nivel actual del depósito (en litros).
     * @return nivel actual del depósito (en litros)
     */
    public double getNivelActual(){
        return nivelActual;
    }
    
    /**
     * Obtiene la cantidad de litros totales almacenados por el depósito desde su fabricación.
     * @return cantidad de litros totales almacenados por el depósito desde su fabricación
     */
    public double getVolumenIntroducidoDesdeCreacion(){
        return totalLitrosAlmacenados;
    }
    
    /**
     * Obtiene la cantidad de litros totales vertidos por el depósito desde su fabricación.
     * @return cantidad de litros totales vertidos por el depósito desde su fabricación
     */
    public double getVolumenVertidoDesdeCreacion(){
        return totalLitrosVertidos;
    }
    
    /**
     * Obtiene la cantidad de litros totales almacenados por todos los depósitos en el momento actual.
     * @return cantidad de litros totales almacenados por todos los depósitos en el momento actual
     */
    public static double getVolumenGlobalActual(){
        return totalLitrosAlmacenadosDepositos;
    }
    
    /**
     * Obtiene la cantidad de litros totales almacenados por todos los depósitos durante toda la historia de los depósitos hasta el momento actual.
     * @return cantidad de litros totales almacenados por todos los depósitos durante toda la historia de los depósitos hasta el momento actual
     */
    public static double getVolumenGlobalIntroducido(){
        return totalLitrosIntroducidosDepositos;
    }
    
    /**
     * Obtiene la cantidad de litros totales vertidos por todos los depósitos durante toda la historia de los depósitos hasta el momento actual.
     * @return cantidad de litros totales vertidos por todos los depósitos durante toda la historia de los depósitos hasta el momento actual
     */
    public static double getVolumenGlobalVertido(){
        return totalLitrosVertidosDepositos;
    }
    
    /**
     * Obtiene el número de depósitos completamente llenos en el momento actual.
     * @return número de depósitos completamente llenos en el momento actual
     */
    public static long getNumDepositosLlenos(){
        return depositosLlenos;
    }
    
    /**
     * Obtiene el número de depósitos completamente vacíos en el momento actual.
     * @return número de depósitos completamente vacíos en el momento actual.
     */
    public static long getNumDepositosVacios(){
        return depositosVacios;
    }
    
    // Metodos de acción
    
    /**
     * Rellena el depósito una determinada cantidad de litros.
     * @param litros - Cantidad de litros con los que se desea rellenar el depósito
     * @throws IllegalArgumentException - si se produce un rebosamiento debido a que la cantidad de litros de llenado es superior a la que cabe en ese momento en el depósito
     */
    public void llenar(double litros)throws IllegalArgumentException{
        if(litros+nivelActual>getCapacidad()){
            double seLlena;
            double diferencia = litros+nivelActual-getCapacidad();
            diferencia = Math.round(diferencia * 100) / 100d; // Este código lo uso para simplificar a dos decimales
            seLlena = getCapacidad()-nivelActual; // La cantidad que se llena en el caso de que desborde
            nivelActual=getCapacidad();
            totalLitrosAlmacenadosDepositos+=seLlena;
            totalLitrosAlmacenados+=litros-diferencia;
            totalLitrosIntroducidosDepositos+=litros-diferencia;
            throw new IllegalArgumentException ("Error: Depósito lleno. Se ha desbordado en "+diferencia+" litros.");
        }else{
            nivelActual += litros;
            totalLitrosAlmacenadosDepositos += litros;
            totalLitrosAlmacenados+=litros;
            totalLitrosIntroducidosDepositos+=litros;
        }
    }
     /**
      * Abre el grifo del depósito una determinada cantidad de segundos.
      * @param segundos - Cantidad de segundos durante los que se desea abrir el grifo del depósito
      * @return cantidad de litros vertidos mientras el grifo ha estado abierto
      * @throws IllegalArgumentException - si la cantidad de segundos es inválida (número negativo)
      */
    public double abrirGrifo(double segundos)throws IllegalArgumentException{
        double litrosVertidos;
        if(segundos<0){
            throw new IllegalArgumentException ("Error: Parámetro de tiempo inválido (tiempo negativo).");
        }else{
            litrosVertidos = CAUDAL*segundos;
        }
        if(litrosVertidos>nivelActual){
            litrosVertidos=nivelActual;
        }
        nivelActual-=litrosVertidos;
        totalLitrosAlmacenadosDepositos-=litrosVertidos;
        totalLitrosVertidos+=litrosVertidos;
        totalLitrosVertidosDepositos+=litrosVertidos;
        return litrosVertidos;
    }
    
    /**
     * Abre el grifo del depósito el tiempo transcurrido entre dos instantes.
     * @param inicio - instante de apertura del grifo
     * @param fin - instante de cierre del grifo
     * @return cantidad de litros vertidos mientras el grifo ha estado abierto
     * @throws IllegalArgumentException - si el instante de inicio es posterior al de fin, o si alguno de los instantes es null
     */
    public double abrirGrifo(java.time.LocalTime inicio, java.time.LocalTime fin) throws IllegalArgumentException {
        double litrosVertidos;
        if(inicio == null || fin == null){
            throw new IllegalArgumentException ("Error: Parámetros de tiempo inválidos (null).");
        }
        if(inicio.isAfter(fin)){
            throw new IllegalArgumentException ("Error: Parámetros de tiempo inválidos (el instante de inicio es posterior al de fin).");
        }
        double segundos = inicio.until(fin, ChronoUnit.SECONDS);
        litrosVertidos=abrirGrifo(segundos);
        return litrosVertidos;
    }
    
    /**
     * Abre el grifo del depósito hasta que quede completamente vacío.
     * @return tiempo necesario para que el depósito se haya vaciado (segundos)
     */
    public double vaciar(){
        double segundosEnVaciar;
        segundosEnVaciar=nivelActual/CAUDAL;
        totalLitrosVertidos+=nivelActual;
        totalLitrosVertidosDepositos+=nivelActual;
        totalLitrosAlmacenadosDepositos-=nivelActual;
        nivelActual=0;
        return segundosEnVaciar;
    }
    
    /**
     * Devuelve una cadena que representa el estado actual del depósito. Esa cadena proporcionará la siguiente información:
     *  -Capacidad del depósito.
     *  -Nivel del depósito actual.
     *  -Volumen almacenado histórico desde que se construyó el objeto.
     *  -Volumen vertido histórico desde que se construyó el objeto.
     * @return Cadena que representa el estado actual del depósito
     */
    @Override
    public String toString(){
        StringBuilder cad = new StringBuilder();
        cad.append("Capacidad: ");
        cad.append(String.format ("%5.2f litros ", getCapacidad()));
        cad.append("- NivelActual: ");
        cad.append(String.format ("%5.2f litros ", nivelActual));
        cad.append("- AlmacenadoTotal: ");
        cad.append(String.format("%5.2f litros ", totalLitrosAlmacenados));
        cad.append("VertidoTotal: ");
        cad.append(String.format("%5.2f litros", totalLitrosVertidos));
        return cad.toString();
    }

}
