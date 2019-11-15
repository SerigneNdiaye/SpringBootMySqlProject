package demba.projetTestMysql;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(BlockJUnit4ClassRunner.class)
public class ExempleConditionnelTest {

	@Mock
	private IRien rien;
	
	@Before // Roule avant chaque test
	public void setUp() { 
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSetZero_valeurZero() {
		ExempleConditionel ex = new ExempleConditionel(0, rien);
		
		ex.setValeurZero();
		
		Assert.assertEquals("", 0, ex.getValeur());
		verifyZeroInteractions(rien);
	}

	@Test
	public void testSetZero_valeurAutre() {
		ExempleConditionel ex = new ExempleConditionel(100, rien);
		
		ex.setValeurZero();
		
		Assert.assertEquals("", 0, ex.getValeur());
		verify(rien).rien();
	}
}
