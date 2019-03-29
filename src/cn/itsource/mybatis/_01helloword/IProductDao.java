package cn.itsource.mybatis._01helloword;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.List;

public interface IProductDao {
    void save(Product product);

    void update(Product product);

    void delete(Long id);

    Product findOne(Long id) throws IOException;

    List<Product> findAll() throws IOException;
}
