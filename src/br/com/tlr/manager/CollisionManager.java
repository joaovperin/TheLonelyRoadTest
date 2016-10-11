/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.manager;

import br.com.tlr.elements.Player3;
import br.com.tlr.elements.SpacialElement;
import br.com.tlr.exception.CollisionException;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.geom.Shape;

/**
 * Objeto responsável pelo controle de colisões
 */
public class CollisionManager {

    /**
     * Lista de elementos
     */
    private final List<SpacialElement> elements = new ArrayList<>();

    /**
     * Adiciona um elemento na lista
     *
     * @param elm
     */
    public void add(SpacialElement elm) {
        elements.add(elm);
    }

    /**
     * Remove um elemento da lista (se possuir)
     *
     * @param elm
     */
    public void sub(SpacialElement elm) {
        if (elements.contains(elm)) {
            elements.remove(elm);
        }
    }

    /**
     * Retorna verdadeiro se há uma colisão com elementos da lista
     *
     * @param ch
     * @param a
     * @return boolean
     * @throws br.com.tlr.exception.CollisionException
     */
    public void checkForPlayerCollisions(Player3 player) throws CollisionException {
        for (SpacialElement elm : elements) {
            if (elm.isJustCheckFoot() && isColliding(elm.getBounding(), player.getPisando())) {
                throw new CollisionException(elm);
            }
        }
    }

    /**
     * Retorna verdadeiro se há uma colisão com elementos da lista
     *
     * @param a
     * @return boolean
     * @throws br.com.tlr.exception.CollisionException
     */
    public void checkForCollisions(SpacialElement a) throws CollisionException {
        for (SpacialElement elm : elements) {
            if (!elm.isJustCheckFoot() && isColliding(elm.getBounding(), a.getBounding())) {
                throw new CollisionException(elm);
            }
        }
    }

    /**
     * Retorna verdadeiro se os formatos colidem
     *
     * @param a
     * @param b
     * @return boolean
     */
    public boolean isColliding(Shape a, Shape b) {
        return a.intersects(b) || a.contains(b) || b.contains(a) || b.intersects(a);
    }

}
