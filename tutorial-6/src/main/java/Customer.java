import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Iterator<Rental> iterator = rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";

        while (iterator.hasNext()) {
            Rental each = iterator.next();
            double thisAmount = calculateAmount(each);

            // Add frequent renter points
            frequentRenterPoints++;

            // Add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1)
                frequentRenterPoints++;

            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";
        }

        // Add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

    private double calculateAmount(Rental rent) {
        // Determine amount for each line
        double amount = 0;
        switch (rent.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (rent.getDaysRented() > 2)
                    amount += (rent.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += rent.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                amount += 1.5;
                if (rent.getDaysRented() > 3)
                    amount += (rent.getDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
    }
}