package parjun8840.product.ui;

import parjun8840.product.entity.Mobile;
import parjun8840.product.entity.Product;
import parjun8840.product.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
	
		Product[] products = new Product[5]; // Array of 5 Pointers
        products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED");// upcasting
        products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
        products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
        products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
        products[4] = new Mobile(844, "Oppo", 9999.00, "4G");
        // We can keep on adding the new products. Open For Change.
        print(products);
        checkExpensive(products);
	}

//Organize import- command + shift + o. OCP- Open for Change Principle
//checkExpensive method is 100% OCP but we haven't implemented checkExpensive method so super class method is called.
//Bcz of upcasting we are able to achieve 100% OCP.
	private static void checkExpensive(Product[] products) {
		for (Product p :  products) {
			if(p.isExpensive()) {
				System.out.println(p.getName()+" is expensive!!");
			}
			else {
				System.out.println(p.getName()+ " is not expensive!!");
			}
		}
		
	}

	// The below function is not OCP, everytime a new Product comes we have to edit here as well.
	private static void print(Product[] products) {
     for(Product p : products) {
         System.out.println(p.getName() + ", " + p.getPrice());
          if(p instanceof Mobile) {
              Mobile m = (Mobile) p; // downcasting
              System.out.println(m.getConnectivity());
          } else if (p.getClass().equals(Tv.class)) {
              Tv t = (Tv) p;
              System.out.println(t.getScreen());
          }
     }
 }
	
	

}


//instance of is use to check family of.
//getClass is precise checking.