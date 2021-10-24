package com.github.maksymiliank.arrivalrulethemallproxy;

import com.github.maksymiliank.rankmanager.RankManager;
import net.md_5.bungee.api.event.PermissionCheckEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.slf4j.Logger;

public class PermissionCheckListener implements Listener {

    private final Logger logger;
    private final RankManager rankManager;

    public PermissionCheckListener(Logger logger, RankManager rankManager) {
        this.logger = logger;
        this.rankManager = rankManager;
    }

    @EventHandler
    public void onPermissionCheck(PermissionCheckEvent event) {
        var rank = rankManager.getRankByPlayer(event.getSender().getName());
        if (rank.isPresent()) {
            event.setHasPermission(rank.get().hasPermission(event.getPermission()));
        } else {
            logger.warn("Player {} is not in the rank manager", event.getSender().getName());
            event.setHasPermission(false);
        }
    }
}
