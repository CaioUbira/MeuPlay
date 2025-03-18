
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

public class Musicamp3 extends Thread {

    File mp3;
    Player player;

    public void iniciar() {
        try {
            FileInputStream fis = new FileInputStream(mp3);
            BufferedInputStream bis = new BufferedInputStream(fis);
            this.player = new Player(bis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
        new Thread() {
            public void run() {
                try {
                    player.play();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Erro");
                }
            }
        }.start();
    }
}
