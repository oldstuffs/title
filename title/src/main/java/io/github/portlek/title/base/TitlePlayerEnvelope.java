package io.github.portlek.title.base;

import io.github.portlek.title.api.ITitle;
import io.github.portlek.title.api.MckTitle;
import io.github.portlek.title.api.TitlePlayer;
import io.github.portlek.title.nms.v1_10_R1.TitlePlayer1_10_R1;
import io.github.portlek.title.nms.v1_11_R1.TitlePlayer1_11_R1;
import io.github.portlek.title.nms.v1_12_R1.TitlePlayer1_12_R1;
import io.github.portlek.title.nms.v1_13_R1.TitlePlayer1_13_R1;
import io.github.portlek.title.nms.v1_13_R2.TitlePlayer1_13_R2;
import io.github.portlek.title.nms.v1_14_R1.TitlePlayer1_14_R1;
import io.github.portlek.title.nms.v1_15_R1.TitlePlayer1_15_R1;
import io.github.portlek.title.nms.v1_8_R1.TitlePlayer1_8_R1;
import io.github.portlek.title.nms.v1_8_R2.TitlePlayer1_8_R2;
import io.github.portlek.title.nms.v1_8_R3.TitlePlayer1_8_R3;
import io.github.portlek.title.nms.v1_9_R1.TitlePlayer1_9_R1;
import io.github.portlek.title.nms.v1_9_R2.TitlePlayer1_9_R2;
import io.github.portlek.versionmatched.VersionMatched;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class TitlePlayerEnvelope implements TitlePlayer {

    @NotNull
    private final ITitle title;

    TitlePlayerEnvelope(@NotNull final Player player) {
        this.title = new VersionMatched<>(
            new MckTitle(),
            TitlePlayer1_15_R1.class,
            TitlePlayer1_14_R1.class,
            TitlePlayer1_13_R2.class,
            TitlePlayer1_13_R1.class,
            TitlePlayer1_12_R1.class,
            TitlePlayer1_11_R1.class,
            TitlePlayer1_10_R1.class,
            TitlePlayer1_9_R2.class,
            TitlePlayer1_9_R1.class,
            TitlePlayer1_8_R3.class,
            TitlePlayer1_8_R2.class,
            TitlePlayer1_8_R1.class
        ).of(Player.class).instance(player);
    }

    @Override
    public void clearTitle() {
        title.sendTitle("","", 0, 0, 0);
    }

    @Override
    public void sendTitle(@NotNull String title) {
        this.title.sendTitle(title,"", 20, 20, 20);
    }

    @Override
    public void sendTitle(@NotNull String title, @NotNull String subTitle) {
        this.title.sendTitle(title,subTitle, 20, 20, 20);
    }

    @Override
    public void sendTitle(@NotNull String title, int fadeIn, int showTime, int fadeOut) {
        this.title.sendTitle(title, "", fadeIn, showTime, fadeOut);
    }

    @Override
    public void sendTitle(@NotNull String title, @NotNull String subTitle, int fadeIn, int showTime, int fadeOut) {
        this.title.sendTitle(title, subTitle, fadeIn, showTime, fadeOut);
    }

    @Override
    public void sendTitle(@NotNull String title, @NotNull String subTitle, int time) {
        this.title.sendTitle(title, subTitle, time, time, time);
    }

}
