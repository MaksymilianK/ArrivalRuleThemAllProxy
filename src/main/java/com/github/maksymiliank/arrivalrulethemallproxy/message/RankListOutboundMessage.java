package com.github.maksymiliank.arrivalrulethemallproxy.message;

import com.github.maksymiliank.arrivalwebsocketutils.message.OutboundServerMessage;

public final class RankListOutboundMessage extends OutboundServerMessage {

    public RankListOutboundMessage(int server) {
        super(OutboundMessageType.RANK_LIST.getType(), server);
    }
}
