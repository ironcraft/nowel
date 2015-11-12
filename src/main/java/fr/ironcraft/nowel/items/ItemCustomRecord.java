package fr.ironcraft.nowel.items;

import fr.ironcraft.nowel.Nowel;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

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
