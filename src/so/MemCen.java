package so;

import java.util.ArrayList;

/**
 * MemCen
 */
public class MemCen {

    private boolean[] paginas;

    public MemCen( int numPags ){
        paginas = new boolean[numPags];

        for (int i = 0; i < numPags; i++) {
            paginas[i] = true;
        }
    }

    public synchronized boolean asignarMemoria(ProcesoG proc){
        ArrayList<Integer> pagsAsignadas = new ArrayList<>();
        int pagsPedidas = proc.getNumPags();
        int i = 0;
        boolean res = true;
        while( i < paginas.length && pagsAsignadas.size() < pagsPedidas ){
            if( paginas[i] ){
                pagsAsignadas.add(i);
                paginas[i] = false;
            }
            i++;
        }
        if( pagsAsignadas.size() != pagsPedidas ){
            for (int pagIndice : pagsAsignadas)
                paginas[pagIndice] = true;
            res = false;
        }else{
            proc.setPaginasAsignadas(pagsAsignadas);
            //System.out.println(pagsAsignadas);
            System.out.println("[MemCen]: Paginas asignadas a " +proc.getNombre() + " : " + proc.getPaginasAsignadas().toString());
            Bitacora bitacora = new Bitacora("[MemCen]: Paginas asignadas a " +proc.getNombre() + " : " + proc.getPaginasAsignadas().toString());
            bitacora.writeLine();
        }
            

        return res;

    }

    public synchronized void liberarMemoria(ProcesoG proc){
        for (int indicePag : proc.getPaginasAsignadas()){
            paginas[indicePag] = true;
        }
        System.out.println("[MemCen]: Paginas liberadas de " + proc.getNombre() + " : " + proc.getPaginasAsignadas().toString());
        Bitacora bitacora = new Bitacora("[MemCen]: Paginas liberadas de " + proc.getNombre() + " : " + proc.getPaginasAsignadas().toString());
        bitacora.writeLine();
    }

}