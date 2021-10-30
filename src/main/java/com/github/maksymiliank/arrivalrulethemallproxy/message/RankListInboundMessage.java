package com.github.maksymiliank.arrivalrulethemallproxy.message;

import com.github.maksymiliank.arrivalwebsocketutils.message.InboundServerMessage;

import java.util.List;

public final class RankListInboundMessage extends InboundServerMessage {

    private List<RankDto> ranks;

    public List<RankDto> getRanks() {
        return ranks;
    }

    public RankListInboundMessage setRanks(List<RankDto> ranks) {
        this.ranks = ranks;
        return this;
    }

    @Override
    public int getType() {
        return InboundMessageType.RANK_LIST.getType();
    }
}
