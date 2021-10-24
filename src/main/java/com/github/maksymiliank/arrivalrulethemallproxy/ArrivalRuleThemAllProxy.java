package com.github.maksymiliank.arrivalrulethemallproxy;

import com.github.maksymiliank.rankmanager.Rank;
import com.github.maksymiliank.rankmanager.RankManager;
import net.md_5.bungee.api.plugin.Plugin;

public class ArrivalRuleThemAllProxy extends Plugin {

    private static RankManager rankManager;

    @Override
    public void onEnable() {

    }

    public static Rank getRank(String player) {
        return rankManager.getRankByPlayer(player).orElseThrow(
                () -> new PlayerNotFoundException(String.format("Player %s is not in the rank manager", player))
        );
    }
}
