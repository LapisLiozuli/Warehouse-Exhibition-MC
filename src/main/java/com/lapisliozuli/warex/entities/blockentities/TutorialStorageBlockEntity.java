package com.lapisliozuli.warex.entities.blockentities;

import com.lapisliozuli.warex.WareX;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;

public class TutorialStorageBlockEntity extends BlockEntity {
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
        tag.putInt("number", number);

        return tag;
    }

    // Deserialize the BlockEntity
    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        number = tag.getInt("number");
    }
}