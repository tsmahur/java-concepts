package com.multiThreading;

public class SynchronizationNeed {
    public static void main(String[] args) {
        Product product = new Product("Mobile", 1);//one product passed for purchase by multiple thread

        //initiated by user1
        ProductBuyThread pt1 = new ProductBuyThread(product); //new Thread(() -> obj.printTable(5), "thread1");
        pt1.start();

        //initiated by user1 for product
        ProductBuyThread pt2 = new ProductBuyThread(product);
//        pt1.start();
        pt2.start();

        //try commenting and uncommenting the purchase() line

//        wait(3000);
    }

}
class ProductBuyThread extends Thread {
    Product p;

    ProductBuyThread(Product p) {
        this.p = p;
    }
    @Override
    public void run() {
        p.purchase();
    }
}
class Product {
    String name;
    int quantity;
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public synchronized void purchase() {
//    public void purchase() {
        try {
            if(this.quantity - 1 < 0) throw new Exception("No product in Stock");

            System.out.println("Purchase done!");
            this.quantity -= 1;
            System.out.println("Remaining: " + this.quantity);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



