package cn.itsource.mybatis._01helloword;

import cn.itsource.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    //创建一个日志对象
    private Logger logger = Logger.getLogger(ProductDaoImpl.class);
    //注意： 在框架中你要做添加，修改，删除，都必须要开启事务

    /**
     * 数据库中存储引擎：
     *          1.MYISAM:它不支持事务（不支持提交，回滚）   特点： 操作性能非常的快，但是不安全
     *          2.INNODB：它支持事务（支持提交，回滚）      特点：操作性能较慢，但是安全
     * @param product
     */
    @Override
    public void save(Product product) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            String statement = "cn.itsource.mybatis._01helloword.IProductDao.save";
            session.insert(statement,product);
            session.commit();//提交事务
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();//事务回滚
            }
        } finally {
            MyBatisUtil.close(session);
        }
    }

    @Override
    public void update(Product product) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            String statment = "cn.itsource.mybatis._01helloword.IProductDao.update";
            session.update(statment, product);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            MyBatisUtil.close(session);
        }

    }

    @Override
    public void delete(Long id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            String statment = "cn.itsource.mybatis._01helloword.IProductDao.delete";
            session.delete(statment, id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            MyBatisUtil.close(session);
        }
    }

    @Override
    public Product findOne(Long id)  {
        logger.trace("trace。。。。。。。。。。");
        logger.debug("debug..................");
        logger.info("info....................");
        logger.warn("warn......................");
        logger.error("error.................");

        SqlSession sqlSession = null;
        try {
            //获取SqlSession
            sqlSession = MyBatisUtil.getSession();
            //执行对应的sql语句
            String statement = "cn.itsource.mybatis._01helloword.IProductDao.findOne";
            Product product = (Product) sqlSession.selectOne(statement, id);
            logger.trace("查询成功！！！");
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.close(sqlSession);
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSession();
            //查询列表   statment = namespace+ id  定位到执行具体的某个sql语句
            String statment = "cn.itsource.mybatis._01helloword.IProductDao.findAll";
            List<Product> products = sqlSession.selectList(statment);
            sqlSession.close();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.close(sqlSession);
        }
        return null;
    }

   /* @Override
    public List<Product> findAll() {
        SqlSession sqlSession = null;
        try {
            //把xml文件转为io流
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //解析核心xml文件（获取SqlSessionFactory 相当于以前JPA中的EntityManagerFactory）
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //拿到连接对象(获取SqlSession相当于拿到连接对象也相当于以前的EntityManager)
            sqlSession = sqlSessionFactory.openSession();
            //查询列表   statment = namespace+ id  定位到执行具体的某个sql语句
            String statment = "cn.itsource.mybatis._01helloword.IProductDao.findAll";
            List<Product> products = sqlSession.selectList(statment);
            sqlSession.close();
            return products;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return null;
    }*/
}
