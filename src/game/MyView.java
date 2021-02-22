/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Handles the what the user can see the background and foreground.
 */
public class MyView extends UserView {

    Player player;
    private Image background;
    private Image background1;
    private Image background2;
    private Image heart;
    private Image star;
    Game game;

    public MyView(World world, Player player, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
        this.player = player;
        this.background = new ImageIcon("data/MK.png").getImage();
        this.background1 = new ImageIcon("data/bk1.jpg").getImage();
        this.background2 = new ImageIcon("data/bk2.jpg").getImage();
        heart = new ImageIcon("data/Heart1.gif").getImage();
        star = new ImageIcon("data/Star1.gif").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (game.getLevel() == 1) {
            g.drawImage(background, 0, 0, this);
        }
        if (game.getLevel() == 2) {
            g.drawImage(background1, 0, 0, this);
        }
        if (game.getLevel() == 3) {
            g.drawImage(background2, 0, 0, this);
        }
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.setColor(Color.red);
        g.drawString("LIVES:", 10, 32);
        for (int life = 0;;) {
            if (life >= player.getLifeCount()) {
                break;
            } else {
                life++;
            }
            g.drawImage(heart, life * 40 + 70, 5, this);
        }
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.setColor(Color.yellow);
        g.drawString("STARS:", 300, 32);
        for (int coin = 0;;) {
            if (coin >= player.getStarCount()) {
                break;
            } else {
                coin++;
            }
            g.drawImage(star, coin * 40 + 370, 5, this);
        }
    }

    @Override
    protected void paintForeground(Graphics2D g) {
    }
}
