package Model;

import java.util.ArrayList;

public class UtilGenerico {

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> crearLista(T... elementos) {
        ArrayList<T> lista = new ArrayList<>();
        if (elementos != null) {
            for (T elemento : elementos) {
                lista.add(elemento);
            }
        }
        return lista;
    }

    public static <T> void mostrarElementos(ArrayList<T> lista) {
        if (lista != null) {
            for (T item : lista) {
                System.out.println("[Elemento]: " + item.toString());
            }
        }
    }
}