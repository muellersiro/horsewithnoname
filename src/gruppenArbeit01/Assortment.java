/*
* Gruppenarbeit 01: Warenkorb
* Klasse 1o
* Müller, Siro; Tommasi Nicola
*
*/

package gruppenArbeit01;

public class Assortment extends Collection {

	public Assortment(String currency) {
		super(currency);
		
		// create products for assortment
		Product pr1 = new Product(1, "Walliser Roggenbrot", 4.10f, 2.5f);
		Product pr2 = new Product(2, "Engadiner Nusstorte", 12.90f, 7.0f);
		Product pr3 = new Product(3, "Langatun Whiskey OLD BEAR", 225.00f, 7.0f);

		// add products to assortment
		this.addProduct(pr1);
		this.addProduct(pr2);
		this.addProduct(pr3);
}
	
	public void showProducts() {
		System.out.println("------------------------");
		System.out.println("Verfügbare Artikel:" + "\n");
		for (Product item : collection) {
			// output id
			System.out.printf("%1$2d) ", item.getId());
			// output item name (max length 30 to be displayed properly)
			System.out.printf("%1$-30s ", item.getItemName());
			// output item price (max 999.99 to be displayed properly)
			System.out.printf("%1$6.2f ", item.getPrice());
			// output currency
			System.out.printf("%s", this.currency);
			// output MwSt (max 999.99 to be displayed properly)
			String outputMwst = "(" + String.format("%1$.2f", item.getMwst()) + ")";
			System.out.printf("%1$12s ", outputMwst);
			// output currency
			System.out.printf("%s", this.currency);
			// output line break
			System.out.print("\n");
		}
		System.out.println("------------------------");
	}

}
