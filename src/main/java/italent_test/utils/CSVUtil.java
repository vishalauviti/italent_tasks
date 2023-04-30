package italent_test.utils;

import italent_test.model.Book;

import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CSVUtil {

        public static List<Book> csvToTutorials(InputStream is) {
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                 CSVParser csvParser = new CSVParser(fileReader,
                         CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

                List<Book> bookList = new ArrayList<>();

                Iterable<CSVRecord> csvRecords = csvParser.getRecords();

                for (CSVRecord csvRecord : csvRecords) {
                    Book book = Book.builder()
                            .bookName(csvRecord.get("Name"))
                            .bookAuthor(csvRecord.get("Author"))
                            .publishedDate(new Date(csvRecord.get("Published")))
                            .price(Double.parseDouble(csvRecord.get("Price")))
                            .description(csvRecord.get("Description"))
                            .numberOfPages(Integer.parseInt(csvRecord.get("Pages")))
                            .language(csvRecord.get("Language"))
                            .publisher(csvRecord.get("Publisher"))
                            .rating(Integer.parseInt(csvRecord.get("Rating")))
                            .build();

                    bookList.add(book);
                }

                return bookList;
            } catch (IOException e) {
                throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
            }
        }
}

