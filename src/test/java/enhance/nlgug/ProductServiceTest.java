package enhance.nlgug;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;


public class ProductServiceTest {

    private ProductService productService;

    // its collaborators
    private ProductRepository productRepository;
    private Emailer emailer;
    private Product product;
    private AuthorizationService authorizationService;

    @Before
    public void before(){
        this.productRepository = mock(ProductRepository.class);
        this.emailer = mock(Emailer.class);
        this.authorizationService = mock(AuthorizationService.class);
        this.productService = new ProductServiceImpl(productRepository, emailer, authorizationService);

        product = new Product();
        product.setId(14L);
        product.setName("foo");
        product.setStock(10);
    }

    @Test
    public void emailMustBeSentWhenStockLimitWasHit(){
        int originalStock = product.getStock();
        try {
            when(productRepository.getProduct(product.getId())).thenReturn(product);
            productService.sell(product.getId(), originalStock + 1);
            fail("exception should have been thrown");

        } catch (OutOfStockException e) {
            verify(emailer, times(1)).sendOutOfStockEmail(product);
            assertTrue("stock must same as before", originalStock == product.getStock());
        }

    }
}
