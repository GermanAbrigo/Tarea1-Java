
package tarea.n.pkg1;


import java.util.Arrays;

/**
 *
 * @author GERMÁN ÁBRIGO VALENZUELA
 */
public class Ejercicio3 {
    /*
    FUNCIÓN PARA LA OBTENCIÓN DE SOLUCIONES VECINAS AL PROBLEMA DE LAS 8 REINAS
    La metodología de desarrollo consiste que bajo una solución aleatoria del problema, se genera un 
    intercambio de posición de dos reinas en el tablero, las que se establece por generación 
    aleatoria de subindices y cabian entre ellos su argumento
    */
    public static int[] generarVecino(int[] a){
        
        int d=(int) (Math.random()*8); /*Generar numero aleatorio correspondiente a subindice 1 a cambiar*/
        int k=(int) (Math.random()*8); /*Generar numero aleatorio correspondiente a subindice 2 a cambiar*/
        while(d==k){    /*Ciclo generado para que los numeros anteriores no sean iguales*/
            k=(int) (Math.random()*8);
        }
        /*Intercambio de posiciones según subindices*/
        int c=a[d]; 
        a[d]=a[k];
        a[k]=c;
        return a; /*Retorno arreglo modificado*/
    }
    /*Programa principal que genera n vecinos de una solución del Problemas de las 8 reinas*/
    public static void main(String[] args) {
        /*Solicitud de n vecinos mediante argumento */
        int n= Integer.parseInt(args[0]);
        int[] A = {1,2,3,4,5,6,7,8}; /*solución inicial para identificar 8 reinas en el tablero sin que se repitan*/
        
        /*Algoritmo de Fisher-Yates para generar permutación al azar de la solución inicial */
        int L=A.length;
        for(int i=0;i<L;i++){
            int m=(int) (i + Math.random() * (L-i));
            int g=A[m];
            A[m]=A[i];
            A[i]=g;
        }
        
        /*Obtención de las n soluciones vecinas*/
        System.out.println(Arrays.toString(A)); /*Identificación de solución al azar segun Fisher-Yates*/
        System.out.println("Vecinos de la solución inicial son: ");
        for(int i=0;i<n;i++){ /*n vecinos*/
            /*Se genera copia de arreglo Fisher-Yates debido a que es sin remplazo*/
            int[] b = new int[8];
            System.arraycopy(A, 0, b, 0, 8);
            int[] t= generarVecino(b); /*Generación de una solución vecinos llamando a función*/
            System.out.println(Arrays.toString(t)); /*Impresión de solución vecina generada*/
        }   
    }
}
