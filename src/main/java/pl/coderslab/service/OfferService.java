package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Room;
import pl.coderslab.model.Offer;

import java.util.ArrayList;
import java.util.List;

@Component
public class OfferService {
    public List<Offer> getOffers(List<Room> rooms, long days) {
        List<Offer> result = new ArrayList<>();
        for(Room r : rooms){
            result.add(new Offer(r, r.getRoomPrice() * days));
        }

        return result;
    }
}
