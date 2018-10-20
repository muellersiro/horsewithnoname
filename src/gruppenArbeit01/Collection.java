/*
* Gruppenarbeit 01: Warenkorb
* Klasse 1o
* M�ller, Siro; Tommasi Nicola
*
*/
package gruppenArbeit01;

import java.util.ArrayList;

public class Collection {

	// product list
	protected ArrayList<Product> collection = new ArrayList<Product>();
	// same currency for all products
	protected String currency;

	public Collection(String currency) {
		super();
		this.currency = currency;
	}

	public void addProduct(Product item) {
		collection.add(item);
	}

	public Product getProduct(int id) {
		int exists = 0;
		Product item = null;
		for(int i = 0; i < collection.size(); i++) {
			item = collection.get(i);
			if (item.getId() == id) {
				exists = 1;
				break;
			}
        }
		if(exists == 0) {
			return null;
		}else {
			return item;
		}
	}

	public static int parseToInt(String input) {
		try {
			int parsedInt = Integer.parseInt(input);
			return parsedInt;
		} catch (NumberFormatException e) {
			System.out.println("Eingabe ist kein Integer");
			return -1;
		}

	}

}
