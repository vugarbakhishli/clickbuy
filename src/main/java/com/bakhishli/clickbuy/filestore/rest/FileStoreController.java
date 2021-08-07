package com.bakhishli.clickbuy.filestore.rest;

import com.bakhishli.clickbuy.filestore.service.FileStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/filestore")
@RequiredArgsConstructor
public class FileStoreController {

    private final FileStoreService fileStoreService;

    @GetMapping("/{id}")
    public Mono<Void> getImageById(@PathVariable String id, ServerWebExchange serverWebExchange) throws Exception{
        ServerHttpResponse response = serverWebExchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().setContentType(MediaType.IMAGE_JPEG);
        DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();

        return fileStoreService.getImage(id)
                .flatMap(img -> response.writeWith(Flux.just(dataBufferFactory.wrap(img))));
    }
}
