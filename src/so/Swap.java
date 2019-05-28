package so;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Swap
 */
public class Swap {

    public PriorityQueue<ProcesoG> procesos;
    private int maxProcesos;

    public Swap( int maxProcesos ){
        this.maxProcesos = maxProcesos;
        procesos = new PriorityQueue<ProcesoG>();
    }

    public synchronized void push(ProcesoG p){
        System.out.println("[Swap]: Ingreso de " + p.getNombre());
        Bitacora bitacora = new Bitacora("[Swap]: Ingreso de " + p.getNombre());
        bitacora.writeLine();
        procesos.add(p);
    }

    public synchronized ProcesoG pop(){
        ProcesoG res = procesos.poll();
        //procesos.remove(res);
        System.out.println("[Swap]: Salida de " + res.getNombre());
        Bitacora bitacora = new Bitacora("[Swap]: Salida de " + res.getNombre());
        bitacora.writeLine();
        return res;
    }

    public synchronized boolean isEmpty(){
        return procesos.isEmpty();
    }

    public static void main(String[] args) {
        ProcesoG p1, p2, p3,p4;
        p1 = new ProcesoG("p1", 2, 1);
        p2 = new ProcesoG("p2", 2, 2);
        p3 = new ProcesoG("p3", 2, 4);
        p4 = new ProcesoG("p4", 2, 4);

        Swap s = new Swap(4);
        s.push(p2);
        s.push(p1);
        s.push(p3);
        s.push(p4);
        System.out.println(s.pop().getNombre());
        System.out.println(s.pop().getNombre());
        System.out.println(s.pop().getNombre());
        System.out.println(s.pop().getNombre());
    }
}