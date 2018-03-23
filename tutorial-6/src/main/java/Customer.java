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
            double thisAmount = each.getCharge();
            frequentRenterPoints = each.getFrequentRenterPoints();

            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";
        }

        // Add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        Iterator<Rental> iterator = rentals.iterator();
        String result = "<h1>Rentals for <em>" + getName() + "</em></h1><p>\n";

        while (iterator.hasNext()) {
            Rental each = iterator.next();
            result += each.getMovie().getTitle() + ": " +
                    String.valueOf(each.getCharge()) + "<br>\n";
        }
        result +=  "<p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em><p>\n";
        result += "On this rental you earned <em>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</em> frequent renter points<p>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental each = iterator.next();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental each = iterator.next();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}