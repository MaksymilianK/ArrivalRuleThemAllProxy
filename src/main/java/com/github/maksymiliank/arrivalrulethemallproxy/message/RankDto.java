package com.github.maksymiliank.arrivalrulethemallproxy.message;

import java.util.List;

public class RankDto {

    private int id;
    private int level;
    private String name;
    private String displayName;
    private String chatFormat;
    private List<String> permissions;
    private List<String> negatedPermissions;

    public int getId() {
        return id;
    }

    public RankDto setId(int id) {
        this.id = id;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public RankDto setLevel(int level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RankDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public RankDto setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getChatFormat() {
        return chatFormat;
    }

    public RankDto setChatFormat(String chatFormat) {
        this.chatFormat = chatFormat;
        return this;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public RankDto setPermissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public List<String> getNegatedPermissions() {
        return negatedPermissions;
    }

    public RankDto setNegatedPermissions(List<String> negatedPermissions) {
        this.negatedPermissions = negatedPermissions;
        return this;
    }
}
