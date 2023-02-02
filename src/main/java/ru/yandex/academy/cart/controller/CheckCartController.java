package ru.yandex.academy.cart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.academy.cart.model.dto.ItemError;
import ru.yandex.academy.cart.service.CheckCartService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CheckCartController {

    private final CheckCartService service;

    @GetMapping("check")
    public List<ItemError> checkCart(
            @RequestParam(name = "user_id") Long accountId,
            @RequestParam(name = "item_id") List<String> itemsId
    ) {
        return service.checkCart(accountId, itemsId);
    }

}
