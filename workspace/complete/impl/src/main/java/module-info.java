import com.visa.api.BookRepo;
import com.visa.impl.BookRepoImpl;

module impl {
    requires util;
    provides BookRepo with BookRepoImpl;
}