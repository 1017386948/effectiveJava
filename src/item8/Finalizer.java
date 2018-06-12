package item8;

public class Finalizer {

	public Finalizer() {
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalizer invoking...");
	}

	public static void main(String[] args) {
		Finalizer f = new subClass();
		f = null;
		System.gc();

	}

	static class subClass extends Finalizer {
		@Override
		protected void finalize() throws Throwable {
			System.out.println("subclass finalizer...");
			super.finalize();
		}
	}
}
