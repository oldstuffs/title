package io.github.portlek.title.api;

import org.jetbrains.annotations.NotNull;

public interface ITitle {

    void sendTitle(@NotNull final String title, @NotNull final String subTitle, final int fadeIn, final int showTime, int fadeOut);

}
