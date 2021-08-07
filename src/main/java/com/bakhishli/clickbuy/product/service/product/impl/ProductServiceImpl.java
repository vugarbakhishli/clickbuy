package com.bakhishli.clickbuy.product.service.product.impl;

import com.bakhishli.clickbuy.product.domain.Product;
import com.bakhishli.clickbuy.product.domain.ProductImage;
import com.bakhishli.clickbuy.product.domain.elasticsearch.ProductElasticsearch;
import com.bakhishli.clickbuy.product.domain.enums.MoneyType;
import com.bakhishli.clickbuy.product.repository.mongo.product.ProductRepository;
import com.bakhishli.clickbuy.product.service.product.ProductService;
import com.bakhishli.clickbuy.product.service.product.dto.request.ProductRequestDto;
import com.bakhishli.clickbuy.product.service.product.dto.response.ProductResponseDto;
import com.bakhishli.clickbuy.product.service.product.dto.response.ProductSellerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static com.bakhishli.clickbuy.product.domain.enums.ImageType.FEATURE;
import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductElasticsearchServiceImpl productElasticsearchService;
    private final ProductRepository productRepository;
    private final ProductDeliveryServiceImpl productDeliveryService;
    private final ProductAmountServiceImpl productAmountService;
    private final ProductImageServiceImpl productImageService;

    @Override
    public ProductResponseDto crete(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setDescription(productRequestDto.getDescription());
        product.setActive(Boolean.TRUE);
        product.setCategoryId(productRequestDto.getCategoryId());
        product.setCompanyId(productRequestDto.getCompanyId());
        product.setPrice(productRequestDto.getPrice());
        product.setName(productRequestDto.getName());
        product.setFeatures(productRequestDto.getFeatures());
        product.setCode("PR0014FX");
        product.setImage(productRequestDto.getImages().stream().map(item
                -> new ProductImage(FEATURE, item)).collect(toList()));

        Product savedProduct = productRepository.save(product).block();
        assert savedProduct != null;
        return this.mapToDto(productElasticsearchService.create(savedProduct).block());
    }

    @Override
    public Flux<ProductResponseDto> getAll() {
        return productElasticsearchService.findAll().map(this::mapToDto);
    }

    @Override
    public Mono<Long> count() {
        return productRepository.count();
    }

    @Override
    public ProductResponseDto mapToDto(ProductElasticsearch productElasticsearch) {
        if(productElasticsearch == null){
            return null;
        }
        return ProductResponseDto.builder()
                .id(productElasticsearch.getId())
                // TODO: validating over client request
                .price(productElasticsearch.getPrice().get(MoneyType.USD))
                .currencySymbol(MoneyType.USD.getCurrencySymbol())
                .name(productElasticsearch.getName())
                .features(productElasticsearch.getFeatures())
                .description(productElasticsearch.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryDetails(productElasticsearch.getId()))
                .categoryId(productElasticsearch.getCategory().getId())
                .available(productAmountService.getByProductId(productElasticsearch.getId()))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(productElasticsearch.getId(), productElasticsearch.getPrice().get(MoneyType.USD),MoneyType.USD))
                .image(productImageService.getProductMainImage(productElasticsearch.getId()))
                .seller(ProductSellerResponseDto.builder().id(productElasticsearch.getSeller().getId()).name(productElasticsearch.getSeller().getName()).build())
                .build();
    }
}
