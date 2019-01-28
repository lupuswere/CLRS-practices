package net.lilifei.algorithm.clrs.v2.generate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ListConfiguration extends Configuration {

    private final int numberOfElements;

    public static ListConfiguration of(final int numberOfElements) {
        return ListConfiguration.builder()
                .numberOfElements(numberOfElements)
                .build();
    }
}
