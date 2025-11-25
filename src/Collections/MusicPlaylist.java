package Collections;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MusicPlaylist {

    // LinkedList to store songs
    private LinkedList<String> playlist = new LinkedList<>();

    // Iterator to move through playlist
    private ListIterator<String> iterator = playlist.listIterator();

    // Track current song
    private String currentSong = null;

    // Add a song to playlist
    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added: " + song);

        // Reset iterator if first song
        iterator = playlist.listIterator();
        if (currentSong == null) {
            currentSong = iterator.next();
        }
    }

    // Play next song
    public void playNext() {
        if (iterator.hasNext()) {
            currentSong = iterator.next();
            System.out.println("Playing Next: " + currentSong);
        } else {
            System.out.println("No more songs ahead!");
        }
    }

    // Play previous song
    public void playPrevious() {
        if (iterator.hasPrevious()) {
            currentSong = iterator.previous();
            System.out.println("Playing Previous: " + currentSong);
        } else {
            System.out.println("No previous songs!");
        }
    }

    // Remove a song
    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed: " + song);

            // Re-adjust iterator after removal
            iterator = playlist.listIterator();

            currentSong = iterator.hasNext() ? iterator.next() : null;
        } else {
            System.out.println("Song not found!");
        }
    }

    // Display full playlist
    public void showPlaylist() {
        System.out.println("\n--- FULL PLAYLIST ---");
        for (String s : playlist) {
            System.out.println(s);
        }
        System.out.println("---------------------\n");
    }

    // MAIN PROGRAM MENU
    public static void main(String[] args) {
        MusicPlaylist mp = new MusicPlaylist();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MUSIC PLAYLIST MENU ===");
            System.out.println("1. Add Song");
            System.out.println("2. Play Next Song");
            System.out.println("3. Play Previous Song");
            System.out.println("4. Remove Song");
            System.out.println("5. Display Playlist");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Song Name: ");
                    String song = sc.nextLine();
                    mp.addSong(song);
                    break;

                case 2:
                    mp.playNext();
                    break;

                case 3:
                    mp.playPrevious();
                    break;

                case 4:
                    System.out.print("Enter Song to Remove: ");
                    String removeSong = sc.nextLine();
                    mp.removeSong(removeSong);
                    break;

                case 5:
                    mp.showPlaylist();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

