package org.bukkit.craftbukkit;

import net.minecraft.world.EnumHand;
import net.minecraft.world.entity.EnumItemSlot;
import org.bukkit.inventory.EquipmentSlot;

public class CraftEquipmentSlot {

    private static final EnumItemSlot[] slots = new EnumItemSlot[EquipmentSlot.values().length];
    private static final EquipmentSlot[] enums = new EquipmentSlot[EnumItemSlot.values().length];

    static {
        set(EquipmentSlot.HAND, EnumItemSlot.MAINHAND);
        set(EquipmentSlot.OFF_HAND, EnumItemSlot.OFFHAND);
        set(EquipmentSlot.FEET, EnumItemSlot.FEET);
        set(EquipmentSlot.LEGS, EnumItemSlot.LEGS);
        set(EquipmentSlot.CHEST, EnumItemSlot.CHEST);
        set(EquipmentSlot.HEAD, EnumItemSlot.HEAD);
    }

    private static void set(EquipmentSlot type, EnumItemSlot value) {
        slots[type.ordinal()] = value;
        enums[value.ordinal()] = type;
    }

    public static EquipmentSlot getSlot(EnumItemSlot nms) {
        return enums[nms.ordinal()];
    }

    public static EnumItemSlot getNMS(EquipmentSlot slot) {
        return slots[slot.ordinal()];
    }

    public static EquipmentSlot getHand(EnumHand enumhand) {
        return (enumhand == EnumHand.MAIN_HAND) ? EquipmentSlot.HAND : EquipmentSlot.OFF_HAND;
    }

    public static EnumHand getHand(EquipmentSlot hand) {
        if (hand == EquipmentSlot.HAND) {
            return EnumHand.MAIN_HAND;
        } else if (hand == EquipmentSlot.OFF_HAND) {
            return EnumHand.OFF_HAND;
        }

        throw new IllegalArgumentException("EquipmentSlot." + hand + " is not a hand");
    }
}
