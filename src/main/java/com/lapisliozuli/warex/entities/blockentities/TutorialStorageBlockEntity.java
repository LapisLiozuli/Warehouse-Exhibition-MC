package com.lapisliozuli.warex.entities.blockentities;

import com.lapisliozuli.warex.ImplementedInventory;
import com.lapisliozuli.warex.WareX;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;

public class TutorialStorageBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory {

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    // Store the current value of the number
    private int number = 7;

    public TutorialStorageBlockEntity() {
        super(WareX.TUTORIAL_STORAGE_ENTITY);
    }


    // Serialize the BlockEntity
    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        // Save the current value of the number to the tag
        Inventories.fromTag(tag,items);

        return tag;
    }

    // Deserialize the BlockEntity
    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        number = tag.getInt("number");
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        // Just return an array of all slots
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    // Cannot insert from the upper side of the block
    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
        return direction != Direction.UP;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return true;
    }
}