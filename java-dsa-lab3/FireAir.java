import java.util.Scanner;

public class FireAir {
    private String[] songs;
    private int size, capacity;
    
    public FireAir(int capacity) {
        this.capacity = capacity;
        this.songs = new String[capacity];
        this.size = 0;
    }
    
    // Display all songs
    public void printAllSongs() {
        if (size == 0) {
            System.out.println("No songs in playlist!");
            return;
        }
        
        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "] " + songs[i]);
        }
    }
    
    // Add new song
    public void addSong(String songName) {
        if (size >= capacity) {
            System.out.println("Playlist is full!");
            return;
        }
        
        songs[size] = songName;
        size++;
        System.out.println("Song added: " + songName);
    }
    
    // Delete song by index
    public void deleteSong(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid song number!");
            return;
        }
        
        String deletedSong = songs[index];
        
        for (int i = index; i < size - 1; i++) {
            songs[i] = songs[i + 1];
        }
        
        size--;
        System.out.println("Deleted: " + deletedSong);
    }
    
    // Search by index
    public void searchByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid song number!");
            return;
        }
        
        System.out.println("Song [" + index + "]: " + songs[index]);
    }
    
    // Search by name
    public void searchByName(String songName) {
        for (int i = 0; i < size; i++) {
            if (songs[i].equalsIgnoreCase(songName)) {
                System.out.println("Found: " + songs[i] + " at [" + i + "]");
                return;
            }
        }
        System.out.println("Song not found!");
    }
    
    // Update song
    public void updateSong(int index, String newSongName) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid song number!");
            return;
        }
        
        songs[index] = newSongName;
        System.out.println("Song updated at [" + index + "]: " + newSongName);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FireAir app = new FireAir(10);
        
        // Pre-load some popular songs
        app.addSong("Blinding Lights");
        app.addSong("Shape of You");
        app.addSong("Bohemian Rhapsody");
        app.addSong("Someone Like You");
        app.addSong("Despacito");
        
        System.out.println("🎵 FireAir Music App - Pre-loaded with 5 songs!");
        app.printAllSongs();
        
        while (true) {
            System.out.println("\n1.Show All 2.Add 3.Delete 4.Search by Index 5.Search by Name 6.Update 0.Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    app.printAllSongs();
                    break;
                case 2:
                    System.out.print("Song name: ");
                    app.addSong(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Song number: ");
                    app.deleteSong(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Song number: ");
                    app.searchByIndex(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Song name: ");
                    app.searchByName(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Song number: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New song name: ");
                    app.updateSong(index, sc.nextLine());
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}