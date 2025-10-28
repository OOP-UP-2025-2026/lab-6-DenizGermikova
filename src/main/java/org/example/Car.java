package org.example;

class Car implements Comparable {
    private int price;
    private int year;
    private int horsePower;

    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getHorsePower() { return horsePower; }
    public void setHorsePower(int horsePower) { this.horsePower = horsePower; }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Car)) return 0;
        Car other = (Car) o;

        if (this.price != other.price)
            return this.price < other.price ? 1 : -1; // менша ціна = "більше"
        if (this.year != other.year)
            return this.year > other.year ? 1 : -1; // новіший = "більше"
        return Integer.compare(this.horsePower, other.horsePower);
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", year=" + year +
                ", horsePower=" + horsePower +
                '}';
    }
}
