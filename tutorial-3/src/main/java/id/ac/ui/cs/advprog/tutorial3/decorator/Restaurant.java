package id.ac.ui.cs.advprog.tutorial3.decorator;

import id.ac.ui.cs.advprog.tutorial3.decorator.bread.BreadProducer;
import id.ac.ui.cs.advprog.tutorial3.decorator.filling.FillingDecorator;

public class Restaurant {
    public static void main(String[] args) {
        System.out.println("Welcome to the Restaurant!");

        Food thickBunSpecial = BreadProducer.THICK_BUN.createBreadToBeFilled();
        System.out.println(thickBunSpecial.getDescription() + " " + thickBunSpecial.cost());

        thickBunSpecial = FillingDecorator.BEEF_MEAT.addFillingToBread(thickBunSpecial);
        System.out.println(thickBunSpecial.getDescription() + " " + thickBunSpecial.cost());

        thickBunSpecial = FillingDecorator.CHEESE.addFillingToBread(thickBunSpecial);
        System.out.println(thickBunSpecial.getDescription() + " " + thickBunSpecial.cost());
    }
}