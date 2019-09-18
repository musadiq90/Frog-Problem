package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Frog_Problem {

    public interface Function1<R, T1> {

        R invoke(T1 argument1);
    }

    public interface Procedure1<T1> {

        void invoke(T1 argument1);
    }

    public static <T> void dump(T node, Function1<List<T>, T> breeder,
                                Function1<String, T> stringizer, Procedure1<String> emitter) {
        emitter.invoke(stringizer.invoke(node));
        dumpRecursive(node, "", breeder, stringizer, emitter);
    }

    private static final String[][] PREFIXES = {{" ├─ ", " │  "}, {" └─ ", "    "}};

    private static <T> void dumpRecursive(T node, String parentPrefix,
                                          Function1<List<T>, T> breeder, Function1<String, T> stringizer,
                                          Procedure1<String> emitter) {
        for (Iterator<T> iterator = breeder.invoke(node).iterator(); iterator.hasNext();) {
            T childNode = iterator.next();
            String[] prefixes = PREFIXES[iterator.hasNext() ? 0 : 1];
            emitter.invoke(parentPrefix + prefixes[0] + stringizer.invoke(childNode));
            dumpRecursive(childNode, parentPrefix + prefixes[1], breeder, stringizer, emitter);
        }
    }

    public static void main(String[] args) {
        //tree printing code taken from internet
        treeClass a = new treeClass();
        a.populate(a.root);
        a.traversetree(a.root);
        System.out.println("Total Number of Nodes are: " + a.count);

        a.fast(a.fastest);
        a.tra(a.root);
        System.out.println("Printing tree");
        dump( a.root, n -> n.child, n -> Arrays.toString(n.arr), s -> System.out.println( s ) );
    }
}
