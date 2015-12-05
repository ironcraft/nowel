package fr.ironcraft.nowel;


import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import fr.ironcraft.nowel.container.ContainerPresentCreation;


public class PresentCreationMessage implements IMessage
{
	public static class Handler implements IMessageHandler<PresentCreationMessage, PresentCreationMessage>
	{
		public Handler()
		{
			
		}
		
		@Override
		public PresentCreationMessage onMessage(PresentCreationMessage message, MessageContext ctx)
		{
			EntityPlayer player = ctx.getServerHandler().playerEntity;
			
			if (player.openContainer instanceof ContainerPresentCreation)
			{
				ContainerPresentCreation presentContainer = (ContainerPresentCreation) player.openContainer;
				
				presentContainer.onValidate(message.receiverName, player);
			}
			
			return null;
		}
	}

	private String receiverName;
	
	public PresentCreationMessage()
	{
		
	}
	
	public PresentCreationMessage(String name)
	{
		receiverName = name;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		receiverName = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, receiverName);
	}
}
