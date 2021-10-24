package com.github.maksymiliank.arrivalrulethemallproxy.message;

import java.util.List;

public final class RankListInboundMessage {

    private List<RankDto> ranks;

    public List<RankDto> getRanks() {
        return ranks;
    }

    public RankListInboundMessage setRanks(List<RankDto> ranks) {
        this.ranks = ranks;
        return this;
    }
}
