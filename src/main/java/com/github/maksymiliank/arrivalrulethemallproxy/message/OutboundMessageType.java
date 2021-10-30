package com.github.maksymiliank.arrivalrulethemallproxy.message;

public enum OutboundMessageType {

    RANK_LIST (1000);

    private final int type;

    OutboundMessageType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
