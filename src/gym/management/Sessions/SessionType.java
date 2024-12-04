package gym.management.Sessions;

public enum SessionType {
    MachinePilates(10,80) , ThaiBoxing(20,100)
    , Ninja(5,150) , Pilates(30,60);
    private int capacity;
    private int price;

    private SessionType(int capacity, int price) {
        this.capacity = capacity;
        this.price = price;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
