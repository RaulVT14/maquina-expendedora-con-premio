public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Contador de los billetes vendidos
    private int contadorDeBilletes;
    // Tipo de maquina
    private boolean maquinaConPremio;
    // Cantidad de billetes maximos
    private int billetesMaximos;
    // Billetes que faltan para el premio
    private int billetesParaPremio;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean tipoDeMaquina, int cantidadDeBilletesMaximos) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        contadorDeBilletes = 0;
        maquinaConPremio = tipoDeMaquina;
        billetesMaximos = cantidadDeBilletesMaximos;
        billetesParaPremio = 3;
        estacionOrigen = origen;
        estacionDestino = destino;
    }
    
    /**
     * Devuelve el n?mero de billetes vendidos 
     * desde que se crea la m?quina
     */
    public int getNumeroBilletesVendidos() {
        return contadorDeBilletes;
    }
    
    /**
     * Imprime en pantalla el numero de billetes vendidos
     * desde que se crea la m?quina
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println("Se han vendido:" + contadorDeBilletes + "billetes");
    }
    /**
     * Vacia todo el dinero de la maquina
     */
    public int vaciarDineroDeLaMaquina() {
        int vaciarDineroDeLaMaquina;
        vaciarDineroDeLaMaquina = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual != 0) {
            System.out.println("ERROR, hay una operaci?n en curso");
            
        }
        else {
            totalDineroAcumulado = 0;
            
        }
        return vaciarDineroDeLaMaquina;
    }
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }
        if (billetesMaximos == 0) {
            System.out.println("No quedan billetes");
            balanceClienteActual = 0;
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {       
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (precioBillete <= balanceClienteActual) {        
            if (billetesMaximos > 0) {
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         

                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = 0;
                // Actualizar contador
                contadorDeBilletes = contadorDeBilletes + 1;
                // Actualizar cantidad de billetes maximos
                billetesMaximos = billetesMaximos - 1;
                // Billetes que faltan para premio
                billetesParaPremio = billetesParaPremio - 1;
                 if (maquinaConPremio == true) {
                    if (billetesParaPremio == 0)  {
                        System.out.println(" Tienes "  + (10 * precioBillete)/100  + " euros de descuento ");
                        // Actualizar billetes que quedan para el premio
                        billetesParaPremio = 3;
                    
                    }
                }
            }
            else {
                System.out.println("No quedan billetes");
            }
        }
        else {
            if (billetesMaximos == 0) {
                System.out.println("No quedan billetes");

            }
            else {
                System.out.println(" Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros que faltan! ");
            }

        }            
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
