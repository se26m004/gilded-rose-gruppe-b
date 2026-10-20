package com.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        item.sellIn = item.sellIn - 1;

        decreaseQuality(item, 2);

        if (item.sellIn < 0) {
            decreaseQuality(item, 2);
        }
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = item.quality - amount;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}