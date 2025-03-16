import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ruban
 * @author {@link https://www.linkedin/in/rubandivyaraj}
 * @apiNote To generate sequence unique id.
 * @implNote Not an exact twitter snow flake algorithm but it helps to generate
 *           unique sequence id.
 */
public class SequenceIdGenerator {
	private static String hostname;
	private static long sequenceId = 1000L;
	private static long lastTimestamp = -1L;

	public static void main(String[] args) {
		System.out.println(generateSeqId());
	}

	public static synchronized String generateSeqId() {
		long currentTimestamp = getTimestamp();
		if (currentTimestamp != lastTimestamp) {
			lastTimestamp = currentTimestamp;
			sequenceId = 1000;
		}
		return String.valueOf(currentTimestamp) + getMachineId() + getSequenceId();
	}

	private static String getMachineId() {
		if (hostname == null) {
			try {
				// If system required numeric
				// hostname = Math.abs(InetAddress.getLocalHost().getHostName().hashCode() % 1024);
				hostname = InetAddress.getLocalHost().getHostName().toUpperCase();
			} catch (UnknownHostException e) {
				e.printStackTrace();
				hostname = "01A";
			}
		}
		return hostname;
	}

	private static long getSequenceId() {
		if (sequenceId < 10000) {
			try {
				Thread.sleep(1);
				sequenceId = 1000;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sequenceId++;
	}

	private static long getTimestamp() {
		return System.currentTimeMillis();
	}

}