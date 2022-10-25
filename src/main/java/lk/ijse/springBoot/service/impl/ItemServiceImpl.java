package lk.ijse.springBoot.service.impl;

import lk.ijse.springBoot.dto.ItemDto;
import lk.ijse.springBoot.entity.Customer;
import lk.ijse.springBoot.entity.Item;
import lk.ijse.springBoot.repo.ItemRepo;
import lk.ijse.springBoot.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveItem(ItemDto itemDto) {
        if(!repo.existsById(itemDto.getCode())){
            Item item=mapper.map(itemDto,Item.class);
            repo.save(item);
        }else{
            throw new RuntimeException("Item Already Exists!");
        }
    }

    @Override
    public void deleteItem(String id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the Item code");
        }
    }

    @Override
    public void updateItem(ItemDto itemDto) {
        if(repo.existsById(itemDto.getCode())){
            Item item=mapper.map(itemDto,Item.class);
            repo.save(item);
        }else{
            throw new RuntimeException("NoSuch Item");
        }
    }

    @Override
    public ItemDto searchItem(String id) {
        if(repo.existsById(id)){
            Item item = repo.findById(id).get();
            ItemDto map = mapper.map(item, ItemDto.class);
            return map;
        }else{
            throw new RuntimeException("No Item");
        }
    }

    @Override
    public List<ItemDto> getAllItem() {
        List<Item>all=repo.findAll();
        return mapper.map(all,new TypeToken<List<ItemDto>>(){}.getType());
    }

    @Override
    public ItemDto getItemDetails(String code) {
        return null;
    }

    @Override
    public boolean checkAvailability(String code) {
        if (repo.existsById(code)) {
            return true;
        }else{
            return false;
        }
    }
}
