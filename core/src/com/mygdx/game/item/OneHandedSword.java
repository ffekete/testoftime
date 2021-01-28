package com.mygdx.game.item;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.actor.AbstractActor;
import com.mygdx.game.graph.AtlasUnpacker;

public class OneHandedSword extends Equipment {

    private TextureRegion textureRegion;

    public OneHandedSword() {
        super(null, null, null);
    }

    public OneHandedSword(String name, String id, String description) {
        super(name, id, description);
        this.textureRegion = AtlasUnpacker.I.atlas.findRegion(String.format("items/weapons/%s", id));
    }

    @Override
    public Item cloneItem() {
        return new OneHandedSword(this.name, this.id, this.description);
    }

    @Override
    public void draw(SpriteBatch batch, AbstractActor actor, float xOffset, float yOffset, boolean flip) {
        switch (actor.state) {

            case Idle:
            case Walking:
                batch.setColor(Color.WHITE);
                float calculatedXOffset = (flip ? -1 : 1) * (textureRegion.getRegionWidth() / 4f);
                float calculatedYOffset = (actor.getCharacterAnimation().meta.height / 5f);
                batch.draw(textureRegion.getTexture(), actor.x + calculatedXOffset + xOffset, actor.y + calculatedYOffset + yOffset, 0, 0, textureRegion.getRegionWidth(), textureRegion.getRegionHeight(), 1, 1, 0, textureRegion.getRegionX(), textureRegion.getRegionY(), textureRegion.getRegionWidth(), textureRegion.getRegionHeight(), flip, false);
                break;
            case Attacking:

                break;
            case Dead:

                break;
            default:

        }
    }
}
