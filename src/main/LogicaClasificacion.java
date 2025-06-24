package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
    
        Stack<Character> pila = new Stack<>();
        for (char c : texto.toCharArray()) {
            pila.push(c);
        }
        StringBuilder invertido = new StringBuilder();
        while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }
         return invertido.toString();


    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
public boolean validarSimbolos(String expresion) {
    Stack<Character> pila = new Stack<>();
    Map<Character, Character> mapa = Map.of(
        ')', '(', 
        '}', '{', 
        ']', '['
    );

    for (char c : expresion.toCharArray()) {
        if (mapa.containsValue(c)) {
            pila.push(c); 
        } else if (mapa.containsKey(c)) {
            if (pila.isEmpty() || pila.pop() != mapa.get(c)) {
                return false; 
            }
        }
    }

    return pila.isEmpty(); 
}
  

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> aux = new Stack<>();
        
        while (!pila.isEmpty()) {
            int temp= pila.pop();
        while(!aux.isEmpty() && aux.peek()>temp ){
            pila.push(aux.pop());
        }
        aux.push(temp);
        }
        List<Integer> ordenada = new ArrayList<>();
        while (!aux.isEmpty()) {
            ordenada.add(aux.pop());
        }
        return ordenada;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        for (int num : original){
            if(num %2==0){
                pares.add(num);

            }else{
                impares.add(num);

            }
        } 
    pares.addAll(impares);
    return pares;
    }
 }

    

