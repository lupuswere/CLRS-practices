package net.lilifei.algorithm.clrs.v2.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DataObject {

    private final int value;

    public static DataObject of(final int value) {
        return DataObject.builder()
                .value(value)
                .build();
    }
}
