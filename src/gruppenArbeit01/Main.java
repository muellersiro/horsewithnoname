/*
* Gruppenarbeit 01: Warenkorb
* Klasse 1o
* Müller, Siro; Tommasi Nicola
*
*/

package gruppenArbeit01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// create assortment
		Assortment assortment = new Assortment("CHF");

		// create shoppingCart
		ShoppingCart shoppingCart = new ShoppingCart("CHF");

		// initialize scanner and listen
		Scanner scanner = new Scanner(System.in);
		while (true) {
			shoppingCart.showContent();
			assortment.showProducts();

			// id (which product)
			System.out.println("\n" + "Welcher Artikel soll dem Warenkorb hinzugefügt werden (1,2,3 oder q für Ende)");
			String id = scanner.next();
			if (id.equals("q"))
				break;

			// select product from assortment
			int idInt = Collection.parseToInt(id);
			if (idInt == -1)
				break;
			Product assortmentItem = assortment.getProduct(idInt);

			if (assortmentItem == null) {
				System.out.println("Wähle ein Produkt, das es auch gibt!");
				break;
			}
			// quantity (how much)
			System.out.println("Wie viele Artikel " + assortmentItem.getItemName()
					+ " sollen hinzugefügt werden: (Zahl oder a für Abbrechen)");
			String quantity = scanner.next();
			if (quantity.equals("a"))
				break;

			// parse quantity to integer
			int quantityInt = Collection.parseToInt(quantity);
			if (quantityInt == -1)
				break;

			// check if already exists in shopping cart
			Product shoppingCartItem = shoppingCart.getProduct(idInt);
			if (shoppingCartItem != null) {
				// update item in shopping cart
				shoppingCart.updateItem(assortmentItem, shoppingCartItem, quantityInt);
			} else {
				// add item to shopping cart
				shoppingCart.addItem(assortmentItem, quantityInt);
			}
		}

		System.out.println("Ende");
		scanner.close();

	}

}
