package demo.iib.ci;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;

public class TestClient {

	public static void main(String[] args) throws IOException {

		System.out.println("-------------------------------");

		testHTTP(new URL("http://localhost:7802/HTTPESQLTest"), req);
		testHTTP(new URL("http://localhost:7802/HTTPJavaTest"), req);
	}
	private static void testHTTP(final URL url, final String s) throws IOException {

		System.out.println("-------- IIB HTTP test --------");
		System.out.println(url);

		final HttpURLConnection c = (HttpURLConnection)url.openConnection();

		c.setDoOutput(true);
		c.setRequestProperty("Accept-Charset", cs.name());
		c.setRequestProperty("Content-Type", "application/octet-stream");

		try (final OutputStream output = c.getOutputStream()) {
			output.write(s.getBytes(cs));
		}

		final int status = c.getResponseCode();
		final String sMsg = "HTTP response: " + status + " " + c.getResponseMessage();

		if (status != HttpURLConnection.HTTP_OK)
			throw new Error(sMsg);

		System.out.println(sMsg);
		System.out.println("\"" + readResponse(new InputStreamReader(c.getInputStream(), cs)) + "\"");
	}
	private static String readResponse(InputStreamReader r) throws IOException {
		return readResponse(r, 4096);
	}
	private static String readResponse(InputStreamReader r, int bufSize) throws IOException {

		int nTotalRead = 0;
		final LinkedList<char[]> l = new LinkedList<>();

		for (;;) {

			final char[] b = new char[bufSize];
			final int n = r.read(b);

			if (n < 0)
				break;
			if (n < bufSize) {
				final char[] b2 = new char[n];
				System.arraycopy(b, 0, b2, 0, n);
				l.push(b2);
			} else {
				l.push(b);
			}
			nTotalRead += n;
		}

		final StringBuilder b = new StringBuilder(nTotalRead);

		for (final char[] c : l) {	b.append(c); }

		return b.toString();
	}
	private static final Charset cs = Charset.forName("UTF-8");
	private static final String req = "TestRequestMessage";
}
