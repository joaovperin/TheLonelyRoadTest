/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import static br.com.tlr.factory.AnimationFactory.SPRITES_DIR;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Descrição da classe.
 */
public class Heart extends Movable implements Animable {

    /** Heart */
    private Animation heart;
    /** Nome da animaçao */
    private final String animationName = "oie_transparent.png";;
    /** Direção de movimentação */
    private boolean isAlive;

    public Heart() {
        this(50, 50);
    }

    public Heart(int wid, int hei) {
        this(wid, hei, 0, 0);
    }

    public Heart(float wid, float hei, float x, float y) {
        super(wid, hei, null);
        setX(x);
        setY(y);
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public void load(GameContainer container) throws SlickException {
        // Carrega sprites para as animações de movimentos
        Image[] imgs = new Image[1];
        imgs[0] = new Image(SPRITES_DIR + animationName);
        heart = new Animation(imgs, 1);
//        SpriteSheet sheet = new SpriteSheet(SPRITES_DIR + animationName, 32, 24);
        // Carrega frames de animação do character da spritesheet
//        heart = new Animation(sheet, 0, 0, 0, 0, true, 100, true);
        isAlive = true;
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        if (isAlive) {
            heart.draw(getX(), getY());
        }
    }

}
