package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.ItemDto;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDto itemDto);

    void deleteItem(String id);

    void updateItem(ItemDto itemDto);

    ItemDto searchItem(String id);

    List<ItemDto> getAllItem();

    ItemDto getItemDetails(String code);
    boolean checkAvailability(String code);
}
