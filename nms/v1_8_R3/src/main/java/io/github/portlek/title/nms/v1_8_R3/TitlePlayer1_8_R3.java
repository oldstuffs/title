package io.github.portlek.title.nms.v1_8_R3;

import io.github.portlek.title.api.ITitle;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TitlePlayer1_8_R3 implements ITitle {

    @NotNull
    private final Player player;

    public TitlePlayer1_8_R3(@NotNull Player player) {
        this.player = player;
    }

    public void sendTitle(@NotNull String title, @NotNull String subTitle, int fadeIn, int showTime, int fadeOut) {
        final CraftPlayer craftPlayer = (CraftPlayer) player;
        final EntityPlayer entityPlayer = craftPlayer.getHandle();

        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer
            .a("{\"text\": \"" + title + "\"}");

        IChatBaseComponent chatSubTitle = IChatBaseComponent.ChatSerializer
            .a("{\"text\": \"" + subTitle + "\"}");

        final Packet timePacket = new PacketPlayOutTitle(fadeIn, showTime, fadeOut);
        final Packet titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        final Packet subTitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatTitle);

        entityPlayer.playerConnection.sendPacket(titlePacket);
        entityPlayer.playerConnection.sendPacket(subTitlePacket);
        entityPlayer.playerConnection.sendPacket(timePacket);
    }

}
