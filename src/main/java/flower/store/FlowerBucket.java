package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    /**
     * FlowerPacks.
     */
    private List<FlowerPack> flowerPacks = new ArrayList<FlowerPack>();

    /**
     * Add flower packs.
     *
     * @param flowerPack
     */
    public void add(final FlowerPack flowerPack) {
        this.flowerPacks.add(flowerPack);
    }

    /**
     * Getprice.
     *
     * @return int
     */
    public int getPrice() {
        int price = 0;
        for (FlowerPack pack : flowerPacks) {
            price += pack.getPrice();
        }
        return price;
    }

    /**
     * Check if desirable pack or not.
     *
     * @param flowerSpec
     * @return boolean
     */
    public boolean isDesirable(final FlowerSpec flowerSpec) {
        boolean flagType = false;
        for (FlowerPack pack : flowerPacks) {
            if (flowerSpec.getFlowersTypes().contains(pack.getType())) {
                flagType = true;
            }
        }
        if (!flagType) {
            return false;
        }
        boolean flagColor = false;
        for (FlowerPack pack : flowerPacks) {
            System.out.println(flowerSpec.getColor());
            System.out.println(pack.getColor());
            if (flowerSpec.getColor().equals(pack.getColor())) {
                flagColor = true;
            }
        }
        if (!flagColor) {
            return false;
        }
        int amount = 0;
        for (FlowerPack pack : flowerPacks) {
            amount += pack.getAmount();
        }
        return flowerSpec.getAmount() == amount;
    }
}
