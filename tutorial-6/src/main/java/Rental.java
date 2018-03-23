class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        // Determine amount for each line
        double amount = 0;
        switch (this.movie.getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (this.getDaysRented() > 2)
                    amount += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += this.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                amount += 1.5;
                if (this.getDaysRented() > 3)
                    amount += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
    }

    public int getFrequentRenterPoints(int frequentRenterPoints) {
        // Add frequent renter points
        frequentRenterPoints++;

        // Add bonus for a two day new release rental
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                this.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}