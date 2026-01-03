package Hashing.Questions;

import java.util.HashMap;

public class Itinerary {
    public static  String getStart(HashMap<String, String> tick){
        HashMap<String, String > reverse = new HashMap<>();
        for(String key : tick.keySet()){
            reverse.put(tick.get(key), key);
        }

        for(String key : tick.keySet()){
            if(!reverse.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    private static void itineryFromTickets(HashMap<String, String> ticket) {
        HashMap<String , String> reverse = new HashMap<>();
        String start = getStart(ticket);
        while(ticket.containsKey(start)){
            System.out.print(start + "->");
            start = ticket.get(start);
        }

        System.out.print(start);
    }
    public static void main(String[] args) {
        HashMap<String , String > path = new HashMap<>();
        path.put("Chennai", "Bengaluru");
        path.put("Mumbai", "Delhi");
        path.put("Goa", "Chennai");
        path.put("Delhi", "Goa");

        itineryFromTickets(path);
    }


}
