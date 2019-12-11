package com.udemy.Java8;

import java.util.List;
import java.util.function.Predicate;

public class Asset {
    public enum AssetType {Bond, Stock};
    private final AssetType type;
    private final int value;

    public Asset(final AssetType type, final int value) {
        this.type = type;
        this.value = value;
    }

    public AssetType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public static int total1(final List<Asset> assets) {
        return assets.stream().mapToInt(Asset::getValue).sum();
    }

    public static int total2(final List<Asset> assets, Predicate<Asset> assetFilter) {
        return assets.stream().filter(assetFilter).mapToInt(Asset::getValue).sum();
    }
}
