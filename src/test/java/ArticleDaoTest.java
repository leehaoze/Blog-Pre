import edu.dao.Impl.ArticleDaoImpl;
import org.junit.Test;

public class ArticleDaoTest {
    private ArticleDaoImpl articleDao = new ArticleDaoImpl();


    @Test
    public void testGetById(){
        System.out.println(articleDao.getTitleById(1).get(0));
    }

}
