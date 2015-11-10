package fr.ironcraft.nowel.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by adrien on 10/11/15.
 */
public class SantaHat extends Item {

    @Override
    public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
    {
        if(armorType == 0)
            return true;
        return false;
    }

}
