import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class GameField extends JPanel implements ActionListener{
    private final int SIZE = 912;
    private final int DOT_SIZE = 48;
    private final int ALL_DOTS = 400;
    private Image dot;
    private Image tail;
    private Image apple;
    private Image border;
    private int appleX;
    private int counter;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;


    public GameField(){
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);

    }


    public void initGame(){
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 144 - i*DOT_SIZE;
            y[i] = 144;
        }
        timer = new Timer(200,this);
        timer.start();
        createApple();
    }



    public void createApple(){
        appleX = (new Random().nextInt(18)+1)*DOT_SIZE;
        appleY = (new Random().nextInt(18)+1)*DOT_SIZE;
        int i=1;
        while (i>0){
            for (i=dots; i >0 ; i--) {
                if(appleX == x[i] && appleY== y[i])
                    break;
            }
            if (i>0) {
                appleX = (new Random().nextInt(18) + 1) * DOT_SIZE;
                appleY = (new Random().nextInt(18) + 1) * DOT_SIZE;
            }
        }
    }

    public void loadImages(){

        ImageIcon iib = new ImageIcon("src/border.png");
        border = iib.getImage();
        ImageIcon iia = new ImageIcon("src/apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("src/dot.png");
        dot = iid.getImage();
        ImageIcon iit = new ImageIcon("src/tail.png");
        tail = iit.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 20; i++) {
            g.drawImage(border,i*DOT_SIZE,0,this);
            g.drawImage(border,0,i*DOT_SIZE,this);
            g.drawImage(border,i*DOT_SIZE, 19*DOT_SIZE,this);
            g.drawImage(border,19*DOT_SIZE,i*DOT_SIZE,this);
        }
        if(inGame){
            String str = "Score:"+counter;
            Font f = new Font("Arial",Font.BOLD,40);
            g.setColor(Color.white);
            g.setFont(f);
            g.drawString(str,700,42);

            g.drawImage(apple,appleX,appleY,this);
            g.drawImage(dot,x[0],y[0],this);
            for (int i = 1; i < dots; i++) {
                g.drawImage(tail,x[i],y[i],this);
            }
        } else{

            String str = "Game Over";
            Font f = new Font("Arial",Font.BOLD,45);
            g.setColor(Color.white);
            g.setFont(f);
            g.drawString(str,370,SIZE/2);

            String stre = "Score:"+counter;
            Font h = new Font("Arial",Font.BOLD,40);
            g.setColor(Color.white);
            g.setFont(h);
            g.drawString(stre,370,SIZE/2+50);
        }

    }
    
    public void move(){
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if(left){
            x[0] -= DOT_SIZE;
        }
        if(right){
            x[0] += DOT_SIZE;
        } if(up){
            y[0] -= DOT_SIZE;
        } if(down){
            y[0] += DOT_SIZE;
        }
    }

    public void checkApple(){
        if(x[0] == appleX && y[0] == appleY){
            dots++;
            counter++;
            createApple();
            try {
                URL url = this.getClass().getResource("sound1.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);

                clip.start();
            }
            catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkCollisions(){
        for (int i = dots; i >0 ; i--) {
            if(x[0] == x[i] && y[0] == y[i]){
                inGame = false;
            }
        }

        if(x[0]>=SIZE){
            inGame = false;
        }
        if(x[0]<=0){
            inGame = false;
        }
        if(y[0]>=SIZE){
            inGame = false;
        }
        if(y[0]<=0){
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollisions();
            move();

        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !right){
                left = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_RIGHT && !left){
                right = true;
                up = false;
                down = false;
            }

            if(key == KeyEvent.VK_UP && !down){
                right = false;
                up = true;
                left = false;
            }
            if(key == KeyEvent.VK_DOWN && !up){
                right = false;
                down = true;
                left = false;
            }
        }
    }


}