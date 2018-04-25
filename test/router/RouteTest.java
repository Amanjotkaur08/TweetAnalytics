//package controllers;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.mock;
//import static play.inject.Bindings.bind;
//import static play.mvc.Http.Status.OK;
//import static play.mvc.Http.Status.SEE_OTHER;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.hamcrest.CoreMatchers;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.google.common.collect.ImmutableMap;
//
//import io.gatling.http.request.builder.RequestBuilder;
//import models.Tweet;
//import play.Application;
//import play.core.j.JavaContextComponents;
//import play.data.Form;
//import play.data.FormFactory;
//import play.i18n.MessagesApi;
//import play.inject.guice.GuiceApplicationBuilder;
//import play.mvc.Call;
//import play.mvc.Http;
//import play.mvc.Result;
//import play.test.Helpers;
//import play.test.WithApplication;
//import service.TwitterMockServiceImpl;
//import service.TwitterService;
//
//import static play.test.Helpers.fakeApplication;
//import static play.test.Helpers.running;
//
//public class RouteTest extends WithApplication {
//	private static Application testApp;
//	@BeforeClass
//	public static void initTestApp() {
//		testApp = new GuiceApplicationBuilder().overrides(bind(TwitterService.class).to(TwitterMockServiceImpl.class))
//				.build();
//	}
//
//	@Before
//	public void setUp() {
//		// play.mvc.Http.RequestBuilder fakeRequest = Helpers.fakeRequest(Call action);
//		// without it the test cry -> java.lang.RuntimeException: There is no HTTP
//		// Context available from here.
//		Map<String, String> flashData = Collections.emptyMap();
//		Map<String, String> sessionData = Collections.emptyMap();
//		Map<String, Object> argData = Collections.emptyMap();
//		Http.Request requestMock = mock(Http.Request.class);
//		Long id = 2L;
//		play.api.mvc.RequestHeader header = mock(play.api.mvc.RequestHeader.class);
//		JavaContextComponents contextComponents = app.injector().instanceOf(JavaContextComponents.class);
//
//		Http.Context context = new Http.Context(id, header, requestMock, sessionData, flashData, argData,
//				contextComponents);
//		Http.Context.current.set(context);
//	}
//	@Test
//	   public void testIndex() {
//	       Result result = route(testApp , Helpers.fakeRequest("GET", "/"));
//	       assertThat(result).isNotNull();
//	   }
//	//@Test
////	   public void testTwitterHomeTimeline() {
////	       Result result =Helpers.fakeRequest("GET", "/twitter/homeTimeline");
////	       assertThat(result).isNotNull();
////	   }
////	@Test
////	   public void testTwitterAuth() {
////	       Result result = route(fakeRequest(GET, "/twitter/auth "));
////	       assertThat(result).isNotNull();
////	   }
////	@Test
////	   public void testStream() {
////	       Result result = route(fakeRequest(GET, "/h"));
////	       assertThat(result).isNotNull();
////	   }
////	@Test
////	   public void testWebscoket() {
////	       Result result = route(fakeRequest(GET, "/h/ws"));
////	       assertThat(result).isNotNull();
////	   }
////	@Test
////	   public void testSearchTweets() {
////	       Result result = route(fakeRequest(GET, "/searchTweets"));
////	       assertThat(result).isNotNull();
////	   }
////	@Test
////	   public void testgetTweets() {
////	       Result result = route(fakeRequest(GET, "/get_tweets/bank"));
////	       assertThat(result).isNotNull();
////	   }
////	@Test
////	   public void testgetUserTimeLine() {
////	       Result result = route(fakeRequest(GET, "/get_usertimeline/bank"));
////	       assertThat(result).isNotNull();
////	   }
//}
