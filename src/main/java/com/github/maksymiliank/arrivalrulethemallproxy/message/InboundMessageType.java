package com.github.maksymiliank.arrivalrulethemallproxy.message;

public enum InboundMessageType {

    RANK_LIST (1000);

    private final int type;

    InboundMessageType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
