package com.example.Software.project.Controller.Item;

import com.example.Software.project.Entity.Item.Item;
import com.example.Software.project.Entity.ServiceAgreement.ServiceAgreement;
import com.example.Software.project.Repo.Item.ItemRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemCon {

    private final ItemRepo itemRepo;

    public ItemCon(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }


    @PostMapping("/addItem")
    public ResponseEntity<String> addService(@RequestBody Item item){
        try {
            itemRepo.save(item);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item Added successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: "+e.toString());
        }
    }

    @PostMapping("/getAllItem")
    public ResponseEntity<?> findServices(){
        try {
            List<Item> items = itemRepo.findAll();
            return ResponseEntity.ok().body(items);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: "+e.getMessage());
        }
    }
}
