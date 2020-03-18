import javax.swing.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(976,999);
        setLocation(200,0);

        add(new GameField());
        setVisible(true);
    }

    public class playSoundDemo extends JFrame {

        // конструктор
        public playSoundDemo(String sound) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Play Sound Demo");
            this.setSize(300, 200);
            this.setVisible(true);

            try {
                URL url = this.getClass().getResource(sound);
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }
}