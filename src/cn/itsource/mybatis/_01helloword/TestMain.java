package cn.itsource.mybatis._01helloword;

import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class TestMain {
    //测试了一下git的使用流程是怎么样的
    private IProductDao dao = new ProductDaoImpl();

    @Test
    public void testDelete(){
        dao.delete(21L);
    }

    @Test
    public void testUpdate() throws IOException {
        Product product = dao.findOne(23L);
        product.setCutoff(new BigDecimal("0.99"));

        dao.update(product);
    }

    @Test
    public void testSave(){
        Product pro = new Product();
        pro.setProductName("测试产品名");
        pro.setBrand("凤凰牌");
        pro.setCostPrice(new BigDecimal("1000"));
        pro.setCutoff(new BigDecimal("0.2"));
//        pro.setDir_id(1L);
        pro.setSupplier("重庆供应商");
        pro.setSalePrice(new BigDecimal("2000"));
        dao.save(pro);
        System.out.println(pro);

    }

    @Test
    public void testFindAll() throws IOException {
        List<Product> list = dao.findAll();
        for (Product product : list) {
            System.out.println(product);
        }
    }
    @Test
    public void testFindOne() throws IOException {
        Product product = dao.findOne(1L);
        System.out.println(product);
    }
}
