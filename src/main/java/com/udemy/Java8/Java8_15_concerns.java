package com.udemy.Java8;

import com.udemy.Java8.Asset.AssetType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Java8_15_concerns {
    private static final Logger logger = LogManager.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        List<Asset> assetList = Arrays.asList(
                new Asset(AssetType.Stock, 2000),
                new Asset(AssetType.Bond, 400),
                new Asset(AssetType.Bond, 500),
                new Asset(AssetType.Stock, 4000),
                new Asset(AssetType.Stock, 7000),
                new Asset(AssetType.Bond, 100)
        );
        System.out.println(Asset.total1(Collections.unmodifiableList(assetList)));
        System.out.println(Asset.total2(Collections.unmodifiableList(assetList), asset->asset.getType()==AssetType.Bond));
        System.out.println(Asset.total2(Collections.unmodifiableList(assetList), asset->asset.getType()==AssetType.Stock));

        System.out.println();
    }
}
