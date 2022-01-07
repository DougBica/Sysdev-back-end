package br.com.sysve.produto.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDto implements Serializable {
    private final UUID uuid;
    private final Integer version;
    private final boolean active;
    private final String name;
    private final Long quantity;
    private final BigDecimal unitValue;
    private final Long barCode;
    private final String imagePath;
}
