package com.gildedrose;

public class BackstagePassUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        item.sellIn = item.sellIn - 1;

        if (item.quality < 50) {
            item.quality = item.quality + 1;
            
            if (item.sellIn < 10) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
            if (item.sellIn < 5) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}