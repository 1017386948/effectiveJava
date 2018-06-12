package item3;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import item3.NyPizza.Size;

public abstract class Pizza {
	public enum Topping {
		HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
	}
	final Set<Topping> toppings;
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		abstract Pizza build();
		// Subclasses must override this method to return "this"
		protected abstract T self();
	}
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone(); // See Item 50
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "\ntoppings:" + toppings;
	}

	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(Size.LARGE).addTopping(Topping.MUSHROOM)
				.addTopping(Topping.SAUSAGE).build();
		System.out.println(pizza);

		Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();
		System.out.println(calzone);
	}
}
