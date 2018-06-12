package item3;

public class RecursiveSubType extends RecursiveType<RecursiveSubType> {

	@Override
	public RecursiveSubType get() {
		return this;
	}

	public enum PersonMapping implements Runnable {

		student(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end");
			}
		});
		Runnable r;
		PersonMapping(Runnable r) {
			this.r = r;
		}

		@Override
		public void run() {
			new Thread(r).start();
		}

	}

	public static void main(String[] args) {
		PersonMapping.student.run();
	}

}
