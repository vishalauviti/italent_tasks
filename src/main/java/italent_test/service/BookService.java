package italent_test.service;

import italent_test.Repo.BookRepo;
import italent_test.model.Book;
import italent_test.utils.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    @Retryable
    public boolean bookDataMigrator(MultipartFile csvFile){

        try {
            List<Book> bookList = CSVUtil.csvToTutorials(csvFile.getInputStream());
            bookRepo.saveAll(bookList);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
