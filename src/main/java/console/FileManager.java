package console;

import collection.MovieCollection;
import collection.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class operates with files
 */
public class FileManager {
    private final JsonParser jp;

    public FileManager() {
        this.jp = new JsonParser();
    }

    /**
     * Write MovieCollection to file in json format
     * @param path path to writing file
     * @param mc movie collection that write to file
     */
    public void writeToJsonFile(String path, MovieCollection mc) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(path);
        String str="";
        PriorityQueue<Movie> pq = mc.getPQ();
       /* for (int i=0; i<= pq.size(); i++){
            Movie movie=pq.poll();
            //str += movie.toString();
            //str +=jp.toJson(pq.poll(), );
        }*/
        pw.println(jp.toJson(mc.getPQ()));
        //pw.println(jp.toJson(str));
        pw.close();
    }

    /**
     * import PriorityQueue of Movies from json file
     * @param path path to database file
     * @return PriorityQueue of Movies
     * @throws IOException raise if data file not found
     */
    public PriorityQueue<Movie> readJsonFile(String path) throws IOException {
        String text = readFile(path);
        return jp.jsonToCollection(text);
    }

    /**
     * Read file to string
     * @param path path to file
     * @return String of file content
     * @throws IOException raise if file not found
     */
    public String readFile(String path) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) sb.append(line);
        return sb.toString();
    }

    /**
     * Read file to Queue
     * @param path path to file
     * @return Queue of String (each row - element)
     * @throws IOException raise if file not found
     */
    public Queue<String> readCommandFile(String path) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        Queue<String> q = new ArrayDeque<>();

        String line;
        while ((line = br.readLine()) != null) q.add(line);
        return q;
    }
}
