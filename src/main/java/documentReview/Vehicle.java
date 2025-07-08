package documentReview;

abstract class Vehicle {
    int speed;
    int capacity;

    abstract void startEngine();
    abstract void stopEngine();

    void displayDetails() {
        System.out.println("Speed: " + speed + ", Capacity: " + capacity);
    }
}

