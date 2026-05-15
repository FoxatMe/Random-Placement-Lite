package dev.foxatme.placementlite.util.inventory;

import java.util.List;
import java.util.Random;

public class SlotContext {

    public final Random random = new Random();

    public final int[] history = new int[12];
    public int historyPtr = 0;

    public final int[] slotCount = new int[9];

    public int lastSlot = -1;
    public int repeatCount = 0;

    public List<Integer> slots;

    public void push(int slot) {

        history[historyPtr] = slot;
        historyPtr = (historyPtr + 1) % history.length;

        slotCount[slot]++;

        if (slot == lastSlot) {
            repeatCount++;
        } else {
            lastSlot = slot;
            repeatCount = 1;
        }
    }
}
