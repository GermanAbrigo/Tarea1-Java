
package tarea.n.pkg1;

import java.text.DecimalFormat;

/**
 *
 * @author GERMÁN ÁBRIGO VALENZUELA
 */
public class Ejercicio2 {
    /*
    FUNCIÓN PARA EL CÁLCULO DEL COSTO TOTAL DEL PROBLEMA DE LA MOCHILA KP
    La metodología de desarrollo consiste en que si el elemento se encuentra en la mochila
    este costo es sumado a la variable que determina el costo total de la mochila
    */
    public static double Ctotal(int[] a, double[] b){
        int o= a.length; /*Obtener cantidad de materiales  */
        int c= b.length; /*Obtener cantidad de costos  */
        double sum = 0;
        
        if (o==c){ /*Condición inicial que realiza cálculos si todos los materiales tienen costo asociado*/
            for(int i=0;i<o;i++){ /*Ciclo que recorre matriz binaria para calculo*/
                if(a[i]==1){ /*Si está material en mochila suma el costo */
                        sum+= b[i];
                }    
            }
            return sum;
        }
        else { /*Incumplimiento de condición inicial cuando no hay costo asociado a material o viceversa*/
            return -1;
        }
    }
    
    /*Programa principal que calcula costo total del Problema de la mochila KP*/
    public static void main(String[] args) {
        /*Dos soluciones para cáculo de monto total */
        int[] A = {0,1,1,0,1};
        double[] B = {5.99,4.49,3.56,2.34,1.99}; /*Montos en Dollares*/
        
        /*Condición que determina el costo de la mochila */
        double funcion=Ctotal(A,B); /*llamado de función*/
        
        /*Condiciones de acuerdo a lo que función retorna*/
        if (funcion==-1){ /*Incompatibilidad de soluciones*/
            System.out.println("Las soluciones no son compatibles, cada elemento debe tener asociado un costo");
        }
        else if(funcion==0){ /*Mochila sin elementos*/
            System.out.println("La Mochila no tiene materiales por lo tanto su costo es $0");
        }
        else{ /*Costo materiales en Mochila*/
            DecimalFormat df = new DecimalFormat("#.00"); /*Dar formato a monto a dos decimales*/
            System.out.println("El costo total de los elementos en la mochila es de $"+df.format(funcion));
        }
    }
}
