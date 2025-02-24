package pkg;

import com.visa.api.BookRepo;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<BookRepo> loader = ServiceLoader.load(BookRepo.class);
        loader.forEach(BookRepo::saveBook);
    }
}
