package com.example.Software.project.Controller.Item;

import com.example.Software.project.Controller.Auth.MessageResponse;
import com.example.Software.project.Entity.DTO.ItemDTO;
import com.example.Software.project.Entity.Item.Item;
import com.example.Software.project.Repo.Item.ItemRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemCon {

    private final ItemRepo itemRepo;

    public ItemCon(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }


    @PostMapping("/addItem")
    public ResponseEntity<String> addItems(@RequestBody Item item) {
        try {
            itemRepo.save(item);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item Added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.toString());
        }
    }

    @GetMapping("/getAllItem")
    public ResponseEntity<?> getAllItem() {
        try {
            List<Item> items = itemRepo.findAll();
            return ResponseEntity.ok().body(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/getItem")
    public ResponseEntity<?> getItem(@RequestParam String id) {
        try {
            Optional<Item> items = itemRepo.findById(id);
            return ResponseEntity.ok().body(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/updateItem")
    public ResponseEntity<?> updateItem(@Valid @RequestBody ItemDTO itemDTO) {
        try {
            Optional<Item> optionalItem = itemRepo.findById(itemDTO.getId());
            if (optionalItem.isPresent()) {
                Item item = optionalItem.get();
                item.setIndoorMod(itemDTO.getIndoorMod());
                item.setOutdoorMod(itemDTO.getOutdoorMod());
                item.setCapacity(itemDTO.getCapacity());
                item.setName(itemDTO.getName());
                item.setManufacturer(itemDTO.getManufacturer());
                itemRepo.save(item);
                return ResponseEntity.ok(new MessageResponse("Item updated successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + itemDTO.getId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating item: " + e.getMessage());
        }
    }

    @DeleteMapping("/dltItem")
    public ResponseEntity<MessageResponse> dltItem(@RequestParam String id) {
        Optional<Item> optionalItem = itemRepo.findById(id);
        try {
            if (optionalItem.isPresent()) {
                itemRepo.delete(optionalItem.get());
                return ResponseEntity.ok(new MessageResponse("Item deleted Successfully"));
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Item not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error deleting item: " + e.getMessage()));
        }
    }

    @DeleteMapping("/clearAllItems")
    public ResponseEntity<MessageResponse> clearAllItems() {
        try {
            itemRepo.deleteAll();
            return ResponseEntity.ok(new MessageResponse("Successfully delete all items"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error delete all items: " + e.getMessage()));
        }
    }

}
