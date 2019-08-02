package io.github.portlek.title.api;

import org.jetbrains.annotations.NotNull;

public interface TitlePlayer {

    void clearTitle();

    void sendTitle(@NotNull final String title);

    void sendTitle(@NotNull final String title, @NotNull final String subTitle);

    void sendTitle(@NotNull final String title, final int fadeIn, final int showTime, int fadeOut);

    void sendTitle(@NotNull final String title, @NotNull final String subTitle, final int fadeIn, final int showTime, int fadeOut);

    void sendTitle(@NotNull final String title, @NotNull final String subTitle, final int time);

}