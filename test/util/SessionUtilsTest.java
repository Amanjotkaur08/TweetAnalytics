package util;

import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

import play.mvc.Http.Session;

public class SessionUtilsTest {

	static Session session;
	
	@BeforeClass 
	public static void init() throws Exception {
		Map<String, String> mapSession = new HashMap<>();
		session = new Session(mapSession);
	}
	
	@Test
	public void isSessionActive() {
		SessionUtils.saveToken(session, "1234567890");
		assertThat(SessionUtils.isSessionActive(session), CoreMatchers.is(true));
	}
	@Test
	public void isSessionActiveFalse() {
		Map<String, String> mapSession = new HashMap<>();
		session = new Session(mapSession);
		assertThat(SessionUtils.isSessionActive(session), CoreMatchers.is(false));
	}
	
	@Test
	public void getToken() {
		SessionUtils.saveToken(session, "33465645655");
		assertThat(SessionUtils.getToken(session), CoreMatchers.is(CoreMatchers.equalTo("33465645655")));
	}
	@Test
	public void getSecret() {
		SessionUtils.saveSecret(session, "7676878768");
		assertThat(SessionUtils.getSecret(session), CoreMatchers.is(CoreMatchers.equalTo("7676878768")));
	}
	@Test
	public void saveKeys() {
		SessionUtils.saveKeys(session, "2222322", "44454544");
		assertThat(SessionUtils.getToken(session), CoreMatchers.is(CoreMatchers.equalTo("2222322")));
		assertThat(SessionUtils.getSecret(session), CoreMatchers.is(CoreMatchers.equalTo("44454544")));
	}
}
