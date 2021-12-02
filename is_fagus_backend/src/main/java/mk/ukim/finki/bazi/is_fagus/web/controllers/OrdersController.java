package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.Naracka;
import mk.ukim.finki.bazi.is_fagus.model.dto.OrderDto;
import mk.ukim.finki.bazi.is_fagus.model.dto.OrderExtraPartsDto;
import mk.ukim.finki.bazi.is_fagus.service.OrdersService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/order")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/array")
    public ResponseEntity<Naracka> order(@RequestBody OrderDto dto,
                                         @AuthenticationPrincipal String username) throws JSONException {

        return this.ordersService.order(username,parseJsonIds(dto.getIdS()),parseJsonQuantitie(dto.getQuantity()))
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    private List<Long> parseJsonIds(String json) throws JSONException {
        List<Long> list=new ArrayList<>();
        JSONArray array = new JSONObject(json).getJSONArray("data");
        for (int i = 0; i < array.length()-1; i+=2) {
                Long id= array.getLong(i);
                list.add(id);
        }
        return list;

    }
    private List<Integer> parseJsonQuantitie(String json) throws JSONException {
        List<Integer> list=new ArrayList<>();
        JSONArray array = new JSONObject(json).getJSONArray("data");
        for (int i = 0; i < array.length()-1; i+=2) {
            Integer quantity=array.getInt(i);
            list.add(i);
        }
        return list;
    }
    @PutMapping("/{orderId}")
    public ResponseEntity<Naracka> shippedOrder(@PathVariable Long orderId){
        return this.ordersService.orderShipped(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/parts")
    public ResponseEntity<Naracka> orderExtraParts(@RequestBody OrderExtraPartsDto dto){
      return  this.ordersService.orderExtraParts(dto)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
}
