package item3;

public abstract class RecursiveType<T extends RecursiveType<T>> {

	public abstract T get();
}
