
package tarea.n.pkg1;

import java.util.Arrays;

/**
 *
 * @author GERMÁN ÁBRIGO VALENZUELA
 */
public class Ejercicio1 {
    /*
    FUNCIÓN PARA LA EVALUACIÓN DE DOS SOLUCIONES DE TSP QUE DETERMINA
    SI SON O NO ANÁLOGAS
    La metodología de desarrollo consiste en tomar los dos nodos vecinos de cada solución, y ordenarlos en
    cuanto a número, luego estos se comparan estableciendo que si estos son iguales se sumará uno a un contador
    el que debe ser igual al numero de nodos de cada solución para que estas soluciones sean análogas
    */
    public static int Analogo(int[] a, int[] b){
        int p= a.length; /*Obtener dimensión de solución 1 de TSP  */
        int s= b.length; /*Obtener dimensión de solución 2 de TSP  */
        int cont=0; /*Contador para evaluación final de soluciones son análogas */
        int t,g= 0;
        
        if (p==s){ /*Condición inicial que determina previa analogía por igualdad de dimensiones*/
            for(int i=0;i<p;i++){ /*Ciclo que recorre solución 1 */
                /*
                Este ciclo involucra tres casos para la evaluación:
                Caso 1: Cuando inicia la solución (primer índice 0 que se evalúa con ultimo de la solución) 
                Caso 2: Cuando termina la solución (ultimo índice p)evaluandose con el primer indice
                Caso 3: valores intermedios evaluando con el anterior y el siguiente
                */
                if(i==0){ /*Caso 1 en solución 1*/
                    if(a[1]>a[p-1]){ /*Orden de vecinos*/
                        t= (a[p-1]*10)+a[1]; /*Establecer vecinos como numero*/
                    }
                    else{
                        t= (a[1]*10)+a[p-1];
                    }
                    }
                else if(i==(p-1)){ /* Caso 3 en solución 1*/
                    if(a[0]>a[p-2]){
                        t= (a[p-2]*10)+a[0];
                    }
                    else{
                        t= (a[0]*10)+a[p-2];
                    }
                }
                else{
                    if(a[i-1]>a[i+1]){ /*Caso 2 en solución 1*/
                        t= (a[i+1]*10)+a[i-1];
                    }
                    else{
                        t= (a[i-1]*10)+a[i+1];
                    }
                }
                for(int j=0;j<s;j++){ /*Ciclo que recorre la segunda solución para realizar la comparación*/
                    if(b[j]==a[i]){ /*Busca nodo de solución 1 en la solución 2 y obtiene los vecinos*/
                        if(j==0){ /*Caso 1 en solución 2 */
                            if(b[1]>b[s-1]){
                                g= (b[s-1]*10)+b[1];
                            }
                            else{
                                g= (b[1]*10)+b[s-1];
                            }
                            }
                        else if(j==(s-1)){ /*Caso 3 en solución 2 */
                            if(b[0]>b[s-2]){
                                g= (b[s-2]*10)+b[0];
                            }
                            else{
                                g= (b[0]*10)+b[s-2];
                            }
                        }
                        else{ /*Caso 2 en solución 2 */
                            if(b[j-1]>b[j+1]){
                                g= (b[j+1]*10)+b[j-1];
                            }
                            else{
                                g= (b[j-1]*10)+b[j+1];
                            }
                        }
                    }
                }
                if(t==g) { /*formación del contador bajo igualdad de vecinos de cada nodo en soluciones */
                    cont+=1;
                }
            }
        }
        else { /*Incumplimiento de condición incial que determina que no son análogas de acuerdo a dimensión*/
            return 0;
        }
        
        /*Retorna 1 si son análogas por misma cantidad de igualdad de vecinos*/
        if(cont==p) return 1; /*Puede ser igual a p o s ya que ambos son los mismos numeros */
        else    return 0;
    }
    
    
    /*Programa principal que evalua si dos soluciones son análogas*/
    public static void main(String[] args) {
        /*Dos soluciones para evaluación de análogía */
        int[] A = {1,2,3,4,5};
        int[] B = {5,4,3,2,1};
        
        /*Condición que determina Analogía de soluciones de acuerdo a resultado de función */
        if (Analogo(A,B)==0){ /*llamado de función*/
            System.out.println("Las soluciones "+ Arrays.toString(A) + " y " + Arrays.toString(B) + " NO son análogas");
        }
        else{
            System.out.println("Las soluciones "+ Arrays.toString(A) + " y " + Arrays.toString(B) + " son análogas");
        }
    }
    
}
