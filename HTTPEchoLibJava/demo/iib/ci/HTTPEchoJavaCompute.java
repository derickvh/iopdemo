package demo.iib.ci;

import java.nio.charset.Charset;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;

public class HTTPEchoJavaCompute extends MbJavaComputeNode {
	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		final MbOutputTerminal out = getOutputTerminal("out");
		final MbMessage inMessage = inAssembly.getMessage();
		MbMessageAssembly outAssembly = null;
		try {
			final MbMessage outMessage = new MbMessage(inMessage);
			outAssembly = new MbMessageAssembly(inAssembly, outMessage);
			final Object o = inAssembly.getMessage().getRootElement().getFirstElementByPath("BLOB").getFirstElementByPath("BLOB").getValue();
			final String s = "HTTPJavaTest: foo " + new String((byte[])o, cs) + " bar";
			outAssembly.getMessage().getRootElement().getFirstElementByPath("BLOB").getFirstElementByPath("BLOB").setValue(s.getBytes(cs));
		}
		catch (MbException e) {
			throw e;
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new MbUserException(this, "evaluate()", "", "", e.toString(), null);
		}
		out.propagate(outAssembly);
	}
	private static final Charset cs = Charset.forName("UTF-8");
}
