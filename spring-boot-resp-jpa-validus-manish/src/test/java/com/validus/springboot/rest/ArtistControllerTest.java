package com.validus.springboot.rest;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.validus.springboot.rest.model.Artist;
import com.validus.springboot.rest.service.ArtistService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ArtistControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ArtistService artistService;
	
	Artist mockArtist = new Artist(1L, "Muse", new Timestamp(System.currentTimeMillis()), 
			new Timestamp(System.currentTimeMillis()));

	@Test
	public void retrieveArtist() throws Exception {

		Mockito.when(artistService.retrieveArtist(Mockito.anyLong())).thenReturn(mockArtist);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/artists/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{id:1,name:Muse}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);

	}

	
	
	
}