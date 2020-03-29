package UzayOyunu_01;

import javax.swing.JFrame;
import java.awt.*;

/**
 * created by cicek on 12.03.2018 00:05
 */

public class OyunEkrani extends JFrame{

    public OyunEkrani(String title) throws HeadlessException{
        super(title);
    }

    public static void main (String[] args){

        OyunEkrani ekran = new OyunEkrani("Uzay Oyunu");
        ekran.setResizable(false);
        ekran.setFocusable(false); // Jframeye değil Jpanele odaklanacak

        ekran.setSize(800,600);

        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /////////////// fonksiyon sıralaması önem arzeder

        Oyun oyun = new Oyun();

        oyun.requestFocus(); // Jpanelin klavye işlemlerini anlaması için bana odağı ver    (1-focus'u iste)

        oyun.addKeyListener(oyun); // interface klavye üzerindeki işlemleri almamızı sağlar (2-keyListener ekle)
                                   // KeyListener'ı implement edeceğiz
                                   // KeyListener cinsinden referans --> oyun'u keyListenerdan implement ettiğimiz için (oyun) yazılır
                                   // ve keyListener sadece ve sadece Jpanel üzerinde çalışacak

        oyun.setFocusable(true); // Jpanele odaklandı                                       (3-şimdi focusla)
        oyun.setFocusTraversalKeysEnabled(false); // jPanelin klavye işlemlerini anlaması için gerekli bir method
                                                  // false dedik ki klavye işlemleri gerçekleşebilsin

        // Jpaneli ekranımıza ekliyoruz

        ekran.add(oyun); // Jpaneli Jframeye eklemiş olduk

        ekran.setVisible(true); // Jframemiz jPanele eklendiği zaman direkt oluşsun

    }

}
