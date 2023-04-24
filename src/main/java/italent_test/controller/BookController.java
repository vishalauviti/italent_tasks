package italent_test.controller;

import italent_test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/data-migration")
    public ResponseEntity<String> bookDataMigrator(@RequestParam("file") MultipartFile file){
        boolean response = bookService.bookDataMigrator(file);

        if(response){
            return new ResponseEntity<>("CSV Data migrated Successfully.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went wrong while reading the csv file.", HttpStatus.BAD_REQUEST);
    }

}
