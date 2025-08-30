import java.util.ArrayList;
import java.util.Scanner;

class FireAir {
    private ArrayList<String> songs = new ArrayList<>();

    // Print all songs
    public void printSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the list.");
            return;
        }
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i+1) + ". " + songs.get(i));
        }
    }

    // Add song at position (start, middle, end)
    public void addSong(String song, int pos) {
        if (pos < 0 || pos > songs.size()) {
            System.out.println("Invalid position!");
            return;
        }
        songs.add(pos, song);
        System.out.println(song + " added at position " + (pos+1));
    }

    // Delete song
    public void deleteSong(int pos) {
        if (pos < 0 || pos >= songs.size()) {
            System.out.println("Invalid position!");
            return;
        }
        String removed = songs.remove(pos);
        System.out.println(removed + " deleted from position " + (pos+1));
    }

    // Search song
    public void searchSong(String song) {
        int index = songs.indexOf(song);
        if (index != -1) {
            System.out.println(song + " found at position " + (index+1));
        } else {
            System.out.println(song + " not found.");
        }
    }

    // Main function (Demo)
    public static void main(String[] args) {
        FireAir app = new FireAir();

        // Adding songs
        app.addSong("Shape of You", 0); // start
        app.addSong("Despacito", 1);    // end
        app.addSong("Faded", 1);        // middle

        System.out.println("\nCurrent Songs:");
        app.printSongs();

        // Searching
        app.searchSong("Faded");
        app.searchSong("Alone");

        // Deleting
        app.deleteSong(0); // delete first
        app.deleteSong(1); // delete middle/end

        System.out.println("\nAfter Deletions:");
        app.printSongs();
    }
}