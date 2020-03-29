package UzayOyunu_01;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // topları ve uzay mekiğini hareket ettirmek için interfaceyi implement ettik (actionPerform methodu)
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; // belli bir tuşa bastığımız zaman gerekli olacak methodları kullanmamızı sağlayan bir interfacedir
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.awt.Graphics;


/**
 * created by cicek on 12.03.2018 00:14
 */

public class Oyun extends JPanel implements KeyListener,ActionListener{ // klavye ve hareket özelliği

    // Timer kaç milisaniyede bir çalışacak // actionPerformed Timer üzerinde çalışacak
    // ActionListener interfacesini implemente eden bir tane objemizi göndermemiz gerekiyor
    // Jpanelimiz buradaki ActionListener'ı implement ettiği için biz buraya direkt bu objeyi vereceğiz. "Timer() kısmına".
    Timer timer = new Timer(5, this);


    // oyundaki değişkenler ve özellikler girilir
    private int gecen_sure = 0; // oyundaki geçen süreyi anlamak için
    private int harcanan_ates = 0;

    private BufferedImage image; // resmi nereden alacaksın? uzay gemisi fotosunu Jpanele yerleştiriyoruz.
                                 // BufferedImage classından image isminde nesne oluşturduk


    class Ates { // ateş sınıfı

        // x, y koordinatı olacak ve ateş her actionPerform çalıştığında 1 ileri gitmeye çalışacak
         private int x;
         private int y;

        public Ates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

    } // ateş sınıfı


     // atılan ateşleri tutmak için bir arraylist yazacağız (çok ateş atabilmek için)
    private ArrayList<Ates> atesler = new ArrayList<Ates>();

    // ateşler hep yukarı gideceği için her timer çalıştığında 1 ileri gitmesi gerek
    private int atesdirY = 1; // hareket edecek

    // sağa sola gitmeyi ayarlamak için (0,0) noktası
    private int topX = 0;

    private int topdirX = 2;

    // uzay gemimiz nereden başlayacak?
    private int uzayGemisiX = 0; // x koordinatı "0" olsun (alt sol)

    // sağa/sola bastığımızda uzayGemisiX'e dirUzayX ekleyeceğiz ve böylece 20 birim kayacak
    private int dirUzayX = 20; // tuşa basınca kaç birim gidecek

    public boolean kontrolEt() { // en az 1 ateş bu top ile çarpışırsa true döndür

        for (Ates ates : atesler) {

            // intersects = bir dik4gene çarptı mı?
            //  g.fillOval(topX, 0, 20, 20);
            if (new Rectangle(ates.getX(), ates.getY(), 10, 20).intersects(new Rectangle(new Rectangle(topX, 0, 20, 20))) ) {

                return true;
            }


        }
        return false;
    }


