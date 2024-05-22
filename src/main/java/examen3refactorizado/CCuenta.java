
package examen3refactorizado;

/**
 * 
 * @author Rubén Aragunde Vila
 * @version 22/05/2024
 */
public class CCuenta {
    // Propiedades de la Clase Cuenta
    private double dSaldo;
    private String nombre;
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {

        CCuenta cuenta1 = new CCuenta();

        System.out.println("Saldo Incial: " + cuenta1.getdSaldo() + " euros");

        operativa_cuenta(cuenta1, null);
    }
    /**
     * 
     * @param cuenta1 Cuenta bancaria en la que quiere hacer las operaciones
     * @param cantidad Cantidad de dinero con el que se desea operar
     */
    public static void operativa_cuenta(CCuenta cuenta1, java.lang.Float cantidad) {
        cuenta1.ingresar(300);
        System.out.println("Saldo Incial: " + cuenta1.getdSaldo() + " euros");
        cuenta1.ingresar(100);
        System.out.println("Saldo tras ingreso: " + cuenta1.getdSaldo() + " euros");
        cuenta1.ingresar(3000);
        System.out.println("Saldo tras ingreso: " + cuenta1.getdSaldo() + " euros");

        cuenta1.ingresar(300);
        System.out.println("Saldo tras ingreso: " + cuenta1.getdSaldo() + " euros");
        cuenta1.retirar(50);
        System.out.println("Saldo tras retirada: " + cuenta1.getdSaldo() + " euros");
    }

    /* Metodo para ingresar cantidades en la cuenta. Modifica el saldo. */
    /**
     * 
     * @param cantidad cantidad de dinero a ingresar en la cuenta
     * @return devuleve el código de error 1 si la cantidad es menor o igual a 0 y si la cantidad excede los 3000
     */
    public int ingresar(double cantidad) {
        int iCodErr;

        if ((cantidad <= 0 || cantidad > 3000)) { //Modificación de la condición para que funcione
            System.out.println("No se puede ingresar una cantidad negativa ni superior a 3000€ (sin ser notificada con formulario)");
            iCodErr = 1;
        } else if (cantidad == 3000) {
            System.out.println(
                    "Le recordamos que estamos obligados a notificar a Hacienda dicho ingreso (superior o igual a 3000€)");
            setdSaldo(getdSaldo() + cantidad);
            iCodErr = 0;
        } else {
            setdSaldo(getdSaldo() + cantidad);
            iCodErr = 0;
        }

        return iCodErr;
    }

    /*
     * Metodo para retirar cantidades en la cuenta. Modifica el saldo.
     */
    /**
     * 
     * @param cantidad Cantidad de dinero a retirar de la cuenta bancaria
     */
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("No se puede retirar una cantidad negativa");
        } else if (getdSaldo() < cantidad) {
            System.out.println("No  hay suficiente saldo");
        } else {
            setdSaldo(getdSaldo() - cantidad);
            System.out.println("Le quedan " + getdSaldo() + " en cuenta");
        }
    }

    /**
     * @return retorna el saldo actual de la cuenta
     */
    public double getdSaldo() {
        return dSaldo;
    }

    /**
     * @param dSaldo Saldo con el que se desea iniciar la cuenta
     */
    public void setdSaldo(double dSaldo) {
        this.dSaldo = dSaldo;
    }

    /**
     * @return Devuelve el nombre asociado a la cuenta bancaria
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nombre con el que se desea iniciar la cuenta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
