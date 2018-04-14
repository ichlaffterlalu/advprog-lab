package id.ac.ui.cs.advprog.tutorial4.exercise1.factory;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.Cheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.KraftCheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.Clams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.HavenWhiteClams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.Dough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.NoCrustDough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.IndomieSeasoningSauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.Sauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.BlackOlives;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Capcay;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Garlic;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Mushroom;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Onion;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.RedPepper;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Veggies;

public class DepokPizzaIngredientFactory implements PizzaIngredientFactory {

    public Dough createDough() {
        return new NoCrustDough();
    }

    public Sauce createSauce() {
        return new IndomieSeasoningSauce();
    }

    public Cheese createCheese() {
        return new KraftCheese();
    }

    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Capcay(), new Garlic(), new Onion(), new Mushroom(),
            new RedPepper(), new BlackOlives()};
        return veggies;
    }

    public Clams createClam() {
        return new HavenWhiteClams();
    }
}
