package com.github.maksymiliank.arrivalrulethemallproxy;

import com.github.maksymiliank.arrivalpostofficeproxy.ArrivalPostOfficeProxy;
import com.github.maksymiliank.arrivalrulethemallproxy.message.*;
import com.github.maksymiliank.rankmanager.Rank;
import com.github.maksymiliank.rankmanager.RankManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ArrivalRuleThemAllProxy extends Plugin {

    private static RankManager rankManager;

    private final CompletableFuture<RankListInboundMessage> rankListReceived = new CompletableFuture<>();
    private final Gson gson = new Gson();

    @Override
    public void onEnable() {
        ArrivalPostOfficeProxy.addApiListener(InboundMessageType.RANK_LIST.getType(), this::onRankList);
        ArrivalPostOfficeProxy.sendToApi(
                new RankListOutboundMessage(ArrivalPostOfficeProxy.PROXY_SERVER_ID)
        );

        RankListInboundMessage message;
        try {
            message = rankListReceived.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Error while getting rank list");
        }

        var ranks = message.getRanks().stream()
                .map(this::rankDtoToRank)
                .collect(Collectors.toList());

        rankManager = new RankManager(ranks);
    }

    public static Rank getRank(String player) {
        return rankManager.getRankByPlayer(player).orElseThrow(
                () -> new PlayerNotFoundException(String.format("Player %s is not in the rank manager", player))
        );
    }

    private void onRankList(JsonObject message) {
        var rankList = gson.fromJson(message, RankListInboundMessage.class);
        rankListReceived.complete(rankList);
    }

    private Rank rankDtoToRank(RankDto rank) {
        return Rank.builder()
                .id(rank.getId())
                .level(rank.getLevel())
                .name(rank.getName())
                .displayName(rank.getDisplayName())
                .chatFormat(rank.getChatFormat())
                .rankPermissions(rank.getPermissions())
                .rankNegatedPermissions(rank.getNegatedPermissions())
                .build();
    }
}
