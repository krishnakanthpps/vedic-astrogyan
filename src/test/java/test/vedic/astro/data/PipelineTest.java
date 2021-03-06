package test.vedic.astro.data;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vedic.astro.calc.component.BirthChartPipelineGateway;

/**
 * Main class to invoke 
 * @author BruceWayne
 *
 */
public class PipelineTest extends BaseUtilTest{

	private static final Logger log = Logger.getLogger(PipelineTest.class);
	
	@Autowired
	private BirthChartPipelineGateway birthChartPipelineGateway;
	
	@Test
	public void testBirthChartPipeline() throws Exception {
		birthChartPipelineGateway.startBirthChartPipeline(super.prepareMember());
	}
}


