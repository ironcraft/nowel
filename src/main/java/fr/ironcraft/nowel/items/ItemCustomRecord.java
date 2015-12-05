package fr.ironcraft.nowel.items;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import fr.ironcraft.nowel.Nowel;

public class ItemCustomRecord extends ItemRecord {

	public ItemCustomRecord(String name) {
		super(name);
	}

	@Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(Nowel.MODID + ":" + name);
    }
}
