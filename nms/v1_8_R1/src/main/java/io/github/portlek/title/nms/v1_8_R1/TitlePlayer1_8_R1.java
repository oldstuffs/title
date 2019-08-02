package io.github.portlek.title.nms.v1_8_R1;

import io.github.portlek.title.api.ITitle;
import net.minecraft.server.v1_8_R1.*;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TitlePlayer1_8_R1 implements ITitle {

    @NotNull
    private final Player player;

    public TitlePlayer1_8_R1(@NotNull Player player) {
        this.player = player;
    }

    public void sendTitle(@NotNull String title, @NotNull String subTitle, int fadeIn, int showTime, int fadeOut) {
        final CraftPlayer craftPlayer = (CraftPlayer) player;
        final EntityPlayer entityPlayer = craftPlayer.getHandle();

        IChatBaseComponent chatTitle = ChatSerializer
            .a("{\"text\": \"" + title + "\"}");

        IChatBaseComponent chatSubTitle = ChatSerializer
            .a("{\"text\": \"" + subTitle + "\"}");

        final Packet timePacket = new PacketPlayOutTitle(fadeIn, showTime, fadeOut);
        final Packet titlePacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
        final Packet subTitlePacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, chatTitle);

        entityPlayer.playerConnection.sendPacket(titlePacket);
        entityPlayer.playerConnection.sendPacket(subTitlePacket);
        entityPlayer.playerConnection.sendPacket(timePacket);
    }

}
