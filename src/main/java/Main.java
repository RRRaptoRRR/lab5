import collection.Movie;
import collection.MovieCollection;
import commands.CommandManager;
import console.Console;
import console.FileManager;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    // Lab5, variant 3117500
    public static void main(String[] args) {

        //printLogo();
        Scanner sc = new Scanner(System.in);

        FileManager fm = new FileManager();

        MovieCollection mc;
        if (args.length >= 1) {
            mc = new MovieCollection(fm, args[0]);
        } else {
            mc = new MovieCollection();
        }

        CommandManager cmm = new CommandManager(sc, mc, fm);

        Console.println("Type 'help' for display commands list.");
        Console console = new Console(sc, cmm);
        /*try {
            PriorityQueue<Movie> StartCollection = fm.readJsonFile("S://Итмо/Программирование/5лаба/lab5/external/db.json");
        }
        catch (IOException ex){
            console.
        }*/

        console.interactiveMode();
    }

    /*public static void printLogo() {
        Console.println(
                        "      ##    ###    ##     ##    ###    ##          ###    ########  ######## \n" +
                        "      ##   ## ##   ##     ##   ## ##   ##         ## ##   ##     ## ##       \n" +
                        "      ##  ##   ##  ##     ##  ##   ##  ##        ##   ##  ##     ## ##       \n" +
                        "      ## ##     ## ##     ## ##     ## ##       ##     ## ########  #######  \n" +
                        "##    ## #########  ##   ##  ######### ##       ######### ##     ##       ## \n" +
                        "##    ## ##     ##   ## ##   ##     ## ##       ##     ## ##     ## ##    ## \n" +
                        " ######  ##     ##    ###    ##     ## ######## ##     ## ########   ######  \n"
        );
    }*/
}