    public Oyun() {

        // image'ye uzaygemisi.png'yi atamamız gerek
        try {
            image = ImageIO.read(new FileImageInputStream(new File("uzaygemisi.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Jpanelin arkaplanı siyah yapmak
        setBackground(Color.BLACK);

        // oyun başladığında Timer'i çalıştırmak için
        timer.start();
        // Timer başladığı zaman her 5 milisaniyede bir actionPerformed methodu kendiliğinden çalışacak



    }




    @Override
    public void paint(Graphics g) {
        super.paint(g);

        gecen_sure += 5;


        g.setColor(Color.red);

        // her hareket ettiğimizde topX güncellenmiş olacak ve tekrar paint()'i çağırdığımız zaman toplar hareket etmiş olacak
        g.fillOval(topX, 0, 20, 20); // g.fillOval(topX, topX, WIDTH, HEIGHT); y'yi değiştirmeyeceğimiz için topX = 0 yazdık
        // daire şeklinde top oluşmuş olacak

        // image'yi grafik üzerinden çizmek istiyoruz
        g.drawImage(image, uzayGemisiX, 490, image.getWidth() / 2, image.getHeight() / 2, this);
        // nereden başlayacak --> uzayGemisiX (0,490)başlangıç,
        // image.getWidth() / 10 --> şu anki genişliği 10'a böl
        // Jpanelde oluşacağını da söylemeliyiz --> this


        // ateşleri çizmemiz gerek
        // Jframeden çıkan ateşleri direkt sileceğiz
        for (Ates ates : atesler) {

            if (ates.getY() < 0) { // ateş Jframe'den çıktıysa

                atesler.remove(ates);
            }

        }

        // ateş rengi
        g.setColor(Color.BLUE);

        // ateşlerimizi çiziyoruz
        for (Ates ates : atesler) {

            g.fillRect(ates.getX(), ates.getY(), 10, 20); // 10 x 20 lik dikdörtgen
        }

        if (kontrolEt()) { // true ise girecek

            timer.stop();
            String message = "Kazandınız...\n" +
                             "Harcanan ateş: " + harcanan_ates +
                             "\nGeçen süre: " + gecen_sure / 1000.0 +
                             " saniye";

            JOptionPane.showMessageDialog(this,message);

            System.exit(0); // oyun projesi sonlanmış olacak


        }


    }

    @Override
    public void repaint() { // repaint() çağırıldığında paint() te çağırılır
        super.repaint();
    }




    @Override
    public void keyTyped(KeyEvent e) { // KeyListener methodu


    }

    @Override
    public void keyPressed(KeyEvent e) { // KeyListener methodu

        // sağ ve sol tuşlarına basınca sağa ve sola gitmeyi ayarlayacağız

        int c = e.getKeyCode(); // getKeyCode() sola/sağa bastığımızda sola/sağa basıldığı değerini döndürecek

        // sola basılmışsa kontrolü
        if (c == KeyEvent.VK_LEFT){
            if (uzayGemisiX <= 0){ // bu kontrol olmazsa uzay gemisi frame'den çıkabilir

                uzayGemisiX = 0; // buradan sola gidemezsin diyoruz
            }
            else {

                uzayGemisiX -= dirUzayX; // 20 birim sola kaydırmak için
            }


        }

        // sağa basılmışsa kontrolü
        else if (c == KeyEvent.VK_RIGHT){
            if (uzayGemisiX >= 740){

                uzayGemisiX = 740; // buradan sağa gidemezsin diyoruz
            }

            else {

                uzayGemisiX += dirUzayX;
            }

        }

        else if (c == KeyEvent.VK_CONTROL){ // Ctrl tuşuna basılmışsa

            // atesler arraylistine ateşi eklemek isiyoruz
            atesler.add(new Ates(uzayGemisiX+26, 470)); // uzay geisi image'dan oluştuğu için +15 br sağa
                                                              // 490 da uzay gemisinin koordinatı(y)

            harcanan_ates++; // her ctrl'ye bastığımızda 1 artması gerekiyor

        }

    }

    @Override
    public void keyReleased(KeyEvent e) { // KeyListener methodu

    }

    @Override
    public void actionPerformed(ActionEvent e) { // ActionListener methodu
        // timer her çalıştığında objemiz yani Jpanelimiz üzerindeki bu method çalışacak
        // yukarıda bir timer tanımlanacak ve timer her çalıştığında ise burada 1 işlem olacak
        // topX'e topdirX'i eklemeye çalışacağız

        // ateşi yukarı hareket ettirmek
        for (Ates ates : atesler) {
            // actionPerformed her çalıştığında y değeri değişecek
            ates.setY(ates.getY() - atesdirY );
        }


        // her actionPerformed çalıştığı zaman topu nasıl hareket ettireceğiz?
        topX += topdirX;

        // top sınırdan çıkmışsa kontrol yapmamız gerekiyor. top belli bi seviyeye geldiğinde geriye gitmesi lazım
        if (topX >= 750 ){

            // 750. koordinat
            // topdirX'i - ile çarpmamız gerek (geri gitmesi için)
            // yukarıda toplayacağı için geriye gitmiş olacak
            topdirX = -topdirX;
        }

        // geriye gittiği zaman sıfırın dışına çıkmaması gerek
        if (topX <= 0){

            topdirX = -topdirX;
        }

        // her actionPerformed çalıştığında repaint()'i çalıştırmamız gerekecek
        // repaint() te otomatik olarak paint() methodunu çalıştıracak
        repaint();
    }

}
