package console;

import collection.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * Class work with json files, convert from json and convert to json
 */
public class JsonParser {
    private final Gson gson;

    public JsonParser() {
        this.gson = new Gson();
    }

    public String toJson(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter());
        Gson gso = gsonBuilder.setPrettyPrinting().create();
        return gso.toJson(obj);
    }

    public PriorityQueue<Movie> jsonToCollection(String text) throws JsonSyntaxException {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter());
        Gson gso = gsonBuilder.setPrettyPrinting().create();
        return gso.fromJson(text, new TypeToken<PriorityQueue<Movie>>(){}.getType());
        //return gson.fromJson(text, new TypeToken<PriorityQueue<Movie>>(){}.getType());
    }
}
