package pl.coderslab.model;

import pl.coderslab.entity.Room;

public class Offer {
    private Room room;
    private float price;

    public Offer(Room room, float price) {
        this.room = room;
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
