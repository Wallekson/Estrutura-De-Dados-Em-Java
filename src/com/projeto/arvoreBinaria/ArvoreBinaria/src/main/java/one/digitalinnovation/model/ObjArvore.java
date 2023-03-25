package one.digitalinnovation.model;

public abstract class ObjArvore<T> implements Comparable<T> {

    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int comparable(T outro);
    public abstract String toString();

}
