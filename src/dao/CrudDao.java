package dao;

import java.io.Closeable;
import java.io.IOException;

public interface CrudDao {

    default void close(Closeable closeable) {
        try {
        if (closeable != null) {
            closeable.close();
        } } catch (IOException e){
            e.printStackTrace();

        }


    }
}
