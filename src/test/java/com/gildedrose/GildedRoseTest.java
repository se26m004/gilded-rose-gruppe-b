
package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void shouldDecreaseQualityByOneBeforeExpiration() {
        Item item = new Item("Normal Item", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void shouldDecreaseQualityByTwoAfterExpiration() {
        Item item = new Item("Normal Item", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void shouldNotDecreaseQualityBelowZero() {
        Item item = new Item("Normal Item", 10, 0);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(0, item.quality);
    }
    
    @Test
    void shouldIncreaseAgedBrieQualityBeforeExpiration() {
        Item item = new Item("Aged Brie", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void shouldIncreaseAgedBrieQualityTwiceAfterExpiration() {
        Item item = new Item("Aged Brie", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void shouldNotIncreaseAgedBrieQualityAboveFifty() {
        Item item = new Item("Aged Brie", 10, 50);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void shouldCapAgedBrieQualityAtFiftyAfterExpiration() {
        Item item = new Item("Aged Brie", 0, 49);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(50, item.quality);
    }
    
    @Test
    void shouldIncreaseBackstagePassQualityByOne() {
        Item item = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 15, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void shouldIncreaseBackstagePassQualityByTwo() {
        Item item = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void shouldIncreaseBackstagePassQualityByThree() {
        Item item = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 5, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    void shouldSetBackstagePassQualityToZeroAfterConcert() {
        Item item = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void shouldNotIncreaseBackstagePassQualityAboveFifty() {
        Item item = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 5, 49);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void shouldIncreaseBackstagePassQualityByOneAtElevenDays() {
        Item item = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 11, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(10, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void shouldIncreaseBackstagePassQualityByTwoAtSixDays() {
        Item item = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 6, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(5, item.sellIn);
        assertEquals(22, item.quality);
    }
    
    @Test
    void shouldNotChangeSulfurasBeforeExpiration() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(10, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void shouldNotChangeSulfurasAtExpiration() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void shouldNeverChangeSulfurasAfterMultipleUpdates() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 80);
        GildedRose app = new GildedRose(new Item[]{item});

        for (int day = 0; day < 10; day++) {
            app.updateQuality();
        }

        assertEquals(5, item.sellIn);
        assertEquals(80, item.quality);
    }
    
    @Test
    void shouldDecreaseConjuredQualityByTwoBeforeExpiration() {
        Item item = new Item("Conjured Mana Cake", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void shouldDecreaseConjuredQualityByFourAfterExpiration() {
        Item item = new Item("Conjured Mana Cake", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(16, item.quality);
    }

    @Test
    void shouldNotDecreaseConjuredQualityBelowZero() {
        Item item = new Item("Conjured Mana Cake", 10, 0);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void shouldCapConjuredQualityAtZeroAfterExpiration() {
        Item item = new Item("Conjured Mana Cake", 0, 3);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void shouldUpdateConjuredItemOverMultipleDays() {
        Item item = new Item("Conjured Mana Cake", 3, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        for (int day = 0; day < 3; day++) {
            app.updateQuality();
        }

        assertEquals(0, item.sellIn);
        assertEquals(4, item.quality);
    }
    
    @Test
    void shouldUpdateDifferentItemTypesInSameInventory() {
        Item normal = new Item("Normal Item", 10, 20);
        Item brie = new Item("Aged Brie", 10, 20);
        Item backstage = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 5, 20);
        Item sulfuras = new Item(
            "Sulfuras, Hand of Ragnaros", 10, 80);
        Item conjured = new Item("Conjured Mana Cake", 10, 20);

        Item[] items = {
            normal, brie, backstage, sulfuras, conjured
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, normal.sellIn);
        assertEquals(19, normal.quality);

        assertEquals(9, brie.sellIn);
        assertEquals(21, brie.quality);

        assertEquals(4, backstage.sellIn);
        assertEquals(23, backstage.quality);

        assertEquals(10, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);

        assertEquals(9, conjured.sellIn);
        assertEquals(18, conjured.quality);
    }
    @Test
    void shouldNotDecreaseExpiredNormalItemQualityBelowZero() {
        Item item = new Item("Normal Item", 0, 1);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void shouldDecreaseNormalItemQualityFasterAfterExpiration() {
        Item item = new Item("Normal Item", 1, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(0, item.sellIn);
        assertEquals(9, item.quality);

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(7, item.quality);
    }

    @Test
    void shouldIncreaseAgedBrieQualityFasterAfterExpiration() {
        Item item = new Item("Aged Brie", 1, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(0, item.sellIn);
        assertEquals(21, item.quality);

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    void shouldDropBackstagePassQualityToZeroWhenConcertExpires() {
        Item item = new Item(
            "Backstage passes to a TAFKAL80ETC concert", 1, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(0, item.sellIn);
        assertEquals(23, item.quality);

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void shouldDecreaseConjuredQualityFasterAfterExpiration() {
        Item item = new Item("Conjured Mana Cake", 1, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(0, item.sellIn);
        assertEquals(8, item.quality);

        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(4, item.quality);
    }
}
