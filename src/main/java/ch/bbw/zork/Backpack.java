package ch.bbw.zork;

import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> content;
    private int totalWeight;
    private int currentWeight;

    public Backpack(int totalWeight) {
        this.content = new ArrayList<Item>();
        this.totalWeight = totalWeight;
        this.currentWeight = 0;
    }

    public boolean addItem(Item item) {
        if (this.checkWeight(item)) {
            this.currentWeight = this.currentWeight + item.getWeight();
            this.content.add(item);
            return true;
        } else {
            return false;
        }
    }

    public void removeItem(int index) {
        int weight = this.content.get(index).getWeight();
        this.totalWeight = this.totalWeight - weight;
        this.content.remove(index);
    }

    public Item getItem(int index) {
        return this.content.get(index);
    }

    public void getContent() {
        for (int i = 0; i < this.content.size(); i ++) {
            System.out.println("\t" + i + ": " + this.content.get(i).getName() + ", " + this.content.get(i).getWeight());
        }
        System.out.println("Current Weight: " + this.currentWeight + "\tTotal Weight: " + this.totalWeight);
    }

    public boolean checkWeight(Item item) {
        if ((item.getWeight() + this.currentWeight) <= this.totalWeight) {
            return true;
        } else {
            return false;
        }
    }
}
