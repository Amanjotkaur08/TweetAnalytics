package service;

import static org.junit.Assert.assertThat;
import static play.inject.Bindings.bind;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

import org.hamcrest.CoreMatchers;
import org.hamcrest.collection.IsMapContaining;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.Helpers;
import util.JsonHelper;

public class TwitterServiceImplTest {
	
private static Application testApp;
	
	@BeforeClass
	public static void initTestApp() {
		testApp = new GuiceApplicationBuilder()
				.overrides(bind(TwitterService.class).to(TwitterMockServiceImpl.class))
				.build();
	}
	
	@Test
	public void getTweetsAsync() {	
		TwitterService twitterService = testApp.injector().instanceOf(TwitterService.class);
		CompletionStage<JsonNode> completionStageJsonNode = twitterService.getTweetsAsync(null, null, null, null);
		try {
			JsonNode jsonNode = completionStageJsonNode.toCompletableFuture().get();
			List<Map<String, JsonNode>> list = JsonHelper.groupByText(jsonNode);
			Map<String, JsonNode> map = list.get(0);
			
			//1. Test size
			assertThat(map.size(), CoreMatchers.is(6));
			//2. Test map key
			assertThat(map, IsMapContaining.hasKey("@Banks ?"));
			
			JsonNode json = map.get("@Banks ?");
			//3. Test json user node not null
			assertThat(json, CoreMatchers.notNullValue());
			//4. Test json user name 		
			assertThat("Ed Shepherd", CoreMatchers.is(json.findValue("name").asText()));
			
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(true, CoreMatchers.is(false));	
		} 
	}
	
	@Test
	public void getHomeTimeLineAsync() {
		TwitterService twitterService = testApp.injector().instanceOf(TwitterService.class);
		CompletionStage<JsonNode> completionStageJsonNode = twitterService.getHomeTimeLineAsync(null, null, null);
		try {
			JsonNode jsonNode = completionStageJsonNode.toCompletableFuture().get();
			Map<String, String> map = JsonHelper.groupByLocDesc(jsonNode);
			//1. Test size
			assertThat(map.size(), CoreMatchers.is(1));		
			String location = "Hyrule";			
			String desc = map.get(location);
			//2. Test json desc		
			assertThat(desc, CoreMatchers.notNullValue());
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(true, CoreMatchers.is(false));	
		} 
	}
	
	@Test
	public void getUserTimelineAsync() {
		TwitterService twitterService = testApp.injector().instanceOf(TwitterService.class);
		CompletionStage<JsonNode> completionStageJsonNode = twitterService.getUserTimelineAsync(null, null, null, null);
		try {
			JsonNode jsonNode = completionStageJsonNode.toCompletableFuture().get();
			Map<String, String> map = JsonHelper.groupByLocDesc(jsonNode);
			//1. Test size
			assertThat(map.size(), CoreMatchers.is(1));		
			String location = "Hyrule";			
			String desc = map.get(location);
			//2. Test json desc		
			assertThat(desc, CoreMatchers.notNullValue());
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(true, CoreMatchers.is(false));	
		}
	}
	
	@AfterClass
	public static void stopTestApp() {
		Helpers.stop(testApp);
	}
	
}
