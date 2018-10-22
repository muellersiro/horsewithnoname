/*
* Gruppenarbeit 01: Warenkorb
* Klasse 1o
* Müller, Siro; Tommasi Nicola
*
*/

package gruppenArbeit01;

public class ShoppingCart extends Collection {

	public ShoppingCart(String currency) {
		super(currency);

	}

	public void addItem(Product assortmentItem, int quantity) {
		assortmentItem.setQuantity(quantity);
		this.addProduct(assortmentItem);
	}

	public void updateItem(Product assortmentItem, Product shoppingCartItem, int quantity) {
		assortmentItem.setQuantity(shoppingCartItem.getQuantity() + quantity);
		assortmentItem.setPrice(shoppingCartItem.getPrice() + assortmentItem.getPrice());
		Product item = null;
		int i =0;
		for(i = 0; i < collection.size(); i++) {
			item = collection.get(i);
			if (item.getId() == assortmentItem.getId()) {
				break;
			}
        }		
		collection.set(i, assortmentItem);
	}

	public void showContent() {
		System.out.println("------------------------------------------------------------");
		float gesPrice = 0f;
		float gesMwst = 0f;
		float gesMwstRate = 0f;
		if (this.collection.size() > 0) {
			System.out.println("Ihr Warenkorb:");
			for (Product item : collection) {
				float price = item.getPrice() * item.getQuantity();
				float mwst = price  - (price / ((item.getMwstrate() / 100) + 1));
				
				// output sum for each product individually
				
				// output quantity (max 99)
				System.out.printf("%1$2d ", item.getQuantity());
				// output name
				// output item name (max length 30 to be displayed properly)
				System.out.printf("%1$-30s ", item.getItemName());
				// output item price (max 999.99 to be displayed properly)
				System.out.printf("%1$6.2f ", item.getPrice());
				// output currency
				System.out.printf("%s", this.currency);
				// output total price (max 999.99 to be displayed properly)
				System.out.printf("%1$6.2f ", price);
				// output currency
				System.out.printf("%s", this.currency);
				// output line break
				System.out.print("\n");
				
				gesPrice += price;
				gesMwst += mwst;
			}
			
			// calculate total mwst rate
			gesMwstRate = 100 * (gesMwst / (gesPrice - gesMwst));
			
			// output text
			System.out.print("\n Der Gesamtpreis von ");
			// total price
			System.out.printf("%1$6.2f ", gesPrice);
			// output currency
			System.out.printf("%s", this.currency);
			// output contains text
			System.out.print(" enthält ");
			// output total mwst
			System.out.printf("%1$6.2f ", gesMwst);
			// output currency
			System.out.printf("%s", this.currency);
			// output Mwst rate text
			System.out.print(" Mwst (");
			// output total mwst rate
			System.out.printf("%1$.2f ", gesMwstRate);
			// output % sign and closing )
			System.out.print("%)\n");
			
			
		} else {
			System.out.println("Ihr Warenkorb ist leer.");
		}

	}

}
